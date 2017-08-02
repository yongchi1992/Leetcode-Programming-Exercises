import java.util.Arrays;

/**
 * Created by yongchizhang on 17/8/1.
 */
public class Array_ValidTriangleNum {

    public class Solution_best {
        public int triangleNumber(int[] nums) {
            int count = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int k = i + 2;
                for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                    while (k < nums.length && nums[i] + nums[j] > nums[k])
                        k++;
                    count += k - j - 1;
                }
            }
            return count;
        }
    }




    //Binary Search  O(n^2 log n)
    public class Solution {
        int binarySearch(int nums[], int l, int r, int x) {
            while (r >= l && r < nums.length) {
                int mid = (l + r) / 2;
                if (nums[mid] >= x)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            return l;
        }
        public int triangleNumber(int[] nums) {
            int count = 0;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int k = i + 2;
                for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                    k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
                    count += k - j - 1;
                }
            }
            return count;
        }
    }

}
