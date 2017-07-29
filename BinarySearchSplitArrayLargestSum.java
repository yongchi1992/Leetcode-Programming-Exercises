/**
 * Created by yongchizhang on 17/6/23.
 */
public class BinarySearchSplitArrayLargestSum {

    /*
    * The answer is between maximum value of input array numbers and sum of those numbers.
Use binary search to approach the correct answer. We have l = max number of array; r = sum of all numbers in the array;Every time we do mid = (l + r) / 2;
Use greedy to narrow down left and right boundaries in binary search.
3.1 Cut the array from left.
3.2 Try our best to make sure that the sum of numbers between each two cuts (inclusive) is large enough but still less than mid.
3.3 We'll end up with two results: either we can divide the array into more than m subarrays or we cannot.
If we can, it means that the mid value we pick is too small because we've already tried our best to make sure each part holds as many non-negative numbers as we can but we still have numbers left. So, it is impossible to cut the array into m parts and make sure each parts is no larger than mid. We should increase m. This leads to l = mid + 1;
If we can't, it is either we successfully divide the array into m parts and the sum of each part is less than mid, or we used up all numbers before we reach m. Both of them mean that we should lower mid because we need to find the minimum one. This leads to r = mid - 1;
    * **/

    public int splitArray(int[] nums, int m) {
        int max = 0; long sum = 0;
        for (int num : nums) {
            max = Math.max(num, max);
            sum += num;
        }
        if (m == 1) return (int)sum;
        //binary search
        long l = max; long r = sum;
        while (l <= r) {
            long mid = (l + r)/ 2;
            if (valid(mid, nums, m)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return (int)l;
    }
    public boolean valid(long target, int[] nums, int m) {
        int count = 1;
        long total = 0;
        for(int num : nums) {
            total += num;
            if (total > target) {
                total = num;
                count++;
                if (count > m) {
                    return false;
                }
            }
        }
        return true;
    }


    //下面两个自己写的

    public int splitArray2(int[] nums, int m){
        int low=0, high=0;
        for(int i=0;i<nums.length; i++){
            high += nums[i];
            low = (nums[i]>low)?nums[i]:low;
        }
        while(low<=high){
            int mid = low + (high-low)/2;
            if(valid(nums,m,mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return low  ;


    }

    public boolean valid(int[] nums, int m, int max){
        int sum =0, cnt = 0;
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            if(sum>max){
                cnt++;
                if(cnt >=m){
                    return false;
                }
                sum=nums[i];
            }
        }
        return true;
    }


    public int splitArray_DP(int[] nums, int m){
        int[][] arr = new int[nums.length][m];
        arr[0][0] = nums[0];
        for(int i=1;i< nums.length; i++)
            arr[i][0] = arr[i-1][0] + nums[i];

        for(int j=1; j<m; j++){
            for(int i=1; i<nums.length; i++){
                int min = Integer.MAX_VALUE;
                int sum = 0;
                for(int k=i-1;k>=0;k--){
                    sum += nums[k+1];
                    min = Math.min(min,Math.max(arr[k][j-1],sum));
                }
                arr[i][j]=min;
            }
        }
        return arr[nums.length-1][m-1];
    }



    public int splitArrayDP2(int[] nums, int m){
        int[][] arr = new int[nums.length][m];
        arr[0][0] = nums[0];
        for(int i=1;i< nums.length; i++)
            arr[i][0] = arr[i-1][0] + nums[i];

        for(int j=1; j<m; j++){
            for(int i=1; i<nums.length; i++){
                if(j==m-1){
                    i=nums.length - 1;
                }
                int min = Integer.MAX_VALUE;
                int sum = 0;
                for(int k=i-1;k>=0;k--){
                    sum += nums[k+1];
                    min = Math.min(min,Math.max(arr[k][j-1],sum));
                }
                arr[i][j]=min;
            }
        }
        return arr[nums.length-1][m-1];
    }
}
