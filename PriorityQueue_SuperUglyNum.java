/**
 * Created by yongchizhang on 17/7/19.
 */
import java.util.*;
public class PriorityQueue_SuperUglyNum {
    public class Solution_best {

        class datatype implements Comparable<datatype>{
            int num;
            int factor;
            int pos;
            datatype(int _num, int _factor, int _pos){
                num = _num;
                factor = _factor;
                pos = _pos;
            }
            @Override
            public int compareTo(datatype that){
                return this.num - that.num;
            }
        }

        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] ugly = new int[n];
            ugly[0] = 1;
            PriorityQueue<datatype> queue = new PriorityQueue<>();
            for(int i = 0; i < primes.length; i++){
                queue.add(new datatype(primes[i], primes[i], 0));
            }
            int i = 1;
            while(i < n){
                datatype res = queue.poll();
                if(res.num == ugly[i - 1]){
                    queue.add(new datatype(res.factor * ugly[res.pos + 1], res.factor, res.pos + 1));
                    continue;
                }
                ugly[i] = res.num;
                if(res.pos < n - 1)
                    queue.add(new datatype(res.factor * ugly[res.pos + 1], res.factor, res.pos + 1));
                i++;
            }
            return ugly[n - 1];
        }
    }



    public class Solution {

        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] ugly = new int[n];
            ugly[0] = 1;
            TreeSet<Integer> queue = new TreeSet<>(
                    new Comparator<Integer>(){
                        @Override
                        public int compare(Integer a, Integer b){
                            return (int) a - (int) b;
                        }
                    }
            );
            for(int i = 0; i < primes.length; i++){
                queue.add(primes[i]);
            }
            int i = 1;
            while(i < n){
                int res = (int) queue.pollFirst();
                if(res == ugly[i - 1]){
                    continue;
                }
                ugly[i] = res;
                for(int j = 0; j < primes.length; j++)
                    if( (long) (ugly[i] * primes[j]) < (long) Integer.MAX_VALUE)
                        queue.add(ugly[i] * primes[j]);
                i++;
            }
            return ugly[n - 1];
        }
    }






    public class Solution2 {

        class datatype{
            int num;
            int factor;
            int pos;
            datatype(int _num, int _factor, int _pos){
                num = _num;
                factor = _factor;
                pos = _pos;
            }
        }

        public int nthSuperUglyNumber(int n, int[] primes) {
            int[] ugly = new int[n];
            ugly[0] = 1;
            PriorityQueue<datatype> queue = new PriorityQueue<>(
                    new Comparator<datatype>(){
                        @Override
                        public int compare(datatype a, datatype b){
                            return  a.num - b.num;
                        }
                    }
            );
            for(int i = 0; i < primes.length; i++){
                queue.add(new datatype(primes[i], primes[i], 0));
            }
            int i = 1;
            while(i < n){
                datatype res = queue.poll();
                if(res.num == ugly[i - 1]){
                    queue.add(new datatype(res.factor * ugly[res.pos + 1], res.factor, res.pos + 1));
                    continue;
                }
                ugly[i] = res.num;
                if(res.pos < n - 1)
                    queue.add(new datatype(res.factor * ugly[res.pos + 1], res.factor, res.pos + 1));
                i++;
            }
            return ugly[n - 1];
        }
    }
}
