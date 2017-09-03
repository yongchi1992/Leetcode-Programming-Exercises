/**
 * Created by yongchizhang on 8/29/17.
 */
import java.util.*;
public class DP_CoinChange {
    public class Solution {
        public int coinChange(int[] coins, int amount) {
            int max = amount + 1;
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, max);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }


    class Solution_my {
        public int coinChange(int[] coins, int amount) {
            Integer[] dp = new Integer[amount + 1];
            dp[0] = 0;
            for(int i = 1; i <= amount; i++){
                for(int coin: coins){
                    if(coin <= i && dp[i - coin] != null){
                        dp[i] = dp[i] == null ? dp[i - coin] + 1 : Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }
            return dp[amount] == null ? -1 : dp[amount];
        }
    }



    public class Solution2 {

        public int coinChange(int[] coins, int amount) {
            if (amount < 1) return 0;
            return coinChange(coins, amount, new int[amount]);
        }

        private int coinChange(int[] coins, int rem, int[] count) {
            if (rem < 0) return -1;
            if (rem == 0) return 0;
            if (count[rem - 1] != 0) return count[rem - 1];
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = coinChange(coins, rem - coin, count);
                if (res >= 0 && res < min)
                    min = 1 + res;
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];
        }
    }



    class Solution_worst {
        public int coinChange(int[] coins, int amount) {
            if(amount <= 0){
                return 0;
            }
            Integer[] record = new Integer[amount + 1];
            for(int i = 1; i <= amount; i++){
                for(int coin : coins){
                    if(coin == i){
                        record[i] = 1;
                    }
                }
                if(record[i] != null){
                    continue;
                }
                int left = 1, right = i - 1;
                Integer min = null;
                while(left <= right){
                    if(record[left] != null && record[right] != null){
                        if(min == null || min > record[left] + record[right]){
                            min = record[left] + record[right];
                        }
                    }
                    left++;
                    right--;
                }
                record[i] = min;
            }
            return record[amount] == null ? -1 : record[amount];
        }
    }


}
