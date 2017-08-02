/**
 * Created by yongchizhang on 17/8/2.
 */
import java.util.*;
public class DP_TrianglePathSum {
    public class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            if(triangle ==  null || triangle.size() == 0){
                return 0;
            }
            int n = triangle.size();
            int[][] table = new int[n][];
            table[0] = new int[1];
            table[0][0] = triangle.get(0).get(0);
            for(int i = 1; i < n; i++){
                table[i] = new int[i + 1];
                table[i][0] = table[i - 1][0] + triangle.get(i).get(0);
                for(int j = 1; j < i; j++){
                    table[i][j] = triangle.get(i).get(j) + Math.min(table[i - 1][j - 1], table[i - 1][j]);
                }
                table[i][i] = triangle.get(i).get(i) + table[i - 1][i - 1];
            }
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < n; i++){
                if(table[n - 1][i] < min){
                    min = table[n - 1][i];
                }
            }
            return min;
        }
    }
}
