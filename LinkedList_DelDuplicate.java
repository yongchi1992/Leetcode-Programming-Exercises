/**
 * Created by yongchizhang on 17/7/17.
 */
public class LinkedList_DelDuplicate {
    public class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if(head == null){
                return head;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while(fast != null){
                if(slow.val == fast.val){
                    slow.next = fast.next;
                    fast = fast.next;
                }else{
                    slow = fast;
                    fast = fast.next;
                }
            }
            return head;
        }
    }
}
