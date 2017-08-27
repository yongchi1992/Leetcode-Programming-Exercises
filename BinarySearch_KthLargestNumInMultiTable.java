import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yongchizhang on 8/27/17.
 */
public class BinarySearch_KthLargestNumInMultiTable {

    class Solution {
        public int findKthNumber(int m, int n, int k) {
            int start = 1, end = m * n;
            while(start <= end){
                int mid = start + (end - start) / 2;
                int[] temp = rank(m, n, mid);
                if(temp[0] <= k && k <= temp[1]){
                    if(temp[2] > 0)
                        return mid;
                    else
                        start = mid + 1;
                } else if(temp[1] < k){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            return end;
        }

        public int[] rank(int m, int n, int num){
            int[] result = new int[3];
            int res = 0;
            int cnt = 0;
            for(int i = 1; i <= m; i++){
                if(num % i == 0 && num / i <= n){
                    cnt++;
                }
                res += Math.min(num / i, n);
            }
            if(cnt == 0){
                result[0] = res + 1;
                result[1] = res + 1;
            } else {
                result[0] = res - cnt + 1;
                result[1] = res;
                result[2] = cnt;
            }
            return result;
        }
    }


    class Solution_bad {
        class pair{
            int num;
            int factor;
            pair(int num, int factor){
                this.num = num;
                this.factor = factor;
            }
        }

        public int findKthNumber(int m, int n, int k) {
            int[] factor = new int[m + 1];
            PriorityQueue<pair> queue = new PriorityQueue<>(new Comparator<pair>(){
                @Override
                public int compare(pair a, pair b){
                    return a.num - b.num;
                }
            });
            for(int i = 1; i <= m; i++){
                factor[i] = i;
                queue.offer(new pair(i,i));
            }

            for(int i = 0; i < k - 1; i++){
                pair tmp = queue.poll();
                if((tmp.num + tmp.factor) / tmp.factor <= n)
                    queue.offer(new pair(tmp.num + tmp.factor, tmp.factor));
            }
            return queue.poll().num;
        }
    }
}
