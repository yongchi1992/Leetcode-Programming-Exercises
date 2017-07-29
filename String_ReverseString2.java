/**
 * Created by yongchizhang on 17/7/21.
 */
public class String_ReverseString2 {
    public class Solution {
        public String reverseStr(String s, int k) {
            char[] str = s.toCharArray();
            int start = 0, n = s.length();
            while(start < n - 1){
                int end = start + k - 1 >= n ? n - 1 : start + k - 1;
                reverse(str, start, end);
                start = end + k + 1;
            }
            return new String(str);
        }
        public void reverse(char[] str, int start, int end){
            while(start < end){
                char temp = str[start];
                str[start] = str[end];
                str[end] = temp;
                start++;
                end--;
            }
        }
    }
}
