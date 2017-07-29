/**
 * Created by yongchizhang on 17/7/17.
 */
public class LinkedList_isPalindrome {



    public class Solution {
        public boolean isPalindrome(ListNode head) {
            if(head == null){
                return true;
            }
            ListNode slow = head, fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            if(fast != null){
                slow = slow.next;
            }
            slow = reverse(slow);
            fast = head;
            while(slow != null){
                if(slow.val != fast.val){
                    return false;
                }
                slow = slow.next;
                fast = fast.next;
            }
            return true;
        }


        public ListNode reverse(ListNode head){
            ListNode prev = null, curr = head;
            while(curr != null){
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }
    }



}
