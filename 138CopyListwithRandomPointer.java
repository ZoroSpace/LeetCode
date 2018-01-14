/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode cur1 = head,s2 = new RandomListNode(0), cur2 = s2;;
        Map<RandomListNode,RandomListNode> map = new HashMap<>();
        while(cur1 != null) {
            cur2.next = new RandomListNode(cur1.label);
            cur2 = cur2.next;
            cur2.random = cur1.random;
            map.put(cur1,cur2);
            cur1 = cur1.next;
        }
        
        cur1 = head;
        cur2 = s2.next;
        while(cur1 != null) {
            if(cur2.random != null) cur2.random = map.get(cur2.random);
            cur1 = cur1.next;
        }
        return s2.next;
    }
}
