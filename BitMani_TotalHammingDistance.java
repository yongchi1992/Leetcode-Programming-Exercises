/**
 * Created by yongchizhang on 17/8/12.
 */
public class BitMani_TotalHammingDistance {


    public class Solution_best {
        public int totalHammingDistance(int[] nums) {
            int total = 0;
            for(int i = 0; i < 32; i++){
                int count = 0;
                for(int num: nums){
                    count += ((num >> i) & 1);
                }
                total += count * (nums.length - count);
            }
            return total;
        }
    }


    public class Solution_BruteForce {
        public int totalHammingDistance(int[] nums) {
            int sum = 0;
            for(int i = 0; i < nums.length - 1; i++){
                for(int j = i + 1; j < nums.length; j++){
                    sum += calHamming(nums[i], nums[j]);
                }
            }
            return sum;
        }

        public int calHamming(int num1, int num2){
            int num = num1 ^ num2, cnt = 0;
            while(num != 0){
                cnt++;
                num = num & (num - 1);
            }
            return cnt;
        }
    }
}
