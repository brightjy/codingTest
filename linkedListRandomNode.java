public class Solution {

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */    

Random random;
List<Integer> list;

/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        
        random = new Random();
        list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    /** Returns a random node's value. */
    public int getRandom() {
        int size = list.size();
        int idx = random.nextInt(size);
        return list.get(idx);
    }
}
