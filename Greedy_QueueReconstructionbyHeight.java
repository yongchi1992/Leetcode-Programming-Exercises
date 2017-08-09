/**
 * Created by yongchizhang on 17/8/9.
 */
import java.util.*;
public class Greedy_QueueReconstructionbyHeight {
    public class Solution {
        public int[][] reconstructQueue(int[][] people) {
            int m = people.length;
            if(people == null || m == 0){
                return people;
            }
            List<int[]> res = new LinkedList<>();
            Arrays.sort(people, new Comparator<int[]>(){
                @Override
                public int compare(int[] a, int[] b){
                    if(a[0] != b[0]){
                        return b[0] - a[0];
                    } else {
                        return a[1] - b[1];
                    }
                }
            });

            for(int[] pair: people){
                res.add(pair[1], pair);
            }
            return res.toArray(new int[0][0]);
        }
    }
}
