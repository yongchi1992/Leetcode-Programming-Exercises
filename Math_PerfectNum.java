/**
 * Created by yongchizhang on 17/7/25.
 */
public class Math_PerfectNum {

    public class Solution {
        public boolean checkPerfectNumber(int num) {
            if(num <= 3){
                return false;
            }
            int i = 2;
            int n = num - 1;
            while(i * i <= num){
                if(num % i == 0){
                    n -= i * i == num ? i : i + num / i;
                }
                i++;
            }
            if(n != 0){
                return false;
            }else{
                return true;
            }
        }
    }

}
