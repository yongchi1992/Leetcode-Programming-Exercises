import java.util.Stack;

/**
 * Created by yongchizhang on 17/8/16.
 */
public class LinkedList_AddTwoNum {

    //用stack可以不用打乱LinkedList
    public class Solution_best {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack<Integer>();
            Stack<Integer> s2 = new Stack<Integer>();

            while(l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            };
            while(l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }

            int sum = 0;
            ListNode list = new ListNode(0);
            while (!s1.empty() || !s2.empty()) {
                if (!s1.empty()) sum += s1.pop();
                if (!s2.empty()) sum += s2.pop();
                list.val = sum % 10;
                ListNode head = new ListNode(sum / 10);
                head.next = list;
                list = head;
                sum /= 10;
            }

            return list.val == 0 ? list.next : list;
        }
    }



    public class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if(l1 == null){
                return l2;
            } else if(l2 == null){
                return l1;
            }
            l1 = reverse(l1);
            l2 = reverse(l2);
            ListNode curr = null;
            int flag = 0;
            do{
                int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + flag;
                if(sum >= 10){
                    sum -= 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                ListNode tmp = new ListNode(sum);
                tmp.next = curr;
                curr = tmp;
                if(l1 != null)
                    l1 = l1.next;
                if(l2 != null)
                    l2 = l2.next;
            } while(l1 != null || l2 != null || flag == 1);
            return curr;
        }

        public ListNode reverse(ListNode head){
            ListNode prev = null, curr = head;
            while(curr != null){
                ListNode next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }
    }

}
