/**
 * Created by yongchizhang on 17/8/11.
 */
public class LinkedList_RotateList {
    public class Solution2 {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null){
                return head;
            }
            ListNode end = head;
            int len = 1;
            while(end.next != null) {
                len++;
                end = end.next;
            }
            k %= len;
            if(k == 0){
                return head;
            }
            ListNode curr = head;
            for(int i = 1; i < len - k; i++){
                curr = curr.next;
            }
            ListNode newhead = curr.next;
            curr.next = null;
            end.next = head;
            return newhead;

        }

    }




    public class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if(head == null){
                return head;
            }
            int len = listLen(head);
            k %= len;
            if(k == 0){
                return head;
            }
            ListNode curr = head;
            for(int i = 1; i < len - k; i++){
                curr = curr.next;
            }
            ListNode newhead = curr.next;
            curr.next = null;
            curr = newhead;
            while(curr.next != null){
                curr = curr.next;
            }
            curr.next = head;
            return newhead;

        }

        public int listLen(ListNode head){
            ListNode tmp = head;
            int count = 0;
            while(tmp != null) {
                count++;
                tmp = tmp.next;
            }
            return count;
        }
    }
}
