
package meituan.consistenthash;

import java.util.*;
import java.util.zip.CRC32;

/**
 * Created by ballontt on 2017/6/26.
 */
public class ConsistentHash {
    // 存储虚拟节点的hash value和真实节点的对应关系
    private TreeMap<Long, String> nodesMap = new TreeMap<Long, String>();
    // 存储真实节点和对应的所有虚拟节点的hash value集合
    private HashMap<String, Vector<Long>> nodesReplicas = new HashMap<String, Vector<Long>>();
    // 所有节点
    private List<String> nodes = null;
    // 虚拟节点的复制数
    private int replicas = 0;


    public ConsistentHash(List<String> nodes, int replicas) {
        this.nodes = nodes;
        this.replicas = replicas;
        for(String node : nodes) {
            addNode(node);
        }
    }
    public String reGetNode(String key) {
        Collections.sort(nodes);
        for(int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).equals(key)) {
                if(i == nodes.size()-1) {
                    return nodes.get(0);
                }
                return nodes.get(i+1);
            }
        }
        return null;
    }

    public String getNode(String key) {
        CRC32 crc32 = new CRC32();
        crc32.update(key.getBytes());
        Long keyHashValue = Math.abs(crc32.getValue());
        Map.Entry<Long, String> entry =  nodesMap.ceilingEntry(keyHashValue);
        if(entry == null) {
            entry = nodesMap.firstEntry();
        }
        return entry.getValue();
    }

    public void addNodeList(List<String> servers) {
        if(servers == null || servers.size() == 0) {
            return;
        }
        for(String server : servers) {
            addNode(server);
        }
    }

    public void removeNodeList(List<String> servers) {
        if(servers == null || servers.size() == 0) {
            return;
        }
        for(String server : servers) {
            removeNode(server);
        }
    }

    public void addNode(String node) {
        this.addNodesMap(node);
    }

    public void removeNode(String node) {
        if(!nodesReplicas.containsKey(node)) {
            return;
        }
        Vector<Long>replicasHashValue = nodesReplicas.get(node);
        nodesReplicas.remove(node);
        for(Long hashValue : replicasHashValue) {
            nodesMap.remove(hashValue);
        }
    }

    private void addNodesMap(String node) {
        Vector<Long> nodesReps = new Vector<Long>();
        CRC32 crc32 = new CRC32();
        for(int i = 0; i < replicas; i++) {
            String repNode = node + "#" + i;
            crc32.update(repNode.getBytes());
            Long repNodeHash = Math.abs(crc32.getValue());
            nodesMap.put(repNodeHash,node);
            nodesReps.add(repNodeHash);
        }
        nodesReplicas.put(node, nodesReps);
    }
}



