/**
 * Created by yongchizhang on 17/7/17.
 */
public class LinkedList_RmEle {
    public class Solution {
        public ListNode removeElements(ListNode head, int val) {

            while(head != null && head.val == val){
                head = head.next;
            }
            if(head == null){
                return null;
            }
            ListNode curr = head.next, prev = head;
            while(curr != null){
                if(curr.val == val){
                    prev.next = curr.next;
                    curr = curr.next;
                }else{
                    curr = curr.next;
                    prev = prev.next;
                }
            }
            return head;
        }
    }
}
