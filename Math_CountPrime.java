import java.util.Arrays;

/**
 * Created by yongchizhang on 17/7/14.
 */



public class Math_CountPrime {

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        // Loop's ending condition is i * i <= num instead of i <= sqrt(num)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }


    public class Solution {
        public int countPrimes(int n) {
            boolean[] notPrime = new boolean[n];
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (notPrime[i] == false) {
                    count++;
                    for (int j = 2; i*j < n; j++) {
                        notPrime[i*j] = true;
                    }
                }
            }
            return count;
        }
    }


    public class Solution2 {

        public int countPrimes(int n) {
            boolean[] isPrime = new boolean[n];
            Arrays.fill(isPrime, true);
            // Loop's ending condition is i * i < n instead of i < sqrt(n)
            // to avoid repeatedly calling an expensive function sqrt().
            for (int i = 2; i * i < n; i++) {
                if (!isPrime[i]) continue;
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false;
                }
            }
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (isPrime[i]) count++;
            }
            return count;
        }


    }



    public class Solution3 {

        public int countPrimes(int n) {
            boolean[] notPrime = new boolean[n];
            for(int i = 2; i * i <= n; i++){
                if(!notPrime[i]){
                    for(int j = i * i; j < n; j += i){
                        notPrime[j] = true;
                    }
                }
            }
            int count = 0;
            for(int i = 2; i < n; i++){
                if(!notPrime[i]){
                    count++;
                }
            }
            return count;
        }


    }


}
