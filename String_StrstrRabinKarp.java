/**
 * Created by yongchizhang on 17/8/16.
 */
public class String_StrstrRabinKarp {
    public class Solution {
        private final int BASE = 1000000;
        private final int HASH = 31;
        public int strStr(String haystack, String needle) {
            if(haystack == null || needle == null){
                return -1;
            }
            int m = haystack.length(), n = needle.length();
            if(m < n){
                return -1;
            } else if(n == 0){
                return 0;
            }
            int hashNeedle = 0;
            int power = 1;
            int hashTarget = 0;
            for(int i = 0; i < n; i++){
                hashNeedle = (hashNeedle * HASH + needle.charAt(i)) % BASE;
                power = (power * HASH) % BASE;
            }
            for(int i = 0; i < m; i++){
                hashTarget = (hashTarget * HASH + haystack.charAt(i)) % BASE;
                if(i < n - 1){
                    continue;
                }
                if(i > n - 1){
                    hashTarget -= (power * haystack.charAt(i - n)) % BASE;
                    if(hashTarget < 0){
                        hashTarget += BASE;
                    }
                }
                if(hashTarget == hashNeedle && haystack.substring(i - n + 1, i + 1).equals(needle)){
                    return i - n + 1;
                }
            }
            return -1;

        }
    }
}
