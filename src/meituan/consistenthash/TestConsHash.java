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
        changeServer("192.168.10.5", 1);
        changeServer("192.168.10.6", 1);
        changeServer("192.168.10.7", 1);

        //移除节点
        changeServer("192.168.10.4", 0);
    }

    public static void init() {
        serverLoadMap = new HashMap<String, Integer>();
        for (String node : serverNodes) {
            serverLoadMap.put(node, 0);
        }

        // 虚拟节点数少了，一致性hash无法保证分布的均匀
        consistentHash = new ConsistentHash(serverNodes, 100);

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


    // 服务端服务器数量的变化，参数op，1:表示增加，0:表示减少
    public static void changeServer(String server, int op) {
        System.out.println("==========================================");
        switch (op) {
            case 1:
                System.out.println("新增server:" + server);
                serverNodes.add(server);
                consistentHash.addNode(server);
                break;
            case 0:
                System.out.println("移除server:" + server);
                serverNodes.remove(server);
                consistentHash.removeNode(server);
                break;
            default:
                System.out.println("op code is err");

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

        switch (op) {
            case 1:
                System.out.println("ip 新增后，重新连接的连接数：" + connChangeNum);
                System.out.println("ip 新增后，重新连接的客户端数：" + clientChangeNum);
                break;
            case 0:
                System.out.println("ip 移除后，重新连接的连接数：" + connChangeNum);
                System.out.println("ip 移除后，重新连接的客户端数：" + clientChangeNum);
                break;
            default:
                System.out.println("op code is err");
        }
        for(Map.Entry<String, Integer> entry : serverLoadMap.entrySet()) {
            System.out.println("Ip: " + entry.getKey() + ", " + "connection num:" + entry.getValue());
        }
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
