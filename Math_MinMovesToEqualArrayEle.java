/**
 * Created by yongchizhang on 17/7/19.
 */
public class Math_MinMovesToEqualArrayEle {
    /*
    let's define sum as the sum of all the numbers, before any moves; minNum as the min number int the list; n is the length of the list;

    After, say m moves, we get all the numbers as x , and we will get the following equation

    sum + m * (n - 1) = x * n
    and actually,

    x = minNum + m
    and finally, we will get

    sum - minNum * n = m
    So, it is clear and easy now.

*/


    public class Solution {
        public int minMoves(int[] nums) {
            int result = 0, min = Integer.MAX_VALUE;
            for(int i = 0; i < nums.length; i++){
                result += nums[i];
                if(nums[i] < min){
                    min = nums[i];
                }
            }
            result -= min * nums.length;
            return result;
        }
    }


}
