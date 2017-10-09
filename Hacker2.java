/**
 * Created by yongchizhang on 10/6/17.
 */
public class Hacker2 {
    /*
 * Complete the function below.
 */

    static int getMinimumMoves(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        } else if(height.length <= 2){
            return 1;
        }
        int res = Integer.MAX_VALUE;
        int[] front = new int[height.length], end = new int[height.length];
        front[0] = 1;
        end[height.length - 1] = 1;
        for(int i = 1; i < height.length; i++){
            if(height[i] < height[i - 1]){
                front[i] = front[i - 1] + 1;
            } else {
                front[i] = front[i - 1];
            }

            if(height[height.length - i - 1] >= height[height.length - i]){
                end[height.length - i - 1] = end[height.length - i];
            } else {
                end[height.length - i - 1] = end[height.length - i] + 1;
            }
        }
        for(int i = 0; i < height.length; i++){
            if(i == height.length - 1){
                res = Math.min(res, front[i]);
            } else {
                res = Math.min(res, front[i] + end[i + 1]);
            }
        }
        return res;
    }


}
