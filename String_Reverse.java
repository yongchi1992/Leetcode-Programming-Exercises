/**
 * Created by yongchizhang on 17/7/3.
 */
public class String_Reverse {

    public class Solution3 {
        public String reverseString(String s) {
            StringBuffer str = new StringBuffer(s);
            return str.reverse().toString();
        }
    }

    public class Solution_reverse_single_string {
        public String reverseString(String s) {
            char[] str = s.toCharArray();
            int start = 0, end = str.length - 1;
            while(start < end){
                char tmp = str[start];
                str[start] = str[end];
                str[end] = tmp;
                start++;
                end--;
            }
            return new String(str);
        }
    }

    public class Solution {
        public String reverseWords(String s) {
            int index = 0;
            StringBuffer str = new StringBuffer();
            while(index < s.length()){
                int end = s.indexOf(" ", index);
                if(end == -1){
                    end = s.length();
                }
                int start = index;
                for(int i = end-1; i>= start; i--){
                    str.append(s.charAt(i));
                    index++;
                }
                while(index < s.length() && s.charAt(index)==' '){
                    str.append(' ');
                    index++;
                }
            }
            return str.toString();
        }
    }


    public class Solution_reverse_with_space {
        public String reverseWords(String s) {
            char[] str = s.toCharArray();
            int start = 0;
            while(start < s.length()){
                while(start < s.length() && str[start] == ' '){
                    start++;
                }
                int end = start;
                while(end < str.length && str[end] != ' '){
                    end ++;
                }
                end--;
                reverseSingle(str, start, end);
                start = end + 1;
            }
            return new String(str);
        }
        public void reverseSingle(char[] str, int start, int end){
            while(start<end){
                char tmp = str[start];
                str[start] = str[end];
                str[end] = tmp;
                start++;
                end--;
            }
        }
    }
}
