import java.util.LinkedList;
import java.util.List;

/**
 * Created by yongchizhang on 17/8/10.
 */
public class Array_SummaryRanges {
    public class Solution {
        public List<String> summaryRanges(int[] nums) {
            List<String> res = new LinkedList<>();
            if(nums == null || nums.length == 0){
                return res;
            }
            int start = 0, end = 1;
            StringBuilder sb = new StringBuilder();
            while(end < nums.length){
                if(nums[end] != nums[end - 1] + 1){
                    if(start != end - 1){
                        sb.append(nums[start] + "->" + nums[end - 1]);
                    } else {
                        sb.append(nums[start]);
                    }
                    res.add(sb.toString());
                    start = end;
                    sb.setLength(0);
                }
                end++;
            }
            if(start != end - 1){
                sb.append(nums[start] + "->" + nums[end - 1]);
            } else {
                sb.append(nums[start]);
            }
            res.add(sb.toString());
            return res;
        }
    }
}
