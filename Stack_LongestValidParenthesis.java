import java.util.Stack;

/**
 * Created by yongchizhang on 17/8/12.
 */
public class Stack_LongestValidParenthesis {

    public class Solution_stack {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<Integer>();
            int max=0;
            int left = -1;
            for(int j=0;j<s.length();j++){
                if(s.charAt(j)=='(') stack.push(j);
                else {
                    if (stack.isEmpty()) left=j;
                    else{
                        stack.pop();
                        if(stack.isEmpty()) max=Math.max(max,j-left);
                        else max=Math.max(max,j-stack.peek());
                    }
                }
            }
            return max;
        }
    }





    public class Solution {
        public int longestValidParentheses(String s) {
            int left = 0, right = 0;
            int max_left = 0, max_right = 0;
            int n = s.length();
            for(int i = 0; i < n; i++){
                if(s.charAt(i) == '('){
                    left++;
                } else if (s.charAt(i) == ')'){
                    right++;
                    if(left == right) {
                        max_left = Math.max(max_left, left + right);
                    } else if(right > left){
                        left = 0;
                        right = 0;
                    }
                }
            }
            left = 0; right = 0;
            for(int i = n - 1; i >= 0; i--){
                if(s.charAt(i) == ')'){
                    left++;
                } else if (s.charAt(i) == '('){
                    right++;
                    if(left == right) {
                        max_right = Math.max(max_right, left + right);
                    } else if(right > left){
                        left = 0;
                        right = 0;
                    }
                }
            }
            return Math.max(max_left, max_right);
        }
    }
}
