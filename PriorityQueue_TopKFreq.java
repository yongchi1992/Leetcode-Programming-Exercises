/**
 * Created by yongchizhang on 17/7/18.
 */
import java.util.*;
public class PriorityQueue_TopKFreq {
    public class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            HashMap<Integer, Integer> hmp = new HashMap<>();
            for(int i = 0; i < nums.length; i++){
                hmp.put(nums[i], hmp.getOrDefault(nums[i], 0) + 1);
            }
            LinkedList<Integer>[] list = new LinkedList[nums.length + 1];
            for(Integer num: hmp.keySet()){
                int times = hmp.get(num);
                if(list[times] == null){
                    list[times] = new LinkedList<Integer>();
                }
                list[times].add(num);
            }
            List<Integer> result = new LinkedList<>();
            int temp = k;
            for(int i = nums.length; i >= 0; i--){
                if(list[i] != null){
                    for(Integer num: list[i]){
                        result.add(num);
                        temp--;
                    }
                    if(temp == 0){
                        break;
                    }
                }
            }
            return result;
        }
    }
}
