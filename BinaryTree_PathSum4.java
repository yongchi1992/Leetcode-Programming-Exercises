/**
 * Created by yongchizhang on 8/26/17.
 */
public class BinaryTree_PathSum4 {

    // heap 在数组里的实现，下标是从1开始
    class Solution {

        public int pathSum(int[] nums) {
            Integer[] record = new Integer[16];
            int max_D = 0;
            int res = 0;
            boolean[] used = new boolean[16];
            for(int num : nums){
                int V = num % 10;
                int P = (num / 10) % 10;
                int D = num / 100;
                max_D = Math.max(D, max_D);
                int idx = (1 << (D - 1)) - 1 + P;
                record[idx] = V;
            }
            for(int i = record.length - 1; i >= 0; i--){
                if(record[i] != null && !used[i]){
                    int j = i;
                    while(j != 0){
                        res += record[j];
                        used[j] = true;
                        j /= 2;
                    }
                }
            }
            return res;
        }
    }
}
