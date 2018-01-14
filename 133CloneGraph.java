/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null) return null;
        HashMap<Integer,UndirectedGraphNode> elements = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        int size;
        UndirectedGraphNode temp;
        while(q.size() != 0) {
            size = q.size();
            for(int i = 0;i < size;i++) {
                temp = q.poll();
                if(!visited.contains(temp.label)) {
                    visited.add(temp.label);
                    if(!elements.containsKey(temp.label)) 
                        elements.put(temp.label,new UndirectedGraphNode(temp.label));
                    for(UndirectedGraphNode u : temp.neighbors) {
                        q.offer(u);
                        if(!elements.containsKey(u.label))
                            elements.put(u.label,new UndirectedGraphNode(u.label));
                    }
                }
            }
        }
        visited.clear();
        q.offer(node);
        while(q.size() != 0) {
            size = q.size();
            for(int i = 0;i < size;i++) {
                temp = q.poll();
                if(!visited.contains(temp.label)) {
                    visited.add(temp.label);
                    for(UndirectedGraphNode u : temp.neighbors) {
                        q.offer(u);
                        elements.get(temp.label).neighbors.add(elements.get(u.label));
                    }
                }
            }
        }
        return elements.get(node.label);
    }
}
