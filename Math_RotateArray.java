/**
 * Created by yongchizhang on 17/7/19.
 */
public class Math_RotateArray {

    /*

    Approach #4 Using Reverse [Accepted]

    Algorithm

    This approach is based on the fact that when we rotate the array k times, kk elements from the back end of the array come to the front and the rest of the elements from the front shift backwards.

    In this approach, we firstly reverse all the elements of the array. Then, reversing the first k elements followed by reversing the rest n-kn−k elements gives us the required result.

    Let n=7n=7 and k=3k=3.

    Original List                   : 1 2 3 4 5 6 7
    After reversing all numbers     : 7 6 5 4 3 2 1
    After reversing first k numbers : 5 6 7 4 3 2 1
    After revering last n-k numbers : 5 6 7 1 2 3 4 --> Result

    * */
    public class Solution_best {
        public void rotate(int[] nums, int k) {
            k %= nums.length;
            reverse(nums, 0, nums.length - 1);
            reverse(nums, 0, k - 1);
            reverse(nums, k, nums.length - 1);
        }
        public void reverse(int[] nums, int start, int end) {
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

    }



    public class Solution {
        public void rotate(int[] nums, int k) {
            while(k >= nums.length){
                k -= nums.length;
            }
            if(k <= 0){
                return;
            }
            int[] temp = new int[k];
            for(int i = nums.length - k, j = 0; i < nums.length; i++, j++){
                temp[j] = nums[i];
            }
            for(int i = nums.length - 1, j = nums.length - k - 1; j >=0; j--, i--){
                nums[i] = nums[j];
            }
            for(int i = 0; i < k; i++){
                nums[i] = temp[i];
            }
        }
    }





}
