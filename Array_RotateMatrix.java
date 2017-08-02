/**
 * Created by yongchizhang on 17/8/1.
 */
public class Array_RotateMatrix {
    public class Solution {
        /*
        1 2 4 4
        2 3 4 5
        2 6 7 8
        2 1 4 5
        */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for(int i = 0; i < n / 2; i++){
                for(int j = i; j < n - i - 1 ; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = temp;
                }
            }
        }
    }
}
