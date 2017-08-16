/**
 * Created by yongchizhang on 17/8/16.
 */
public class DP_Minimax_PredictWinner {
    public class Solution {
        public boolean PredictTheWinner(int[] nums) {
            int n = nums.length;
            int[][] table = new int[n][n];

            for(int i = 0; i < n; i++){
                table[i][i] = nums[i];
            }

            for(int i = 1; i <= n - 1; i++){
                for(int j = 0; j <= n - i - 1; j++){
                    //table[j][j + i]
                    table[j][j + i] = Math.max(nums[j] - table[j + 1][j + i], nums[j + i] - table[j][j + i - 1]);
                }
            }
            return table[0][n - 1] >= 0;
        }
    }
}
