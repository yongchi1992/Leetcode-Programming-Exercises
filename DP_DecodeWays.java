/**
 * Created by yongchizhang on 17/7/28.
 */
public class DP_DecodeWays {


    public class Solution_best {
        public int numDecodings(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            int n = s.length();
            int[] record = new int[n];
            if(s.charAt(n - 1) != '0'){
                record[n - 1] = 1;
            }
            if(n == 1){
                return record[0];
            }
            if(s.charAt(n - 2) != '0'){
                record[n - 2] += record[n - 1];
                int temp = 10 * (s.charAt(n - 2) - '0') + s.charAt(n - 1) - '0';
                if(temp >= 1 && temp <= 26){
                    record[n - 2]++;
                }
            }
            for(int i = n - 3; i >= 0; i--){
                if(s.charAt(i) != '0'){
                    record[i] = record[i + 1];
                    int temp = 10 * (s.charAt(i) - '0') + s.charAt(i + 1) - '0';
                    if(temp >= 1 && temp <= 26){
                        record[i] += record[i + 2];
                    }
                }
            }
            return record[0];
        }
    }



    // DFS 超时
    public class Solution {
        private int sum = 0;
        public int numDecodings(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            helper(s, 0);
            return sum;
        }
        public void helper(String s, int start){
            if(start == s.length()){
                sum++;
                return;
            }
            if(s.charAt(start) != '0'){
                helper(s, start + 1);
                if(start < s.length() - 1){
                    int num = 10 * (s.charAt(start) - '0') + s.charAt(start + 1) - '0';
                    if(num >= 1 && num <= 26){
                        helper(s, start + 2);
                    }
                }
            }
        }
    }





}
