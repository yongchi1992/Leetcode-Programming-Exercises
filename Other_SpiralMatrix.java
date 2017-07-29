/**
 * Created by yongchizhang on 17/7/25.
 */
import java.util.*;
public class Other_SpiralMatrix {
    public class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> result = new LinkedList<>();
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
                return result;
            }

            int pointer = 0;
            int row = 0, col = 0;
            int m = matrix.length, n = matrix[0].length;
            int total = m * n;
            int up = 0, down = m - 1, left = 0, right = n - 1;
            for(int i = 0; i < total; i++){
                result.add(matrix[row][col]);
                if(pointer == 0){
                    if(col < right){
                        col++;
                    }else{
                        pointer = 1;
                        row++;
                        up++;
                    }
                }else if(pointer == 1){
                    if(row < down){
                        row++;
                    }else{
                        pointer = 2;
                        col--;
                        right--;
                    }
                }else if(pointer == 2){
                    if(col > left){
                        col--;
                    }else{
                        pointer = 3;
                        row--;
                        down--;
                    }
                }else if(pointer == 3){
                    if(row > up){
                        row--;
                    }else{
                        pointer = 0;
                        left++;
                        col++;
                    }
                }

            }
            return result;
        }
    }


    public class Solution_best {
        public List<Integer> spiralOrder(int[][] matrix) {

            List<Integer> res = new ArrayList<Integer>();

            if (matrix.length == 0) {
                return res;
            }

            int rowBegin = 0;
            int rowEnd = matrix.length-1;
            int colBegin = 0;
            int colEnd = matrix[0].length - 1;

            while (rowBegin <= rowEnd && colBegin <= colEnd) {
                // Traverse Right
                for (int j = colBegin; j <= colEnd; j ++) {
                    res.add(matrix[rowBegin][j]);
                }
                rowBegin++;

                // Traverse Down
                for (int j = rowBegin; j <= rowEnd; j ++) {
                    res.add(matrix[j][colEnd]);
                }
                colEnd--;

                if (rowBegin <= rowEnd) {
                    // Traverse Left
                    for (int j = colEnd; j >= colBegin; j --) {
                        res.add(matrix[rowEnd][j]);
                    }
                }
                rowEnd--;

                if (colBegin <= colEnd) {
                    // Traver Up
                    for (int j = rowEnd; j >= rowBegin; j --) {
                        res.add(matrix[j][colBegin]);
                    }
                }
                colBegin ++;
            }

            return res;
        }
    }



    public class Solution_SpiralMatrix2 {
        /**
         * @param n an integer
         * @return a square matrix
         */
        public int[][] generateMatrix(int n) {
            // Write your code here
            int[][] matrix = new int[n][n];
            int rowBegin = 0;
            int rowEnd = n - 1;
            int colBegin = 0;
            int colEnd = n - 1;
            int i = 1;

            while (rowBegin <= rowEnd && colBegin <= colEnd) {
                // Traverse Right
                for (int j = colBegin; j <= colEnd; j ++) {
                    matrix[rowBegin][j] = i++;
                }
                rowBegin++;

                // Traverse Down
                for (int j = rowBegin; j <= rowEnd; j ++) {
                    matrix[j][colEnd] = i++;
                }
                colEnd--;

                if (rowBegin <= rowEnd) {
                    // Traverse Left
                    for (int j = colEnd; j >= colBegin; j --) {
                        matrix[rowEnd][j] = i++;
                    }
                }
                rowEnd--;

                if (colBegin <= colEnd) {
                    // Traver Up
                    for (int j = rowEnd; j >= rowBegin; j --) {
                        matrix[j][colBegin] = i++;
                    }
                }
                colBegin ++;
            }

            return matrix;
        }
    }

}
