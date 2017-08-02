/**
 * Created by yongchizhang on 17/8/1.
 */
public class DP_UniquePaths {

    public class Solution_best {
        public int uniquePaths(int m, int n) {
            int[][] table = new int[m + 1][n + 1];
            for(int i = 1; i <= m; i++){
                table[i][1] = 1;
            }
            for(int i = 1; i <= n; i++){
                table[1][i] = 1;
            }
            for(int i = 2; i <= m; i++)
                for(int j = 2; j <= n; j++)
                    table[i][j] = table[i - 1][j] + table[i][j - 1];
            return table[m][n];
        }
    }


    public class Solution {
        public int uniquePaths(int m, int n) {
            if(m == 1){
                return 1;
            }
            if(n == 1){
                return 1;
            }
            return uniquePaths(m - 1, n) + uniquePaths(m, n - 1);
        }
    }


}
