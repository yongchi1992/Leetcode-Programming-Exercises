/**
 * Created by yongchizhang on 17/7/26.
 */
import java.util.*;
public class Array_KDiffPairs {


    public class Solution {
        public int findPairs(int[] nums, int k) {
            if(k < 0){
                return 0;
            }
            int count = 0;
            HashMap<Integer, Boolean> hmp = new HashMap<>();
            for(int num : nums){
                if(hmp.containsKey(num - k) && hmp.get(num - k) == false){
                    hmp.put(num - k, true);
                    count++;
                }
                if(hmp.containsKey(num + k) && (!hmp.containsKey(num) || hmp.get(num) == false)){
                    hmp.put(num, true);
                    count++;
                }
                if(!hmp.containsKey(num)){
                    hmp.put(num, false);
                }
            }
            return count;

        }
    }



    public class Solution2 {
        public int findPairs(int[] nums, int k) {
            if(k < 0){
                return 0;
            }
            int count = 0;
            if(k == 0){
                HashMap<Integer, Boolean> hmp = new HashMap<>();
                for(int num : nums){
                    if(!hmp.containsKey(num)){
                        hmp.put(num, false);
                    }else{
                        if(hmp.get(num) == false){
                            count++;
                            hmp.put(num, true);
                        }
                    }
                }
                return count;
            }else{
                HashSet<Integer> record = new HashSet<>();
                for(int num : nums){
                    if(record.add(num)){
                        if(record.contains(num + k)){
                            count++;
                        }
                        if(record.contains(num - k)){
                            count++;
                        }
                    }
                }
                return count;
            }
        }
    }
}
