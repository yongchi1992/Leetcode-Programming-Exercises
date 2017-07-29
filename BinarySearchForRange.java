/**
 * Created by yongchizhang on 17/6/21.
 */
public class BinarySearchForRange {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums.length==0){
            ans[0]=-1; ans[1]=-1;
            return ans;
        }

        int start = 0, end = nums.length - 1;

        int tmp = 0;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid]<target){
                start = mid + 1;
                tmp = (mid>tmp)?mid:tmp;
            }else if(nums[mid]==target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        if(start==0 || nums[start-1]!= target){
            ans[0]=-1; ans[1]=-1;
            return ans;
        }else{
            ans[1] = start-1;
        }

        end = start - 1;
        start = tmp;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(nums[mid]<target){
                start = mid + 1;
            }else if(nums[mid]==target){
                end = mid - 1;
            }else{
                end = mid - 1;
            }
        }

        ans[0]=end+1;
        return ans;

    }
}
