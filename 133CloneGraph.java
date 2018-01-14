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
        elements.put(node.label,new UndirectedGraphNode(node.label));
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        UndirectedGraphNode temp;
        while(q.size() != 0) {
            temp = q.poll();
            for(UndirectedGraphNode u : temp.neighbors) {
                if(!elements.containsKey(u.label)) {
                    elements.put(u.label,new UndirectedGraphNode(u.label));
                    q.offer(u);
                }
                elements.get(temp.label).neighbors.add(elements.get(u.label));
            }
        }
        return elements.get(node.label);
    }
}
