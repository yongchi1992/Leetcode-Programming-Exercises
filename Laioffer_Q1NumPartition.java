import java.util.Stack;

/**
 * Created by yongchizhang on 17/8/11.
 */
public class Laioffer_Q1NumPartition {
    public static int count = 0;
    public static void main(String[] args){
        int[] candidates = new int[]{1, 2, 3, 0, 3};
        System.out.println(numPartition(candidates, 3));
    }
    public static int numPartition(int[] candidates, int k){
        if(candidates.length < k){
            return 0;
        }
        int sum = 0;
        for(int c: candidates){
            sum += c;
        }
        if(sum % k != 0){
            return 0;
        }
        sum /= k;
        int[] partition = new int[k];
        for(int i = 0; i < k; i++){
            partition[i] = sum;
        }
        count = 0;
        dfs(candidates, partition, 0, 0, k);
        return count;
    }

    public static void dfs(int[] candidates, int[] partition, int index, int start, int k){
        if(start == candidates.length){
            if(index == k - 1 && partition[index] == 0){
                count++;
            }
            return;
        }

        if(partition[index] == 0){
            if(index == k - 1){
                partition[index] -= candidates[start];
                dfs(candidates, partition, index, start + 1, k);
            } else {
                // put to next

                int[] tmp_partition = new int[k];
                System.arraycopy(partition, 0, tmp_partition, 0, k);

                partition[index + 1] -= candidates[start];
                dfs(candidates, partition, index + 1, start + 1, k);

                //do not put to next
                partition[index] -= candidates[start];
                dfs(candidates, tmp_partition, index, start + 1, k);
            }

        } else {

            partition[index] -= candidates[start];
            dfs(candidates, partition, index, start + 1, k);
        }

    }




    // Optimal Solution: Time O(n) Space O(1)
    public int waysOfSplit(int[] candidates) {
        Stack<Integer> stack = new Stack<>();

        if (candidates == null || candidates.length < 3) {
            return 0;
        }
        int sum = 0;
        for(int c : candidates){
            sum += c;
        }
        if (sum % 3 != 0) {
            return 0;
        }
        int groupCap = sum / 3;
        int prefixSum = 0;
        int prevWays = 0;
        int totalWays = 0;
        for (int i = 0; i < candidates.length - 1; i++) {
            prefixSum += candidates[i];
            if (prefixSum == groupCap * 2) {
                totalWays += prevWays;
            }
            if (prefixSum == groupCap) {
                prevWays++;
            }
        }
        return totalWays;
    }

}
