/**
 * Created by yongchizhang on 17/7/26.
 */
public class Array_BuySellStock {

    public class SolutionI {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length <= 1){
                return 0;
            }
            int max = 0;
            int min = prices[0];
            for(int i = 1; i < prices.length; i++){
                if(prices[i] - min > max){
                    max = prices[i] - min;
                }else if(prices[i] < min){
                    min = prices[i];
                }
            }
            return max;
        }
    }


    public class SolutionII {
        public int maxProfit(int[] prices) {
            if(prices == null || prices.length <= 1){
                return 0;
            }
            int result = 0;
            for(int i = 1; i < prices.length; i++){
                if(prices[i] - prices[i - 1] > 0){
                    result += prices[i] - prices[i - 1];
                }
            }
            return result;
        }
    }
}
