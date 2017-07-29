/**
 * Created by yongchizhang on 17/7/21.
 */
public class String_RepeatedSubstringPattern {

    public class Solution {
        public boolean repeatedSubstringPattern(String str) {
            int n = str.length();
            for(int i = n/2; i >= 1; i--){
                if(n % i == 0){
                    String sub = str.substring(0, i);
                    int j = i;
                    for(; j < n; j += i){
                        if(!sub.equals(str.substring(j, j + i))){
                            break;
                        }
                    }
                    if(j == n){
                        return true;
                    }

                }
            }
            return false;
        }
    }


    public boolean repeatedSubstringPattern(String str) {
        int len = str.length();
        for(int i=len/2 ; i>=1 ; i--) {
            if(len%i == 0) {
                int m = len/i;
                String subS = str.substring(0,i);
                int j;
                for(j=1;j<m;j++) {
                    if(!subS.equals(str.substring(j*i,i+j*i))) break;
                }
                if(j==m)
                    return true;
            }
        }
        return false;
    }
}
