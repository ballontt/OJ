package meituan.random;

import meituan.common.Util;
import meituan.consistenthash.ConsistentHash;

import java.util.*;

import static meituan.consistenthash.TestConsHash.getThreeServer;

/**
 * Created by ballontt on 2017/6/26.
 */
public class TestRandom {
    private static RandomBalance rb = null;
    private static List<String> serverNodes = null;
    private static HashMap<String, Integer> serverLoadMap = null;
    private static HashSet<String> clientNodes = null;
    private static HashMap<String, List<String>> clientServerMap = null;
    private static int clientNum = 100000;
    private static int connChangeNum = 0;
    private static int clientChangeNum = 0;


    public static void main(String[] args) throws Exception {
        serverNodes = new LinkedList<String>();
        serverNodes.add("192.168.10.1");
        serverNodes.add("192.168.10.2");
        serverNodes.add("192.168.10.3");
        serverNodes.add("192.168.10.4");

        init();
        addServer("192.168.10.5");
        removeServer("192.168.10.4");

    }

    public static void init() throws Exception {
        serverLoadMap = new HashMap<String, Integer>();
        for (String node : serverNodes) {
            serverLoadMap.put(node, 0);
        }

        rb = new RandomBalance(serverNodes);

        // 产生客户端ip
        clientNodes = new HashSet<String>();
        clientServerMap = new HashMap<String, List<String>>();
        for (int i = 0; i < clientNum; i++) {
            String clientIp = Util.getIp();
            while(clientNodes.contains(clientIp)) {
                clientIp = Util.getIp();
            }
            clientNodes.add(clientIp);

            // 客户端连接的三个服务端
            List<String> serverIps = rb.getNodes(3);
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
        System.out.println("==========================================");
        System.out.println("新增server:" + server);
        rb.addNode(server);

        connChangeNum = 0;
        clientChangeNum = 0;
        HashMap<String, List<String>> newClientServer = new HashMap<String, List<String>>();
        for(String client : clientNodes) {
            if (requireReConnection(client)) {
                List<String> servers = reConnection(client, server);
                clientServerMap.put(client, servers);
                connChangeNum++;
                clientChangeNum++;
            }
        }

        // 重新统计负载
        staticInfo(1);
    }

    public static void removeServer(String removeServer) {
        System.out.println("==========================================");
        System.out.println("移除server:" + removeServer);
        rb.removeNode(removeServer);

        connChangeNum = 0;
        clientChangeNum = 0;

        for(String client : clientNodes) {
            List<String> newConnServers = clientServerMap.get(client);
            if(newConnServers.contains(removeServer)) {
                connChangeNum++;
                clientChangeNum++;

                String newServer = rb.getNodes(1).get(0);
                while(newConnServers.contains(newServer)) {
                    newServer = rb.getNodes(1).get(0);
                }
                newConnServers.remove(removeServer);
                newConnServers.add(newServer);
                clientServerMap.put(client, newConnServers);
            }
        }
        // 重新统计负载信息
        staticInfo(0);
    }

    private static boolean requireReConnection(String client) {
        float probability = getProbability(client);
        double randomNumber = Math.random();
        if(randomNumber <= probability) {
            return true;
        } else {
            return false;
        }
    }

    private static float getProbability(String client) {
        int allServersNum = serverNodes.size();
        List<String> servers = clientServerMap.get(client);
        int connNum = servers.size();
        int threeServersLoad = 0;

        for(String server : servers) {
            try{
                threeServersLoad += serverLoadMap.get(server);
            } catch (Exception e) {
                System.out.println(server + " is not exist. client is : " + client );
                e.printStackTrace();
            }
        }
        int avgLoad = threeServersLoad / connNum;
        int allConnectionsCount = allServersNum * avgLoad;
        int clientNums = allConnectionsCount / connNum;

        int newAllServersNum =  rb.getAllNodes().size();
        int reConnectionNum = (avgLoad - allConnectionsCount / newAllServersNum) * allServersNum;
        return (float)reConnectionNum / clientNums;
    }

    private static List<String> reConnection(String client, String server) {
        List<String> servers = clientServerMap.get(client);
        Random r = new Random();
        int index = r.nextInt(servers.size());
        servers.remove(servers.get(index));
        servers.add(server);
        return servers;
    }

    private static void staticInfo(int op) {
        serverNodes = rb.getAllNodes();
        serverLoadMap.clear();
        for(String serverNode : serverNodes) {
            serverLoadMap.put(serverNode, 0);
        }
        for(Map.Entry<String, List<String>> entry : clientServerMap.entrySet()) {
            for(String node : entry.getValue()) {
                try{
                    int load = serverLoadMap.get(node);
                    serverLoadMap.put(node, load+1);

                } catch(Exception e) {
                    System.out.println(node + " is not exist");
                }
            }
        }
        switch(op) {
            case 1:
                System.out.println("ip 增加后，重新连接的连接数：" + connChangeNum);
                System.out.println("ip 增加后，重新连接的客户端数：" + clientChangeNum);
                break;
            case 0:
                System.out.println("ip 移除后，重新连接的连接数：" + connChangeNum);
                System.out.println("ip 移除后，重新连接的客户端数：" + clientChangeNum);
                break;
        }
        for(Map.Entry<String, Integer> entry : serverLoadMap.entrySet()) {
            System.out.println("Ip: " + entry.getKey() + ", " + "connection num:" + entry.getValue());
        }
    }

}

