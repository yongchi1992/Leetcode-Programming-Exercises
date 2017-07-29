import java.util.Arrays;

/**
 * Created by yongchizhang on 17/6/20.
 */
public class BinarySearLongestIncreaSubseq {
    public int lengthOfLIS(int[] nums) {
        int[] sorted = new int[nums.length];
        int len = 0;
        for(int i=0; i<nums.length; i++){
            int idx = Arrays.binarySearch(sorted,0,len, nums[i]);
            if(idx<0){
                idx = -idx-1;
                sorted[idx] = nums[i];
                if(idx == len){
                    len++;
                }
            }
        }
        return len;
    }
}
