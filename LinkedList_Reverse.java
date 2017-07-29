/**
 * Created by yongchizhang on 17/7/16.
 */
public class LinkedList_Reverse {
    public class Solution {
        public ListNode reverseList(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode ListNode1 = head;
            ListNode ListNode2 = head.next;
            ListNode ListNode3 = head.next.next;
            ListNode1.next = null;
            do{
                ListNode2.next = ListNode1;
                if(ListNode3 == null){
                    return ListNode2;
                }else{
                    ListNode1 = ListNode2;
                    ListNode2 = ListNode3;
                    ListNode3 = ListNode3.next;
                }
            }while(true);
        }
    }



    public class Solution2 {
        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
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
