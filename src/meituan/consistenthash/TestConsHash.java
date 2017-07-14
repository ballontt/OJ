package meituan.consistenthash;

import meituan.common.Util;

import java.util.*;

/**
 * Created by ballontt on 2017/6/26.
 * 
 * 场景：有若干台服务端，10W台客户端，每个客户端连接3台服务端，然后客户端从3个连接中选择一个连接，并在这个连接中发起长请求。
 * 如果存在长请求的网络连接中断，则重新选择一个新的连接发起长请求。服务端可以动态的添加、移除或滚动更新。并保持服务端的负载均衡。
 */
public class TestConsHash {
    private static ConsistentHash consistentHash = null;
    private static HashMap<String, Integer> serverConnectionLoad = null;
    private static HashMap<String, Integer> serverLongRequstLoad = null;
    private static LinkedList<String> serverNodes = null;
    private static LinkedList<String> clientNodes = null;
    private static HashMap<String, List<String>> client2ConnServers = null;
    private static HashMap<String, String> client2RequestServer = null;
    private static final int clientNum = 100000;
    private static final int virtualNodeReplicas = 300;
    private static final int redundancyNum = 3;

    public static void main(String[] args) {

        int initServerNum = 10;
        serverNodes = new LinkedList<String>();
        for(int i = 1; i <= initServerNum; i++) {
            serverNodes.add("192.168.11." + i);
        }

        init();

        // 添加节点
        // addServer("192.168.11.11");

        // 移除节点
        //removeServer("192.168.11.4");

        // 循环更新节点
        List<String> addServers = new LinkedList<String>();
        addServers.add("192.168.11.11");
        List<String> removeServers = new LinkedList<String>();
        removeServers.add("192.168.11.1");
        changeServer(addServers, removeServers);
    }

    public static void init() {
        System.out.println("客户端数：" + clientNum + ", 虚拟节点数：" + virtualNodeReplicas + ", 客户端冗余连接数：" + redundancyNum);
        serverConnectionLoad = new HashMap<String, Integer>();
        serverLongRequstLoad = new HashMap<String, Integer>();
        for (String node : serverNodes) {
            serverConnectionLoad.put(node, 0);
            serverLongRequstLoad.put(node, 0);
        }

        // 虚拟节点数少了，一致性hash无法保证分布的均匀
        consistentHash = new ConsistentHash(serverNodes, virtualNodeReplicas);

        // 产生10000个ip
        clientNodes = new LinkedList<>();
        client2ConnServers = new HashMap<String, List<String>>();
        client2RequestServer = new HashMap<String, String>();
        for (int i = 0; i < clientNum; i++) {
            String clientIp = Util.getIp();
            clientNodes.add(clientIp);

            // 客户端连接的三个服务端
            List<String> serverIps = getMultiServer(clientIp, redundancyNum);
            client2ConnServers.put(clientIp, serverIps);
            
            // 随机获得长连接请求，并记录长连接请求负载
            String longRequestServer = getOneForLongRequest(clientIp, serverIps);
            client2RequestServer.put(clientIp, longRequestServer);
            int longRequestLoad = serverLongRequstLoad.get(longRequestServer);
            serverLongRequstLoad.put(longRequestServer, longRequestLoad + 1);

            // 记录服务端的负载
            for (String serverIp : serverIps) {
                int load = serverConnectionLoad.get(serverIp);
                serverConnectionLoad.put(serverIp, load + 1);
            }
        }

        // 打印每一台服务器的连接数
        for (Map.Entry<String, Integer> entry : serverConnectionLoad.entrySet()) {
            System.out.println("Ip: " + entry.getKey() + ", " + "connection num:" + entry.getValue() 
                        + ", long request num:" + serverLongRequstLoad.get(entry.getKey()));
        }
        System.out.println("连接数的标准差：" + calcStdDeviation());
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

        // 负载清0
        serverConnectionLoad.clear();
        for(String  tmpServer : serverNodes) {
            serverConnectionLoad.put(tmpServer, 0);
        }
        if(addServers != null) {
            for(String server : addServers) {
                serverLongRequstLoad.put(server, 0);
            }
        }
        if(removeServers != null) {
            for(String server : removeServers) {
                serverLongRequstLoad.remove(server);
            }
        }
        
        int connChangeNum = 0;
        int clientChangeNum = 0;
        int longRequestChangeNum = 0;
        HashMap<String, List<String>> newClientServer = new HashMap<String, List<String>>();
        for(String client : clientNodes) {
            List<String> newServers = getMultiServer(client, redundancyNum);
            newClientServer.put(client, newServers);
            
            
            String requestServer = client2RequestServer.get(client);
            // 如果客户端新的三个连接中没有包含原来的长请求
            if(!newServers.contains(requestServer)) {
                longRequestChangeNum++;
                
                // 断开长请求，并重新选择
                if(serverLongRequstLoad.containsKey(requestServer)) {
                    int load = serverLongRequstLoad.get(requestServer);
                    serverLongRequstLoad.put(requestServer, load - 1);
                }
                
                String reqServer = getOneForLongRequest(client, newServers);
                client2RequestServer.put(client, reqServer);
                int load2 = serverLongRequstLoad.get(reqServer);
                serverLongRequstLoad.put(reqServer, load2 + 1);
            }
                    

            List<String> oldServers = client2ConnServers.get(client);
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

            // 记录服务端的负载
            for(String serverIp : newServers) {
                int load = serverConnectionLoad.get(serverIp);
                serverConnectionLoad.put(serverIp, load+1);
            }
        }
        client2ConnServers = newClientServer;

        System.out.println("server ip变更后，重新连接的连接数：" + connChangeNum + "（" + (int)((float)connChangeNum/(clientNum * redundancyNum) * 100) + "%）");
        System.out.println("server ip变更后，重新连接的客户端数：" + clientChangeNum + "（" + (int)((float)clientChangeNum / clientNum * 100) + "%）");
        System.out.println("server ip变更后，重新连接的长请求数：" + longRequestChangeNum + "（" + (int)((float)longRequestChangeNum/ clientNum * 100) + "%）");
        System.out.println("");
        for(Map.Entry<String, Integer> entry : serverConnectionLoad.entrySet()) {
            System.out.println("Ip: " + entry.getKey() + ", " + "connection num:" + entry.getValue()
                    + ", long request num:" + serverLongRequstLoad.get(entry.getKey()));
        }
        System.out.println("连接数的标准差：" + calcStdDeviation());
        System.out.println("");
    }

    // 一个客户端使用一致性hash产生多个不同的服务端
    public static List<String> getMultiServer(String client, int redundancyNum) {
        if(redundancyNum < 1) {
            return null;
        }

        List<String> servers = new LinkedList<String>();
        for(int i = 0; i < redundancyNum; i++) {
            String clientid = client + "#" + i;
            String server = consistentHash.getNode(clientid);
            while(servers.contains(server)) {
                server = consistentHash.reGetNode(server);
            }
            servers.add(server);
        }
        return servers;
    }

    private static int calcStdDeviation() {
        int avgConnServer = clientNum * redundancyNum / serverNodes.size();
        int sum = 0;
        for(Map.Entry<String, Integer> entry : serverConnectionLoad.entrySet()) {
            sum += (entry.getValue() - avgConnServer) * (entry.getValue() - avgConnServer);
        }
        return (int)Math.sqrt(sum / serverNodes.size());
    }

    // 使用轮训的方法获得一个连接
    private static String getOneForLongRequest(String client, List<String> serverIps) {
        // 在这里再次使用一致性hash方法
        long i = System.currentTimeMillis();
        Random r = new Random(i);
        return serverIps.get(r.nextInt(serverIps.size()));
    }

}
