/**
 * Created by yongchizhang on 10/18/17.
 */
public class BucketSort_MaximumGap {
    class Solution {
        public int maximumGap(int[] nums) {
            if(nums == null || nums.length < 2){
                return 0;
            }
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, n = nums.length;
            for(int num : nums){
                max = Math.max(max, num);
                min = Math.min(min, num);
            }
            if(max - min == 0){
                return 0;
            }
            double avg = (max - min) * 1.0 / n;
            Integer[][] record = new Integer[n + 1][2];
            for(int num : nums){
                int idx = (int)((num - min) / avg);
                if(record[idx][0] == null){
                    record[idx][0] = num;
                    record[idx][1] = num;
                } else {
                    record[idx][0] = Math.min(num, record[idx][0]);
                    record[idx][1] = Math.max(num, record[idx][1]);
                }
            }
            boolean findingMax = true;
            int tmpMax = 0;
            int res = Integer.MIN_VALUE;
            for(Integer[] ele : record){
                if(findingMax){
                    if(ele[1] != null){
                        findingMax = false;
                        tmpMax = ele[1];
                    }
                } else {
                    if(ele[0] != null){
                        res = Math.max(res, ele[0] - tmpMax);
                        tmpMax = ele[1];
                    }
                }
            }
            return res;
        }
    }
}
