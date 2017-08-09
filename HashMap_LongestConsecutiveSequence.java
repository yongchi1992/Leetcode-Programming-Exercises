/**
 * Created by yongchizhang on 17/8/9.
 */
import java.util.*;
public class HashMap_LongestConsecutiveSequence {

    public class Solution2 {
        public int longestConsecutive(int[] nums) {
            if(nums == null || nums.length == 0) return 0;

            Set<Integer> set = new HashSet<Integer>();

            for(int num: nums) set.add(num);
            int max = 1;
            for(int num: nums) {
                if(set.remove(num)) {//num hasn't been visited
                    int val = num;
                    int sum = 1;
                    while(set.remove(val-1)) val--;
                    sum += num - val;

                    val = num;
                    while(set.remove(val+1)) val++;
                    sum += val - num;

                    max = Math.max(max, sum);
                }
            }
            return max;
        }
    }


    public class Solution3{
        public int longestConsecutive(int[] num) {
            int res = 0;
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int n : num) {
                if (!map.containsKey(n)) {
                    int left = (map.containsKey(n - 1)) ? map.get(n - 1) : 0;
                    int right = (map.containsKey(n + 1)) ? map.get(n + 1) : 0;
                    // sum: length of the sequence n is in
                    int sum = left + right + 1;
                    map.put(n, sum);

                    // keep track of the max length
                    res = Math.max(res, sum);

                    // extend the length to the boundary(s)
                    // of the sequence
                    // will do nothing if n has no neighbors
                    map.put(n - left, sum);
                    map.put(n + right, sum);
                }
            }
            return res;
        }
    }




    public class Solution {
        class Record{
            int min;
            int max;
            int total;
            Record(int min, int max, int total){
                this.min = min;
                this.max = max;
                this.total = total;
            }
        }
        public int longestConsecutive(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            HashMap<Integer, Record> map = new HashMap<>();
            int max_total = 0;
            for(int num: nums){
                if(map.containsKey(num)){
                    continue;
                }
                int total = 1;
                if(map.containsKey(num + 1) && map.containsKey(num - 1)){
                    Record min = map.get(map.get(num - 1).min);
                    Record max = map.get(map.get(num + 1).max);
                    total = min.total + max.total + 1;
                    min.total = total;
                    max.total = total;
                    min.max = max.max;
                    max.min = min.min;
                    map.put(num, new Record(0, 0, 0));
                } else if(map.containsKey(num + 1)){
                    Record max = map.get(map.get(num + 1).max);
                    max.min = num;
                    total = ++max.total;
                    map.put(num, new Record(num, max.max, max.total));
                } else if(map.containsKey(num - 1)){
                    Record min = map.get(map.get(num - 1).min);
                    min.max = num;
                    total = ++min.total;
                    map.put(num, new Record(min.min, num, min.total));
                } else {
                    map.put(num, new Record(num, num, total));
                }
                if(total > max_total){
                    max_total = total;
                }
            }
            return max_total;
        }
    }
}
