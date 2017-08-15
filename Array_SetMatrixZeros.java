/**
 * Created by yongchizhang on 17/8/15.
 */
public class Array_SetMatrixZeros {
    public class Solution {
        public void setZeroes(int[][] matrix) {
            if(matrix == null || matrix.length == 0){
                return;
            }
            int m = matrix.length, n = matrix[0].length;
            boolean f_row = false, f_col = false;
            for(int i = 0; i < m; i++){
                if(matrix[i][0] == 0){
                    f_col = true;
                    break;
                }
            }
            for(int i = 0; i < n; i++){
                if(matrix[0][i] == 0){
                    f_row = true;
                    break;
                }
            }
            for(int i = 1; i < m; i++){
                for(int j = 1; j < n; j++){
                    if(matrix[i][j] == 0){
                        matrix[i][0] = 0;
                        matrix[0][j] = 0;
                    }
                }
            }
            for(int i = 1; i < m; i++){
                if(matrix[i][0] == 0){
                    setRowZeros(matrix, i);
                }
            }
            for(int i = 1; i < n; i++){
                if(matrix[0][i] == 0){
                    setColZeros(matrix, i);
                }
            }
            if(f_row)
                setRowZeros(matrix, 0);
            if(f_col)
                setColZeros(matrix, 0);
        }

        public void setRowZeros(int[][] matrix, int row){
            for(int i = 0; i < matrix[row].length; i++){
                matrix[row][i] = 0;
            }
        }

        public void setColZeros(int[][] matrix, int col){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][col] = 0;
            }
        }
    }
}
