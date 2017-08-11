import java.util.Arrays;

/**
 * Created by yongchizhang on 17/8/10.
 */
public class Backtracking_NumPartition {
    public class Solution {
        public boolean makesquare(int[] nums) {
            if (nums == null || nums.length < 4) return false;
            int sum = 0;
            for (int num : nums) sum += num;
            if (sum % 4 != 0) return false;

            Arrays.sort(nums);
            reverse(nums);

            int[] sums = new int[]{sum / 4, sum / 4, sum / 4, sum / 4};
            return dfs(nums, sums, 0);
        }

        private boolean dfs(int[] nums, int[] sums, int index) {
            if (index == nums.length) {
                if (sums[0] == 0 && sums[1] == 0 && sums[2] == 0) {
                    return true;
                }
                return false;
            }

            for (int i = 0; i < 4; i++) {
                if (sums[i] - nums[index] < 0) continue;
                sums[i] -= nums[index];
                if (dfs(nums, sums, index + 1)) return true;
                sums[i] += nums[index];
            }

            return false;
        }

        private void reverse(int[] nums) {
            int i = 0, j = nums.length - 1;
            while (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++; j--;
            }
        }
    }


}
