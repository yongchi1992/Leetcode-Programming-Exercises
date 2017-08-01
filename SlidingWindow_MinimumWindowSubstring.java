/**
 * Created by yongchizhang on 17/7/31.
 */
public class SlidingWindow_MinimumWindowSubstring {
    public class Solution {
        public String minWindow(String s, String t) {
            if(s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()){
                return "";
            }
            Integer[] map = new Integer[128];
            int minstart = -1, minend = -1, min_len = Integer.MAX_VALUE;
            int count = 0;
            for(int i = 0; i < t.length(); i++){
                if(map[t.charAt(i)] == null){
                    map[t.charAt(i)] = 1;
                    count++;
                }else{
                    map[t.charAt(i)]++;
                }
            }
            int begin = 0, end = 0;
            while(end < s.length()){
                char ch = s.charAt(end);
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
                    if(end - begin < min_len){
                        min_len = end - begin;
                        minstart = begin;
                        minend = end;
                    }
                    begin++;
                }
            }
            if(minstart == -1){
                return "";
            }else{
                return s.substring(minstart, minend);
            }
        }
    }
}
