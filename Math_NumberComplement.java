/**
 * Created by yongchizhang on 17/7/4.
 */
public class Math_NumberComplement {
    public class Solution {
        public int findComplement(int num) {
            int n = 2;
            while(n - 1 < num){
                n *= 2;
            }
            return n - 1 - num;
        }
    }


    public class Solution2 {
        public int findComplement(int num) {
            return ~num & (Integer.highestOneBit(num) - 1);
        }
    }
}
