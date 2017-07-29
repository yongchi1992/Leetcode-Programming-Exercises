import java.util.Arrays;

/**
 * Created by yongchizhang on 17/7/26.
 */
public class Array_ShortestUnsortedSubarray {

    //O(n) Time O(1) Space
    public class Solution_bestMyVersion {
        public int findUnsortedSubarray(int[] nums) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            boolean flag = false;
            for(int i = 1; i < nums.length; i++){
                if(nums[i] < nums[i - 1]){
                    flag = true;
                }
                if(flag){
                    min = Math.min(min, nums[i]);
                }
            }
            if(flag == false){
                return 0;
            }
            flag = false;
            for(int i = nums.length - 1; i > 0; i--){
                if(nums[i] < nums[i - 1]){
                    flag = true;
                }
                if(flag){
                    max = Math.max(max, nums[i - 1]);
                }
            }
            int l = 0, r = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > min){
                    l = i;
                    break;
                }
            }
            for(int i = nums.length - 1; i >= 0; i--){
                if(nums[i] < max){
                    r = i;
                    break;
                }
            }
            return r - l + 1;
        }
    }




    public class Solution_best {
        public int findUnsortedSubarray(int[] nums) {
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            boolean flag = false;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < nums[i - 1])
                    flag = true;
                if (flag)
                    min = Math.min(min, nums[i]);
            }
            flag = false;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] > nums[i + 1])
                    flag = true;
                if (flag)
                    max = Math.max(max, nums[i]);
            }
            int l, r;
            for (l = 0; l < nums.length; l++) {
                if (min < nums[l])
                    break;
            }
            for (r = nums.length - 1; r >= 0; r--) {
                if (max > nums[r])
                    break;
            }
            return r - l < 0 ? 0 : r - l + 1;
        }
    }




    // O(logn) Time, O(n) Space
    public class Solution {
        public int findUnsortedSubarray(int[] nums) {
            int[] temp = new int[nums.length];
            for(int i = 0; i < nums.length; i++){
                temp[i] = nums[i];
            }
            Arrays.sort(temp);
            int i = 0, j = nums.length - 1;
            while(temp[i] == nums[i]){
                i++;
                if(i == nums.length){
                    return 0;
                }
            }
            while(temp[j] == nums[j]){
                j--;
            }
            return j - i + 1;
        }
    }
}
