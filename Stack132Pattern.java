import java.util.Stack;

/**
 * Created by yongchizhang on 17/6/25.
 */
public class Stack132Pattern {
    public boolean find132pattern(int[] nums) {
        int[] arr = new int[nums.length];
        int len = 0;
        int n1=0,n3=0,n2=0;
        boolean f1 = false, f2 = false, f3 = false;
        for(int i=0; i<nums.length; i++){
            for(int j=0;j<len;j+=2){
                if(nums[i]>arr[j] && nums[i]<arr[j+1]){
                    return true;
                }
            }

            if(f1==false){
                n1 = nums[i];
                f1 = true;
            }else if(nums[i]>n1 && f2==false){
                n2 = nums[i];
                f2 = true;
            }else if(nums[i]<=n1 && f2==false){
                n1 = nums[i];
            }else if(nums[i]<n2 && nums[i]>n1){
                return true;
            }else if(nums[i]>=n2){
                n2 = nums[i];
            }else if(nums[i]<=n1){
                arr[len] = n1;
                arr[len+1] = n2;
                len+=2;
                n1 = nums[i];
                f2 = false;
            }
        }
        return false;
    }


    public boolean find132pattern2(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1, two = Integer.MIN_VALUE; i >= 0; i--){
            if (nums[i] < two)
                return true;
            else
                while(!stack.empty() && nums[i] > stack.peek() )
                    two = Math.max(two, stack.pop());
            stack.push(nums[i]);
        }
        return false;

    }


    public boolean find132pattern3(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        int s3 = Integer.MIN_VALUE;
        for(int i=nums.length-1; i>=0;i--){
            if(nums[i]<s3){
                return true;
            }else{
                while(!stack.empty() && stack.peek()<nums[i]){
                    s3 = Math.max(s3,stack.pop());
                }
            }
            stack.push(nums[i]);
        }
        return false;
    }



}
