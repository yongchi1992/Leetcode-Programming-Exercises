/**
 * Created by yongchizhang on 17/7/5.
 */
public class Backtracking_BeautifulArrangement {

    public class Solution {
        private int count = 0;
        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        private void helper(int[] nums, int start) {
            if (start == 0) {
                count++;
                return;
            }
            for (int i = start; i > 0; i--) {
                swap(nums, start, i);
                if (nums[start] % start == 0 || start % nums[start] == 0) helper(nums, start-1);
                swap(nums,i, start);
            }
        }
        public int countArrangement(int N) {
            if (N == 0) return 0;
            int[] nums = new int[N+1];
            for (int i = 0; i <= N; i++) nums[i] = i;
            helper(nums, N);
            return count;
        }
    }


    public class Solution2 {

        public int countArrangement(int N) {
            return countArrangement(N, 1, new boolean[N + 1]);
        }

        private int countArrangement(final int N, int pos, final boolean[] used) {
            if (pos > N) return 1;
            int res = 0;
            for (int i = 1; i <= N; i++) {
                if (used[i] == false && (i % pos == 0 || pos % i == 0)) {
                    used[i] = true;
                    res += countArrangement(N, pos + 1, used);
                    used[i] = false;
                }
            }
            return res;
        }
    }



    public class Solution3 {
        public int countArrangement(int N) {
            return helper(N, 1, new boolean[N+1]);
        }
        public int helper(int n, int pos, boolean[] used){
            if(pos > n){
                return 1;
            }
            int res = 0;
            for(int i = 1; i <= n; i++){
                if( (pos % i == 0 || i % pos == 0) && used[i]==false ){
                    used[i] = true;
                    res += helper(n, pos+1, used);
                    used[i] = false;
                }
            }
            return res;
        }
    }
}
