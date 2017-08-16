import java.util.HashMap;

/**
 * Created by yongchizhang on 17/8/16.
 */
public class DP_DFSMem_CanIWin {
    public class Solution {
        boolean[] used;
        HashMap<Integer, Boolean> map;
        public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
            int sum = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
            if(maxChoosableInteger >= desiredTotal){
                return true;
            } else if(sum < desiredTotal){
                return false;
            }
            used = new boolean[maxChoosableInteger + 1];
            map = new HashMap<>();
            return helper(desiredTotal);
        }

        public boolean helper(int target){
            if(target <= 0){
                return false;
            }
            int key = format();
            if(map.containsKey(key)){
                return map.get(key);
            }
            for(int i = 1; i < used.length; i++){
                if(!used[i]){
                    used[i] = true;
                    if(!helper(target - i)){
                        map.put(key, true);
                        used[i] = false;
                        return true;
                    }
                    used[i] = false;
                }
            }
            map.put(key,false);
            return false;
        }

        public int format(){
            int num = 0;
            for(int i = 0; i < used.length; i++){
                num <<= 1;
                if(used[i]){
                    num++;
                }
            }
            return num;
        }
    }
}
