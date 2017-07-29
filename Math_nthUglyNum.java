/**
 * Created by yongchizhang on 17/7/14.
 */
public class Math_nthUglyNum {
    public class Solution {
        public int nthUglyNumber(int n) {
            int[] ugly = new int[n];
            ugly[0] = 1;
            int index2 = 0, index3 = 0, index5 = 0;
            int factor2 = 2, factor3 = 3, factor5 = 5;
            for(int i=1;i<n;i++){
                int min = Math.min(Math.min(factor2,factor3),factor5);
                ugly[i] = min;
                if(factor2 == min)
                    factor2 = 2*ugly[++index2];
                if(factor3 == min)
                    factor3 = 3*ugly[++index3];
                if(factor5 == min)
                    factor5 = 5*ugly[++index5];
            }
            return ugly[n-1];
        }
    }



    public class Solution2 {
        public int nthUglyNumber(int n) {

            int[] factor = {2, 3, 5};
            int[] temp = {2, 3, 5};
            int[] num = {0, 0, 0};
            int[] ugly = new int[n];
            ugly[0] = 1;
            for(int i = 1; i < n; i++){
                ugly[i] = Math.min(factor[0], Math.min(factor[1], factor[2]));
                for(int j = 0; j <= 2; j++){
                    if(factor[j] == ugly[i]){
                        factor[j] = temp[j] * ugly[++ num[j]];
                    }
                }
            }
            return ugly[n - 1];
        }
    }

}
