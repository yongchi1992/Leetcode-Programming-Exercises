/**
 * Created by yongchizhang on 17/7/13.
 */
public class Math_UglyNum {
    public class Solution {
        public boolean isUgly(int num) {
            if(num > 0 && num <= 6){
                return true;
            }else if(num <= 0){
                return false;
            }

            while(num > 5){
                if(num % 2 == 0){
                    num /= 2;
                }else if(num % 3 == 0){
                    num /= 3;
                }else if(num % 5 ==0){
                    num /= 5;
                }else{
                    return false;
                }
            }

            return true;
        }
    }
}
