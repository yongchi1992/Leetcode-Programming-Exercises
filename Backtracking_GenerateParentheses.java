import java.util.LinkedList;
import java.util.List;

/**
 * Created by yongchizhang on 17/7/6.
 */
public class Backtracking_GenerateParentheses {
    public class Solution {
        public List<String> generateParenthesis(int n) {
            int[] num = {0, 0};
            List<String> result = new LinkedList<>();
            StringBuffer str = new StringBuffer();
            helper(n, num, str, result);
            return result;

        }
        public void helper(int n, int[] num, StringBuffer str, List<String> result){
            if(num[0] == n && num[1] == n){
                result.add(new StringBuffer(str).toString());
            }
            if(num[0] < n){
                str.append('(');
                num[0] ++;
                helper(n, num, str, result);
                str.deleteCharAt(str.length() - 1);
                num[0] --;
            }
            if(num[1]<num[0]){
                str.append(')');
                num[1] ++;
                helper(n, num, str, result);
                str.deleteCharAt(str.length() - 1);
                num[1] --;
            }
        }
    }
}
