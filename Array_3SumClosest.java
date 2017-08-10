/**
 * Created by yongchizhang on 17/8/9.
 */
import java.util.*;
public class Array_3SumClosest {


    public class Solution_best {
        public int threeSumClosest(int[] num, int target) {
            int result = num[0] + num[1] + num[num.length - 1];
            Arrays.sort(num);
            for (int i = 0; i < num.length - 2; i++) {
                int start = i + 1, end = num.length - 1;
                while (start < end) {
                    int sum = num[i] + num[start] + num[end];
                    if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }
                    if (Math.abs(sum - target) < Math.abs(result - target)) {
                        result = sum;
                    }
                }
            }
            return result;
        }
    }



    public class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < nums.length - 2; i++){
                for(int j = i + 1; j < nums.length - 1; j++){
                    int temp = target - nums[i] - nums[j];
                    int idx = Arrays.binarySearch(nums, j + 1, nums.length, temp);
                    if(idx > 0){
                        return target;
                    }
                    idx = -idx - 1;
                    if(idx == nums.length){
                        if(Math.abs(temp - nums[idx - 1]) < Math.abs(min)){
                            min = temp - nums[idx - 1];
                        }
                    } else if (idx == j + 1) {
                        if(Math.abs(temp - nums[idx]) < Math.abs(min)){
                            min = temp - nums[idx];
                        }
                    } else {
                        if(Math.abs(temp - nums[idx]) < Math.abs(min)){
                            min = temp - nums[idx];
                        }
                        if(Math.abs(temp - nums[idx - 1]) < Math.abs(min)){
                            min = temp - nums[idx - 1];
                        }
                    }
                }
            }
            return target - min;
        }
    }
}
