/**
 * Created by yongchizhang on 17/8/1.
 */
import java.util.*;
public class Array_FindAllDuplicates {
    public class Solution {
        public List<Integer> findDuplicates(int[] nums) {
            List<Integer> result = new LinkedList<>();
            for(int i = 0; i < nums.length; i++){
                if(nums[Math.abs(nums[i]) - 1] < 0){
                    result.add(Math.abs(nums[i]));
                }else{
                    nums[Math.abs(nums[i]) - 1] *= -1;
                }
            }
            return result;
        }
    }
}
