/**
 * Created by yongchizhang on 17/6/17.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(divisor==0 || (dividend == Integer.MIN_VALUE && divisor == -1)){
            return Integer.MAX_VALUE;
        }
        long a = (long)dividend;
        long b = (long)divisor;
        int sign = 1; int ans =0;
        if(a<0){
            a=~a+1;
            sign = ~sign+1;
        }
        if(b<0){
            b=~b+1;
            sign = ~sign+1;
        }
        if(a<b){
            return 0;
        }
        while(a>=b){
            long tmp = b;
            int res = 1;
            while(tmp<<1 < a){
                tmp = tmp << 1;
                res <<=1 ;
            }
            a -= tmp;
            ans += res;
        }
        return (sign==1)?ans:(~ans+1);
    }
}
