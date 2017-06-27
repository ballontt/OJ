package meituan.random;

import java.util.*;

/**
 * Created by ballontt on 2017/6/26.
 */
public class RandomBalance {
    private List<String> nodes = new LinkedList<String>();
    public RandomBalance(List<String> serverList) throws Exception {
        if(serverList.size() < 3) {
            throw new Exception("节点数少于3个");
        }
        this.nodes.addAll(serverList);
    }

    public void addNode(String node) {
        this.nodes.add(node);
    }

    public void removeNode(String node) {
        this.nodes.remove(node);
    }

    public List<String> getNodes(int num) {
        List<String> servers = new LinkedList<String>();
        Random r = new Random();
        for(int i = 0; i < num; i++) {
            int index = r.nextInt(nodes.size());
            String node = nodes.get(index);
            while(servers.contains(node)){
                index = r.nextInt(nodes.size());
                node = nodes.get(index);
            }
            servers.add(node);
        }
        return servers;
    }


    public List<String> getAllNodes() {
        List<String> allservers = new LinkedList<String>();
        allservers.addAll(this.nodes);
        return allservers;
    }
}
