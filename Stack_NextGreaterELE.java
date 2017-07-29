import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * Created by yongchizhang on 17/6/24.
 */
public class Stack_NextGreaterELE {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        HashMap<Integer,Integer> hmp = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<nums.length; i++){
            if(stack.empty()){
                stack.push(nums[i]);
            }else if(nums[i]<=stack.peek()){
                stack.push(nums[i]);
            }else{
                while(!stack.empty() && stack.peek()<nums[i]){
                    hmp.put(stack.pop(),nums[i]);
                }
                stack.push(nums[i]);
            }
        }
        int[] ans = new int[findNums.length];
        for(int i=0; i<ans.length; i++){
            ans[i] = hmp.getOrDefault(findNums[i],-1);
        }
        return ans;
    }



    //  第二道题，循环
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.fill(ans, -1);
        Stack<Integer> stack = new Stack<>();
        for(int ii=0; ii<2*nums.length; ii++){
            int i=ii%nums.length;
            while(!stack.empty() && nums[stack.peek()] < nums[i]){
                ans[stack.pop()] = nums[i];
            }
            if(ii<nums.length)
                stack.push(i);
        }
        return ans;
    }
}
