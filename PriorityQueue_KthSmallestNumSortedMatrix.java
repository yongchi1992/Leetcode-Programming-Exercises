/**
 * Created by yongchizhang on 17/7/18.
 */
import java.util.*;
public class PriorityQueue_KthSmallestNumSortedMatrix {
    public class Solution {
        class dataType{
            int num;
            int row;
            int col;
            dataType(int num, int row, int col){
                this.num = num;
                this.row = row;
                this.col = col;
            }
        }
        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int[] p = new int[n];
            PriorityQueue<dataType> queue = new PriorityQueue<>(
                    new Comparator<dataType>(){
                        @Override
                        public int compare(dataType a, dataType b){
                            return a.num - b.num;
                        }
                    }
            );
            for(int i = 0; i < n; i++){
                queue.add(new dataType(matrix[i][0], i, 0));
            }
            int result = 0;
            while(k != 0){
                dataType temp = queue.poll();
                result = temp.num;
                if(temp.col < n - 1){
                    queue.add(new dataType(matrix[temp.row][temp.col + 1], temp.row, temp.col + 1));
                }
                k--;
            }
            return result;
        }
    }




    public class Solution2 {
        public int kthSmallest(int[][] matrix, int k) {
            int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1];//[lo, hi)
            while(lo < hi) {
                int mid = lo + (hi - lo) / 2;
                int count = 0,  j = matrix[0].length - 1;
                for(int i = 0; i < matrix.length; i++) {
                    while(j >= 0 && matrix[i][j] > mid) j--;
                    count += (j + 1);
                }
                if(count < k) lo = mid + 1;
                else hi = mid;
            }
            return lo;
        }
    }



}
