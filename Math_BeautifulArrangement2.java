/**
 * Created by yongchizhang on 8/27/17.
 */
public class Math_BeautifulArrangement2 {
    class Solution {
        public int[] constructArray(int n, int k) {
            int[] res = new int[n];
            for (int i = 0, l = 1, r = n; i < n; i++)
                res[i] = k > 1 ? (k-- % 2 != 0 ? l++ : r--) : l++;
            return res;
        }
    }


    class Solution_my {
        public int[] constructArray(int n, int k) {
            int[] res = new int[n];
            for (int i = 0, l = 1, r = n; i < n; i++){
                if(k > 1){
                    if(k % 2 != 0){
                        res[i] = l++;
                    } else {
                        res[i] = r--;
                    }
                    k--;
                } else {
                    res[i] = l++;
                }
            }
            return res;
        }
    }

}
