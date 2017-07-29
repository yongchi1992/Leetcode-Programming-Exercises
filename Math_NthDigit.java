/**
 * Created by yongchizhang on 17/7/13.
 */
public class Math_NthDigit {
    public int findNthDigit(int n) {

        int len = 1;
        int start = 1;
        long count = 9;   //要时刻思考数字越界的事
        while(n > count * len){
            n -= count * len;
            len ++;
            start *= 10;
            count *= 10;
        }
        start += (n - 1) / len;
        String result = Integer.toString(start);
        return result.charAt((n - 1) % len) - '0';

    }
}

