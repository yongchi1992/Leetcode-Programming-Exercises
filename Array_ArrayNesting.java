/**
 * Created by yongchizhang on 17/8/1.
 */
public class Array_ArrayNesting {


    //这个因为有0，所以不能用加负号的方法
    public class Solution_best {
        public int arrayNesting(int[] nums) {
            int res = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != Integer.MAX_VALUE) {
                    int start = nums[i], count = 0;
                    while (nums[start] != Integer.MAX_VALUE) {
                        int temp = start;
                        start = nums[start];
                        count++;
                        nums[temp] = Integer.MAX_VALUE;
                    }
                    res = Math.max(res, count);
                }
            }
            return res;
        }
    }




    public class Solution {
        public int arrayNesting(int[] nums) {
            boolean[] record = new boolean[nums.length];
            int count = 0, max = 0;
            for(int i = 0; i < nums.length; i++){
                if(record[nums[i]] == false){
                    int temp = i;
                    while(record[nums[temp]] == false){
                        record[nums[temp]] = true;
                        temp = nums[temp];
                        count++;
                        if(count > max){
                            max = count;
                        }
                    }
                    count = 0;
                }
            }
            return max;
        }
    }


}
