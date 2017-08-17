/**
 * Created by yongchizhang on 17/8/16.
 */
import java.util.*;

public class Sort_MinArrowsBurstBallon {
    public class Solution {
        public int findMinArrowShots(int[][] points) {
            if(points == null || points.length == 0){
                return 0;
            }
            Arrays.sort(points, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    if(a[0] != b[0]){
                        return a[0] - b[0];
                    } else {
                        return a[1] - b[1];
                    }
                }
            });
            int slow = 0, fast = 1, num = 1;
            while(fast < points.length){
                if(points[fast][0] > points[slow][1]) {
                    slow = fast;
                    num++;
                } else {
                    points[slow][1] = Math.min(points[slow][1], points[fast][1]);
                }
                fast++;
            }
            return num;
        }
    }
}
