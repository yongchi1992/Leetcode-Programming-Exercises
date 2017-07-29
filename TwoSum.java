import java.util.HashMap;
import java.util.Map;

/**
 * Created by yongchizhang on 17/6/17.
 */
public class TwoSum {


    public int[] twoSum(int[] numbers, int target){
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            if(map.containsKey(target - numbers[i])){
                result[1]=i+1;
                result[0]=map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i+1);
        }
        return result;
    }
        public int[] twoSum_sorted(int[] numbers, int target) {
            int start =0, end = numbers.length-1;
            while(start<end){
                if(numbers[start]+numbers[end]==target){
                    int[] arr = {start+1, end+1};
                    return arr;
                }else if(numbers[start]+numbers[end]>target){
                    end--;
                }else{
                    start ++;
                }

            }
            return null;
        }

}
