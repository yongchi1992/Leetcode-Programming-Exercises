/**
 * Created by yongchizhang on 17/6/17.
 */
public class BinarySearchPerfectSquare {
    //这里要mid是long类型，赋值给int的时候要强制类型转换
    public boolean isPerfectSquare(int num) {
        int start = 0, end = num;
        while(start <= end){
            long mid = start+(end - start)/2;
            if(mid*mid<num){
                start = (int)(mid + 1);
            }else if(mid*mid>num){
                end = (int)(mid - 1);
            }else{
                return true;
            }
        }
        return false;
    }

    public boolean isPerfectSquare_Newton(int num) {
        long x = num;
        while (x * x > num) {
            x = (x + num / x) >> 1;
        }
        return x * x == num;
    }
    public static double Sqrt2(double num) {
        double x = num;
        int count = 0;
        while (x * x > num && count<50) {
            x = (x + num/x)*0.5;
            count ++;
        }
        return x;
    }

    public static double Sqrt3(double num) {
        double x = num;
        int count = 0;
        while (x * x * x > num && count<50) {
            x = (2*x + num/(x*x))/3;
            count ++;
        }
        return x;
    }


        public int mySqrt(int x) {
            if(x==0 || x==1)    return x;
            long low = 1, high = x-1;
            while(low<=high){
                long mid = low + (high - low)/2;
                if(mid * mid <= x && (mid+1) * (mid+1) >x){
                    return (int)mid;
                }else if(mid * mid>x ){
                    high = mid - 1;
                }else if((mid+1)*(mid+1)<=x){
                    low = mid + 1;
                }
            }
            return (int)low;
        }


    public int mySqrt2(int x) {
        if(x==0 || x==1)    return x;
        long tmp = x -1;
        while(tmp*tmp>x){
            tmp = (tmp + x/tmp)/2;
        }
        return (int)tmp;
    }

}
