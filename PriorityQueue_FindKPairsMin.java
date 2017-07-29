import java.util.*;
/**
 * Created by yongchizhang on 17/7/20.
 */
public class PriorityQueue_FindKPairsMin {
    public class Solution_best {
        class Pair implements Comparable<Pair>{
            int[] pair;
            int idx; // current index to nums2
            int sum;
            Pair(int idx, int n1, int n2){
                this.idx = idx;
                pair = new int[]{n1, n2};
                sum = n1 + n2;
            }
            @Override
            public int compareTo(Pair that){
                return this.sum - that.sum;
            }
        }

        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<int[]> ret = new ArrayList<>();
            if (nums1==null || nums2==null || nums1.length ==0 || nums2.length ==0) return ret;
            int len1 = nums1.length, len2=nums2.length;

            PriorityQueue<Pair> q = new PriorityQueue(k);
            for (int i=0; i<nums1.length && i<k ; i++) { // only need first k number in nums1 to start
                q.offer( new Pair(0, nums1[i],nums2[0]) );
            }
            for (int i=1; i<=k && !q.isEmpty(); i++) { // get the first k sums
                Pair p = q.poll();
                ret.add( p.pair );
                if (p.idx < len2 -1 ) { // get to next value in nums2
                    int next = p.idx+1;
                    q.offer( new Pair(next, p.pair[0], nums2[next]) );
                }
            }
            return ret;
        }
    }



    public class Solution {
        public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            List<int[]> result = new LinkedList<>();
            PriorityQueue<int[]> queue = new PriorityQueue<>(
                    (a, b) -> a[0] + a[1] - b[0] - b[1]
            );
            if(nums1.length ==0 || nums2.length == 0 || k == 0){
                return result;
            }
            for(int i = 0; i < nums1.length && i < k; i++){
                queue.add(new int[]{nums1[i], nums2[0], 0});
            }
            while(k-- > 0 && !queue.isEmpty()){
                int[] cur = queue.poll();
                result.add(new int[]{cur[0], cur[1]});
                if(cur[2] == nums2.length - 1){
                    continue;
                }
                queue.add(new int[]{cur[0], nums2[cur[2] + 1], cur[2] + 1});
            }
            return result;
        }
    }
}
