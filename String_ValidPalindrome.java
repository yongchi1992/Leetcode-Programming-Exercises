/**
 * Created by yongchizhang on 17/7/4.
 */
public class String_ValidPalindrome {
    public class Solution {
        public boolean isPalindrome(String s) {
            int start = 0, end = s.length() - 1;
            while(start <end ){
                while(start < s.length() && !Character.isLetterOrDigit(s.charAt(start))){
                    start ++;
                }
                while(end >=0 && !Character.isLetterOrDigit(s.charAt(end))){
                    end --;
                }
                if(start < s.length() && end >=0 && Character.toUpperCase(s.charAt(start)) != Character.toUpperCase(s.charAt(end))){
                    return false;
                }
                start++;
                end--;
            }
            return true;
        }
    }
}
