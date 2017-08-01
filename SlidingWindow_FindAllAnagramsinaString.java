/**
 * Created by yongchizhang on 17/7/30.
 */
import java.util.*;


//  https://discuss.leetcode.com/topic/68976/sliding-window-algorithm-template-to-solve-all-the-leetcode-substring-search-problem

public class SlidingWindow_FindAllAnagramsinaString {


    public class Solution_best {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new LinkedList<>();
            if(s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()){
                return result;
            }
            Integer[] map = new Integer[128];
            int count = 0;
            for(int i = 0; i < p.length(); i++){
                if(map[p.charAt(i)] == null){
                    map[p.charAt(i)] = 1;
                    count++;
                }else{
                    map[p.charAt(i)]++;
                }
            }
            int begin = 0, end = 0;
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(map[ch] != null){
                    map[ch]--;
                    if(map[ch] == 0){
                        count--;
                    }
                }
                end++;
                while(count == 0){
                    char c = s.charAt(begin);
                    if(map[c] != null){
                        map[c]++;
                        if(map[c] > 0){
                            count++;
                        }
                    }
                    if(end - begin == p.length()){
                        result.add(begin);
                    }
                    begin++;
                }
            }
            return result;
        }
    }


    public class Solution {

        Integer[] record = new Integer[26];

        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> result = new LinkedList<>();
            if(s == null || p == null || s.length() == 0 || p.length() == 0){
                return result;
            }

            int m = s.length(), n = p.length();
            for(int i = 0; i < n; i++){
                record[p.charAt(i) - 'a'] = record[p.charAt(i) - 'a'] == null ? 1 : record[p.charAt(i) - 'a'] + 1;
            }
            Integer[] temp = new Integer[26];
            reset(temp);
            int start = 0, end = 0;
            while(end < m){
                int index = s.charAt(end) - 'a';
                if(temp[index] != null){
                    if(temp[index] > 0){
                        temp[index]--;
                        if(end - start == n - 1){
                            result.add(start);
                            temp[s.charAt(start) - 'a']++;
                            start++;
                        }
                    }else{
                        while(s.charAt(start) != s.charAt(end)){
                            temp[s.charAt(start) - 'a']++;
                            start++;
                        }
                        temp[s.charAt(start) - 'a']++;
                        start++;
                        temp[index]--;
                    }
                    end++;
                } else {   //   == null
                    end++;
                    start = end;
                    reset(temp);
                }
            }
            return result;
        }

        public void reset(Integer[] temp){
            for(int i = 0; i < 26; i++){
                temp[i] = record[i];
            }
        }
    }
}
