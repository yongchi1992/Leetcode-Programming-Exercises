/**
 * Created by yongchizhang on 17/7/17.
 */
public class LinkedList_Cycle {
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null){
                return false;
            }
            ListNode slow = head, fast = head;
            while(fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast == null){
                    return false;
                }
                if(slow == fast){
                    return true;
                }
            }
            return false;
        }
    }
}
