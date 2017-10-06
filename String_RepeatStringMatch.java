/**
 * Created by yongchizhang on 9/30/17.
 */
public class String_RepeatStringMatch {
    class Solution {
        public int repeatedStringMatch(String A, String B) {
            StringBuilder sb = new StringBuilder();
            int n;
            if(A.length() >= B.length()){
                n = 2;
            } else {
                n = B.length() / A.length() + 1;
            }
            for(int i = 0; i < n; i++){
                sb.append(A);
            }
            int idx = findStr(sb,B);
            if(idx == -1){
                return -1;
            }
            int remain = sb.length() - idx - B.length();
            if(remain < A.length()){
                return n;
            } else {
                return n - 1;
            }
        }
        public int findStr(StringBuilder sb, String B){
            for(int i = 0; i <= sb.length() - B.length(); i++){
                if(sb.substring(i, i + B.length()).equals(B)){
                    return i;
                }
            }
            return -1;
        }
    }
}
