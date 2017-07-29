/**
 * Created by yongchizhang on 17/7/17.
 */
public class BitMani_HammingDistance {
    public class Solution {
        public int hammingDistance(int x, int y) {
            int result = x ^ y;
            return countbits(result);
        }
        public int countbits(int num){    //  正数负数都可以用
            if(num == 0){
                return 0;
            }
            int n = num & (num - 1);
            int count = 1;
            while(n != 0){
                n = n & (n - 1);
                count++;
            }
            return count;
        }
    }


    public class Solution2 {
        public int hammingDistance(int x, int y) {
            return Integer.bitCount(x ^ y);
        }
    }
}
