import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by yongchizhang on 17/7/26.
 */
public class Array_ContainDuplicate {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }



    public class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            if(nums == null || nums.length == 0){
                return false;
            }
            HashMap<Integer, Integer> record = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                if(!record.containsKey(nums[i])){
                    record.put(nums[i], i);
                }else{
                    if(i - record.get(nums[i]) <= k){
                        return true;
                    }else{
                        record.put(nums[i], i);
                    }
                }
            }
            return false;
        }
    }
}
