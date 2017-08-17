import java.util.HashSet;

/**
 * Created by yongchizhang on 17/8/17.
 */
public class DFS_FrogJump {


    public class Solution {
        public boolean canCross(int[] stones) {
            if (stones == null || stones.length == 0) {return false;}
            int n = stones.length;
            if (n == 1) {return true;}
            if (stones[1] != 1) {return false;}
            if (n == 2) {return true;}
            int last = stones[n - 1];
            HashSet<Integer> hs = new HashSet();
            for (int i = 0; i < n; i++) {
                if (i > 3 && stones[i] > stones[i - 1] * 2) {return false;} // The two stones are too far away.
                hs.add(stones[i]);
            }
            return canReach(hs, last, 1, 1);
        }

        private boolean canReach(HashSet<Integer> hs, int last, int pos, int jump) {
            if (pos + jump - 1 == last || pos + jump == last || pos + jump + 1 == last) {
                return true;
            }
            if (hs.contains(pos + jump + 1)) {
                if (canReach(hs, last, pos + jump + 1, jump + 1)) {return true;}
            }
            if (hs.contains(pos + jump)) {
                if (canReach(hs, last, pos + jump, jump)) {return true;}
            }
            if (jump > 1 && hs.contains(pos + jump - 1)) {
                if (canReach(hs, last, pos + jump - 1, jump - 1)) {return true;}
            }
            return false;
        }

    }



    public class Solution_TimeExceed {
        public boolean success = false;

        public boolean canCross(int[] stones) {
            if(stones == null || stones.length == 0){
                return false;
            }
            if(stones.length == 1){
                return true;
            }
            if(stones[1] != 1){
                return false;
            }
            helper(stones, 1, 0, 2);
            return success;
        }

        public void helper(int[] stones, int idx, int min_step, int max_step){
            if(idx == stones.length - 1){
                success = true;
                return;
            }
            for(int i = min_step; i <= max_step; i++){
                if(i == 0){
                    continue;
                }
                int j = idx + 1;
                while(j < stones.length && stones[j] - stones[idx] < i){
                    j++;
                }
                if(j < stones.length && stones[j] - stones[idx] == i){
                    helper(stones, j, i - 1, i + 1);
                    if(success){
                        return;
                    }
                }
            }
        }
    }
}
