package meituan.consistenthash;

import meituan.common.Util;

import java.util.*;

/**
 * Created by ballontt on 2017/6/26.
 */
public class TestConsHash {
    private static ConsistentHash consistentHash = null;
    private static HashMap<String, Integer> serverLoadMap = null;
    private static LinkedList<String> serverNodes = null;
    private static LinkedList<String> clientNodes = null;
    private static HashMap<String, List<String>> clientServerMap = null;
    private static int clientNum = 100000;

    public static void main(String[] args) {

        serverNodes = new LinkedList<String>();
        serverNodes.add("192.168.10.1");
        serverNodes.add("192.168.10.2");
        serverNodes.add("192.168.10.3");
        serverNodes.add("192.168.10.4");

        init();

        //添加节点
        addServer("192.168.10.5");

        //移除节点
        removeServer("192.168.10.4");

        //循环更新节点
        List<String> addServers = new LinkedList<String>();
        addServers.add("192.168.10.6");
        List<String> removeServers = new LinkedList<String>();
        removeServers.add("192.168.10.5");
        changeServer(addServers, removeServers);

    }

    public static void init() {
        serverLoadMap = new HashMap<String, Integer>();
        for (String node : serverNodes) {
            serverLoadMap.put(node, 0);
        }

        // 虚拟节点数少了，一致性hash无法保证分布的均匀
        consistentHash = new ConsistentHash(serverNodes, 200);

        // 产生10000个ip
        clientNodes = new LinkedList<>();
        clientServerMap = new HashMap<String, List<String>>();
        for (int i = 0; i < clientNum; i++) {
            String clientIp = Util.getIp();
            clientNodes.add(clientIp);

            // 客户端连接的三个服务端
            List<String> serverIps = getThreeServer(clientIp);
            clientServerMap.put(clientIp, serverIps);

            //记录服务端的负载
            for (String serverIp : serverIps) {
                int load = serverLoadMap.get(serverIp);
                serverLoadMap.put(serverIp, load + 1);
            }
        }

        // 打印每一台服务器的连接数
        for (Map.Entry<String, Integer> entry : serverLoadMap.entrySet()) {
            System.out.println("Ip: " + entry.getKey() + ", " + "connection num:" + entry.getValue());
        }
    }

    public static void addServer(String server) {
        List<String> addServers = new LinkedList<String>();
        addServers.add(server);
        changeServer(addServers, null);
    }

    public static void removeServer(String server) {
        List<String> removeServers = new LinkedList<String>();
        removeServers.add(server);
        changeServer(null, removeServers);
    }


    // 服务端服务器数量的变化
    private static void changeServer(List<String> addServers, List<String>removeServers) {
        System.out.println("==========================================");
        System.out.println("新增ip: " + addServers);
        System.out.println("移除ip: " + removeServers);
        if(addServers != null && !addServers.isEmpty()) {
            serverNodes.addAll(addServers);
            consistentHash.addNodeList(addServers);
        }
        if(removeServers != null && !removeServers.isEmpty()) {
            serverNodes.removeAll(removeServers);
            consistentHash.removeNodeList(removeServers);
        }

        //负载清0
        serverLoadMap.clear();
        for(String  tmpServer : serverNodes) {
            serverLoadMap.put(tmpServer, 0);
        }

        int connChangeNum = 0;
        int clientChangeNum = 0;
        HashMap<String, List<String>> newClientServer = new HashMap<String, List<String>>();
        for(String client : clientNodes) {
            List<String> newServers = getThreeServer(client);
            newClientServer.put(client, newServers);

            List<String> oldServers = clientServerMap.get(client);
            boolean modFlag = false;
            for(String newServer : newServers) {
                if(!oldServers.contains(newServer)) {
                    connChangeNum++;
                    if(!modFlag) {
                        clientChangeNum++;
                        modFlag = true;
                    }
                }
            }

            //记录服务端的负载
            for(String serverIp : newServers) {
                int load = serverLoadMap.get(serverIp);
                serverLoadMap.put(serverIp, load+1);
            }
        }
        clientServerMap = newClientServer;

        System.out.println("server ip变更后，重新连接的连接数：" + connChangeNum);
        System.out.println("server ip变更后，重新连接的客户端数：" + clientChangeNum);
        System.out.println("");
        for(Map.Entry<String, Integer> entry : serverLoadMap.entrySet()) {
            System.out.println("Ip: " + entry.getKey() + ", " + "connection num:" + entry.getValue());
        }
        System.out.println("");
    }

    // 一个客户端使用一致性hash产生三个不同的服务端
    public static List<String> getThreeServer(String client) {
        String client01 = client + "#" + "1";
        String client02 = client + "#" + "2";
        String client03 = client + "#" + "3";
        String server01 = consistentHash.getNode(client01);
        String server02 = consistentHash.getNode(client02);
        while(server01.equals(server02)) {
            server02 = consistentHash.reGetNode(server02);
        }
        String server03 = consistentHash.getNode(client03);
        while(server03.equals(server01) || server03.equals(server02)) {
            server03 = consistentHash.reGetNode(server03);
        }

        List<String> servers = new LinkedList<String>();
        servers.add(server01);
        servers.add(server02);
        servers.add(server03);

        return servers;
    }
}
