/**
 * Created by yongchizhang on 17/8/16.
 */
public class DP_Minimax_GuessNumHigherOrLower {
    public class Solution {
        public int getMoneyAmount(int n) {
            int[][] table = new int[n + 1][n + 1];
            for(int i = 1; i <= n - 1; i++){
                for(int j = 1; j <= n - i; j++){   //  j, j + i
                    //   求  table[j][j + i]
                    int min = Integer.MAX_VALUE;
                    for(int k = j; k <= j + i; k++){
                        int left = getTable(table, j, k - 1);
                        int right = getTable(table, k + 1, j + i);
                        min = Math.min(min, Math.max(left, right) + k);
                    }
                    table[j][j + i] = min;
                }
            }
            return table[1][n];
        }
        public int getTable(int[][] table, int i, int j){
            if(i >= j){
                return 0;
            } else {
                return table[i][j];
            }
        }
    }
}
