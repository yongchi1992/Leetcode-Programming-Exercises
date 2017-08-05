/**
 * Created by yongchizhang on 17/8/4.
 */

import java.util.*;
public class HashMap_DistributeCandies {
    public class Solution {
        public int distributeCandies(int[] candies) {
            Arrays.sort(candies);
            int count = 1;
            for (int i = 1; i < candies.length && count < candies.length / 2; i++)
                if (candies[i] > candies[i - 1])
                    count++;
            return count;
        }
    }
    public class Solution_best {
        public int distributeCandies(int[] candies) {
            HashSet<Integer> set = new HashSet<>();
            for(int candy : candies){
                set.add(candy);
            }
            return set.size() > candies.length / 2 ? candies.length / 2 : set.size();
        }
    }
}
