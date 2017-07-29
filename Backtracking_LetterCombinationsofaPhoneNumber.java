/**
 * Created by yongchizhang on 17/7/6.
 */
import java.util.*;
public class Backtracking_LetterCombinationsofaPhoneNumber {
    public class Solution {
        public List<String> letterCombinations(String digits) {
            int start = 0;
            String[] strs = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            List<String> result = new LinkedList<>();
            if(digits.length() == 0){
                return result;
            }
            StringBuffer ele = new StringBuffer();
            helper(result, ele, digits, strs, start);
            return result;
        }
        public void helper(List<String> result, StringBuffer ele, String digits, String[] strs, int start){
            if(start == digits.length()){
                result.add(new StringBuffer(ele).toString());
                return;
            }
            int index = digits.charAt(start) - '0' - 2;
            String target = strs[index];
            for(char ch: target.toCharArray()){
                ele.append(ch);
                helper(result, ele, digits, strs, start+1);
                ele.deleteCharAt(ele.length() - 1);
            }
        }
    }
}
