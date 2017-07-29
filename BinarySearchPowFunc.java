/**
 * Created by yongchizhang on 17/6/18.
 */
public class BinarySearchPowFunc {
    public double myPow(double x, int n) {

        if(x==1 || x==0)    return x;
        if(x == -1){
            return (n>0)?-1:1;
        }
        double tmp = 1;
        long nl = n;
        if(nl<0){
            nl=-nl;
            x = 1/x ;
        }else if(nl==0){
            return 1;
        }
        while(nl>1){
            if(nl%2==1){
                nl--;
                tmp *= x;
            }else{
                x *= x;
                nl /= 2;
            }
        }
        return tmp*x;
    }
}
