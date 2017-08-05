import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by yongchizhang on 17/8/4.
 */
public class Sort_RelativeRanks {


    public class Solution_fastestbest {
        public String[] findRelativeRanks(int[] nums) {
            int n = nums.length;
            String[] res = new String[n];
            PriorityQueue<Integer> queue = new PriorityQueue<>(
                    new Comparator<Integer>(){
                        @Override
                        public int compare(Integer a, Integer b){
                            return nums[b] - nums[a];
                        }
                    });
            for(int i = 0; i < n; i++){
                queue.add(i);
            }
            for(int i = 0; i < n; i++){
                int idx = queue.poll();
                if(i == 0){
                    res[idx] = "Gold Medal";
                } else if (i == 1){
                    res[idx] = "Silver Medal";
                } else if (i == 2) {
                    res[idx] = "Bronze Medal";
                } else {
                    res[idx] = String.valueOf(i + 1);
                }
            }
            return res;
        }
    }

    // O(1) Space  use the result  String[]  to record
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(nums);

        for (int i = 0; i < res.length; i++) {
            int n = Integer.valueOf(res[i]);
            int rank = res.length - Arrays.binarySearch(nums, n);
            if (rank == 1) {
                res[i] = "Gold Medal";
            } else if (rank == 2) {
                res[i] = "Silver Medal";
            } else if (rank == 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = String.valueOf(rank);
            }
        }
        return res;
    }




    public class Solution_fastest {
        public class Pair{
            int num;
            int idx;
            public Pair(int n, int i){
                num = n;
                idx = i;
            }
        }
        public String[] findRelativeRanks(int[] nums) {
            int n = nums.length;
            String[] res = new String[n];
            PriorityQueue<Pair> queue = new PriorityQueue<>(
                    new Comparator<Pair>(){
                        @Override
                        public int compare(Pair a, Pair b){
                            return b.num - a.num;
                        }
                    });
            for(int i = 0; i < n; i++){
                queue.add(new Pair(nums[i], i));
            }
            for(int i = 0; i < n; i++){
                Pair temp = queue.poll();
                if(i == 0){
                    res[temp.idx] = "Gold Medal";
                } else if (i == 1){
                    res[temp.idx] = "Silver Medal";
                } else if (i == 2) {
                    res[temp.idx] = "Bronze Medal";
                } else {
                    res[temp.idx] = String.valueOf(i + 1);
                }
            }
            return res;
        }
    }




    public class Solution_best {
        public String[] findRelativeRanks(int[] nums) {
            Integer[] index = new Integer[nums.length];

            for (int i = 0; i < nums.length; i++) {
                index[i] = i;
            }

            Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));

            String[] result = new String[nums.length];

            for (int i = 0; i < nums.length; i++) {
                if (i == 0) {
                    result[index[i]] = "Gold Medal";
                }
                else if (i == 1) {
                    result[index[i]] = "Silver Medal";
                }
                else if (i == 2) {
                    result[index[i]] = "Bronze Medal";
                }
                else {
                    result[index[i]] = (i + 1) + "";
                }
            }

            return result;
        }
    }




    public class Solution {
        public class Pair{
            int num;
            int idx;
            public Pair(int n, int i){
                num = n;
                idx = i;
            }
        }
        public String[] findRelativeRanks(int[] nums) {
            int n = nums.length;
            Pair[] pairs = new Pair[n];
            String[] res = new String[n];
            for(int i = 0; i < n; i++){
                pairs[i] = new Pair(nums[i], i);
            }
            Arrays.sort(pairs, new Comparator<Pair>(){
                @Override
                public int compare(Pair a, Pair b){
                    return b.num - a.num;
                }
            });
            //  简单的写法
            // Arrays.sort(pairs, (a,b) -> b.num - a.num);
            for(int i = 0; i < n; i++){
                if(i == 0){
                    res[pairs[0].idx] = "Gold Medal";
                } else if (i == 1){
                    res[pairs[1].idx] = "Silver Medal";
                } else if (i == 2) {
                    res[pairs[2].idx] = "Bronze Medal";
                } else {
                    res[pairs[i].idx] = String.valueOf(i + 1);
                }
            }
            return res;
        }
    }
}
