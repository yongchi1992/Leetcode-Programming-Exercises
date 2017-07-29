/**
 * Created by yongchizhang on 17/6/18.
 */
public class BinSearchStairNum {
    public int arrangeCoins(int n) {
        if(n<=0)  return 0;
        long low = 1, high = (long)(Math.sqrt(2)*Math.sqrt(n)+1);
        while(low<=high){
            long mid = low+(high-low)/2;
            long res1 = mid*(mid+1)/2, res2=(mid+1)*(mid+2)/2;
            if(n>=res1 && n<res2){
                return (int)mid;
            }else if(n<res1){
                high = mid-1;
            }else if(n==res2){
                return (int)(mid+1);
            }else if(n>res2){
                low = mid+1;
            }
        }
        return (int)low;
    }

    public int arrangeCoins2(int n) {
        return (int)(-0.5+Math.sqrt((double)2*n+0.25));
    }
}
