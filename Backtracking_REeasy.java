/**
 * Created by yongchizhang on 17/7/5.
 */
public class Backtracking_REeasy {
    public class Solution {
        public boolean isMatch(String s, String p) {
            return s.matches(p);
        }
    }


    //从前面难就从后面遍历

    public class Solution2 {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            return backtrack(s, m, p, n);
        }
        public boolean backtrack(String s, int m, String p, int n){
            if(m == 0 && n == 0){
                return true;
            }else if(m != 0 && n==0){
                return false;
            }else if(m == 0 && n != 0){
                if(p.charAt(n-1) == '*'){
                    return backtrack(s, m, p, n-2);
                }
                return false;
            }

            // m!=0 , n!=0
            if(p.charAt(n-1) == '.'){
                return backtrack(s, m-1, p, n-1);
            }else if(p.charAt(n-1) == '*'){
                if(backtrack(s, m, p, n-2)){
                    return true;
                }else{
                    if(p.charAt(n-2) == '.' || s.charAt(m-1) == p.charAt(n-2)){
                        return backtrack(s, m-1, p, n);
                    }
                    return false;
                }
            }else if(p.charAt(n-1) != s.charAt(m-1)){
                return false;
            }else{
                return backtrack(s, m-1, p, n-1);
            }

        }

    }
}
