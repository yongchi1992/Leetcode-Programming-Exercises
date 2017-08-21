/**
 * Created by yongchizhang on 17/8/20.
 */
public class DP_StrangePrinter {

//DP中需要初始化的只有自己与自己那个

    class Solution_my {
        public int strangePrinter(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            int len = s.length();
            int[][] dp = new int[len][len];
            for(int i = 0; i < len; i++){
                dp[i][i] = 1;
            }
            for(int gap = 1; gap < len; gap++){
                for(int i = 0; i + gap < len; i++){
                    int j = i + gap;
                    int tmp_min = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++){
                        int cur = dp[i][k] + dp[k + 1][j];
                        if(s.charAt(k) == s.charAt(j)){
                            cur--;
                        }
                        tmp_min = Math.min(tmp_min, cur);
                    }
                    dp[i][j] = tmp_min;
                }
            }
            return dp[0][len - 1];
        }
    }


    class Solution {
        public int strangePrinter(String s) {
            if (s == null || s.length() == 0)
                return 0;

            int size = s.length();

            int[][] dp = new int[size][size];

            for (int i = 0; i < size; ++i)
                dp[i][i] = 1;

            for (int i = 0; i < size-1; ++i) {
                if (s.charAt(i) == s.charAt(i+1))
                    dp[i][i+1] = 1;
                else
                    dp[i][i+1] = 2;
            }

            for (int gap = 2; gap < size; ++gap) {
                for (int i = 0; i+gap < size; ++i) {
                    int j = i+gap;
                    int temp = Integer.MAX_VALUE;
                    for (int k = i; k < j; ++k) {
                        int cur = dp[i][k] + dp[k+1][j];
                        if (s.charAt(k) == s.charAt(j))
                            cur--;
                        temp = Math.min(temp, cur);
                    }
                    dp[i][j] = temp;
                }
            }

            return dp[0][size-1];
        }
    }
}
