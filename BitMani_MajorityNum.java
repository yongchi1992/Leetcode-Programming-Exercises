/**
 * Created by yongchizhang on 17/7/17.
 */
public class BitMani_MajorityNum {
    public class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            int result = 0;
            for(int i = 0; i < nums.length; i++){
                if(count == 0){
                    result = nums[i];
                }
                if(result == nums[i]){
                    count ++;
                }else{
                    count --;
                }
            }
            return result;
        }
    }


    public class Solution_BitMani {
        public int majorityElement(int[] nums) {
            int result = 0;
            for(int i = 0, mask = 1; i < 32; i++, mask <<= 1){
                int bitCount = 0;
                for(int j = 0; j < nums.length; j++){
                    if( (nums[j] & mask) != 0){
                        bitCount++;
                    }
                    if(bitCount > nums.length/2){
                        result |= mask;
                        break;
                    }
                }
            }
            return result;
        }
    }
}
