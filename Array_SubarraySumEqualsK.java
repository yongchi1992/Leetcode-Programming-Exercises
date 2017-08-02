/**
 * Created by yongchizhang on 17/8/1.
 */
import java.util.*;

public class Array_SubarraySumEqualsK {


    public class Solution_best {
        public int subarraySum(int[] nums, int k) {
            if(nums == null || nums.length == 0){
                return 0;
            }
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, 1);
            int sum = 0, count = 0;
            for(int i = 0; i < nums.length; i++){
                sum += nums[i];
                if(map.containsKey(sum - k)){
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }



    public class Solution_O1SpaceON2Time {
        public int subarraySum(int[] nums, int k) {
            int count = 0;
            for (int start = 0; start < nums.length; start++) {
                int sum=0;
                for (int end = start; end < nums.length; end++) {
                    sum+=nums[end];
                    if (sum == k)
                        count++;
                }
            }
            return count;
        }
    }




    public class Solution_cumulativesum {
        public int subarraySum(int[] nums, int k) {

            if(nums == null || nums.length == 0){
                return 0;
            }
            int count = 0;
            int[] record = new int[nums.length];
            record[0] = nums[0];
            for(int i = 1; i < nums.length; i++){
                record[i] = record[i - 1] + nums[i];
            }
            for(int i = 0; i < nums.length; i++){
                for(int j = i; j < nums.length; j++){
                    if(getRange(record, i, j) == k){
                        count++;
                    }
                }
            }
            return count;
        }
        public int getRange(int[] record, int i, int j){
            if(i == 0){
                return record[j];
            }else{
                return record[j] - record[i - 1];
            }
        }
    }
}
