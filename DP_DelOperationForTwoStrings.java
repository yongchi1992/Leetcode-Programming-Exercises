/**
 * Created by yongchizhang on 17/8/15.
 */
public class DP_DelOperationForTwoStrings {
    public class Solution {
        public int minDistance(String word1, String word2) {
            int l1 = word1.length(), l2 = word2.length();
            int[][] table = new int[l1 + 1][l2 + 1];
            //  if(word1(i) == word2(j))   LCS(i, j) = LCS(i - 1, j -1) + 1
            //  else                       LCS(i, j) = LCS(i, j - 1)  || LCS(i - 1, j)
            for(int i = 1; i <= l1; i++){
                for(int j = 1; j <= l2; j++){
                    if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                        table[i][j] = table[i - 1][j - 1] + 1;
                    } else {
                        table[i][j] = Math.max(table[i][j - 1], table[i - 1][j]);
                    }
                }
            }
            int LCS = table[l1][l2];
            return l1 + l2 - 2 * LCS;
        }
    }
}
