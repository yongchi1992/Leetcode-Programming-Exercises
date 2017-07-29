import java.util.HashSet;

/**
 * Created by yongchizhang on 17/7/13.
 */
public class Math_HappyNum {
    public class Solution {
        public boolean isHappy(int n) {
            if(n <= 0){
                return false;
            }
            HashSet<Integer> hmp = new HashSet<>();
            while(n != 1){
                if(hmp.contains(n)){
                    return false;
                }
                hmp.add(n);
                int tmp = 0;
                while(n != 0){
                    tmp += (n % 10) * (n % 10);
                    n /= 10;
                }
                n = tmp;
            }
            return true;
        }
    }
}
