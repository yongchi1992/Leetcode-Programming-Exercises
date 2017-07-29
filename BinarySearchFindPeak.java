/**
 * Created by yongchizhang on 17/6/18.
 */
public class BinarySearchFindPeak {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)   return 0;
        int start =0, end = nums.length - 1;
        while(start<=end){
            if(end == start+1){
                int left = (start==0)?Integer.MIN_VALUE:nums[start-1];
                int right = (end==nums.length-1)?Integer.MIN_VALUE:nums[end+1];
                if(nums[start]>left && nums[start]>nums[end]){
                    return start;
                }else{
                    return end;
                }
            }
            if(start == end){
                return start;
            }
            int mid = start +(end -start)/2;
            if(nums[mid]<= nums[start] && mid!=start){
                end = mid - 1;
            }else if(nums[mid]<=nums[end] && mid!= end){
                start = mid + 1;
            }else{
                if(nums[mid]<nums[mid-1]){
                    end = mid - 1;
                }else if(nums[mid]<nums[mid+1]){
                    start = mid + 1;
                }else{
                    return mid;
                }
            }
        }
        return start;
    }


    /*
    *
    * This problem is similar to Local Minimum. And according to the given condition, num[i] != num[i+1], there must exist a O(logN) solution. So we use binary search for this problem.

    If num[i-1] < num[i] > num[i+1], then num[i] is peak
    If num[i-1] < num[i] < num[i+1], then num[i+1...n-1] must contains a peak
    If num[i-1] > num[i] > num[i+1], then num[0...i-1] must contains a peak
    If num[i-1] > num[i] < num[i+1], then both sides have peak
    (n is num.length)

    * */
}
