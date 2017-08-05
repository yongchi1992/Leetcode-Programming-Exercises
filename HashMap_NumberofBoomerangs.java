import java.util.HashMap;

/**
 * Created by yongchizhang on 17/8/4.
 */
public class HashMap_NumberofBoomerangs {
    public class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int res = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i = 0; i < points.length; i++){
                for(int j = 0; j < points.length; j++){
                    int d = distance(points[i], points[j]);
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
                for(int v : map.values()){
                    if(v != 1)
                        res += v * (v - 1);
                }
                map.clear();   // 不要老是新开对象，用clear
            }
            return res;
        }
        public int distance(int[] a, int[] b){
            return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
        }
    }
}
