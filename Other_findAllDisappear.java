import java.util.LinkedList;
import java.util.List;

/**
 * Created by yongchizhang on 17/7/26.
 */
public class Other_findAllDisappear {
    public class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> list = new LinkedList<>();
            for(int i = 0; i < nums.length; i++){
                if(nums[Math.abs(nums[i]) - 1] > 0){
                    nums[Math.abs(nums[i]) - 1] *= -1;
                }
            }
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > 0){
                    list.add(i + 1);
                }
            }
            return list;
        }
    }
}
