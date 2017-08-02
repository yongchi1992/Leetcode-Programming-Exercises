/**
 * Created by yongchizhang on 17/8/2.
 */
public class DP_MinimumPathSum {
    public class Solution {
        public int minPathSum(int[][] grid) {
            if(grid == null || grid.length == 0 || grid[0].length == 0){
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            int[][] table = new int[m][n];
            table[m - 1][n - 1] = grid[m - 1][n - 1];
            for(int i = m - 2; i >= 0; i--){
                table[i][n - 1] = table[i + 1][n - 1] + grid[i][n - 1];
            }
            for(int i = n - 2; i >= 0; i--){
                table[m - 1][i] = table[m - 1][i + 1] + grid[m - 1][i];
            }
            for(int i = m - 2; i >= 0; i--){
                for(int j = n - 2; j >= 0; j--){
                    table[i][j] = grid[i][j] + Math.min(table[i + 1][j], table[i][j + 1]);
                }
            }
            return table[0][0];
        }
    }
}
