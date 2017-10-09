/**
 * Created by yongchizhang on 10/6/17.
 */
public class Hacker1 {
    /*
 * Complete the function below.
 */

    static int[] getMaxElementIndices(int[] a, int[] rotate) {
        int max = Integer.MIN_VALUE, maxIdx = -1;
        for(int i = 0; i < a.length; i++){
            if(a[i] > max){
                maxIdx = i;
                max = a[i];
            }
        }
        int[] res = new int[rotate.length];
        for(int i = 0; i < rotate.length; i++){
            int step = rotate[i] - rotate[i] / a.length * a.length;
            res[i] = maxIdx - step;
            if(res[i] < 0){
                res[i] += a.length;
            }
        }
        return res;
    }


}
