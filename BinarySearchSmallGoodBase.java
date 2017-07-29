/**
 * Created by yongchizhang on 17/6/17.
 */
import java.math.*;
public class BinarySearchSmallGoodBase {
    public String smallestGoodBase(String n) {
        long nl = Long.parseLong(n);
        int kmax = (int) (Math.log(nl)/Math.log(2)) + 1;
        for(int k = kmax; k >= 3; k--){
            long max = (long)Math.pow(nl, 1.0/(k-1)), min =2;
            while(min<=max){
                long mid = min + (max - min)/2 ;
                BigInteger left = BigInteger.valueOf(mid).subtract(BigInteger.ONE).multiply(BigInteger.valueOf(nl));
                BigInteger right = BigInteger.valueOf(mid).pow(k).subtract(BigInteger.ONE);
                int cmp = left.compareTo(right);
                if(cmp==0){
                    return ""+mid;
                }else if(cmp<0){
                    max = mid - 1;
                }else{
                    min = mid + 1;
                }
            }


        }
        return ""+(nl-1);
    }


    public String smallestGoodBase2(String n) {
        long num = Long.parseLong(n);
        long x = 1;
        for (int p = 60; p >= 2; p--) {
            if ((x << p) < num) {
                long k = helper(num, p);
                if (k != -1) return String.valueOf(k);
            }
        }
        return String.valueOf(num - 1);
    }

    private long helper(long num, int p) {
        long l = 1, r = (long)(Math.pow(num, 1.0/p) + 1);
        while (l < r) {
            long mid = l + (r - l) / 2;
            long sum = 0, cur = 1;
            for (int i = 0; i <= p; i++) {
                sum += cur;
                cur *= mid;
            }
            if (sum == num) return mid;
            else if (sum > num) r = mid;
            else l = mid + 1;
        }
        return -1;
    }


    public String smallestGoodBase_my2(String n) {
        long num = Long.parseLong(n);
        int kmax =(int)(Math.log(num)/Math.log(2)) + 1;
        for(int k=kmax; k>=3; k--){
            long max = (long) Math.pow(num, 1.0/(k-1)), min = 2;

            while(min<=max){
                long tmp = num, adder = 1;
                long mid = min + (max - min)/2;
                for(int i=0; i<k; i++){
                    tmp -= adder;
                    adder *= mid;
                    if(tmp<0)
                        break;
                }
                if(tmp==0){
                    return ""+mid;
                }else if(tmp>0){
                    min = mid + 1;
                }else{
                    max = mid - 1;
                }
            }
        }
        return String.valueOf(num - 1);
    }
}
