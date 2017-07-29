/**
 * Created by yongchizhang on 17/7/13.
 */
public class Math_addDigits {
    public class Solution {
        public int addDigits(int num) {
            while(num > 9){
                int tmp = 0;
                while(num != 0){
                    tmp += num % 10;
                    num /= 10;
                }
                num = tmp;
            }
            return num;
        }
    }
}
