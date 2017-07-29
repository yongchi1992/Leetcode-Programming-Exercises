/**
 * Created by yongchizhang on 17/7/17.
 */
public class LinkedList_MergerTwoSorted {
    public class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if(l1 == null){
                return l2;
            }else if(l2 == null){
                return l1;
            }

            ListNode head = l1.val < l2.val ? l1 : l2;
            ListNode p1 = null, p2 = null, curr = null;
            if(head == l1){
                p1 = l1.next;
                p2 = l2;
            }else if(head == l2){
                p1 = l1;
                p2 = l2.next;
            }
            curr = head;

            while(p1 != null || p2 != null){
                int n1 = p1 == null ? Integer.MAX_VALUE : p1.val;
                int n2 = p2 == null ? Integer.MAX_VALUE : p2.val;
                if(n1 < n2){
                    curr.next = p1;
                    p1 = p1.next;
                }else{
                    curr.next = p2;
                    p2 = p2.next;
                }
                curr = curr.next;
            }

            return head;


        }
    }


    // Best Solution
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }
        ListNode head = null;
        ListNode node = null;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        node = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 == null) {
            node.next = l2;
        }
        if (l2 == null) {
            node.next = l1;
        }
        return head;
    }





    public class Solution_recursion {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2){
            if(l1 == null) return l2;
            if(l2 == null) return l1;
            if(l1.val < l2.val){
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else{
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }

    }




}
