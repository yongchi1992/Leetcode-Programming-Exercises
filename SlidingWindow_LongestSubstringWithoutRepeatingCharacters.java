/**
 * Created by yongchizhang on 17/7/31.
 */
public class SlidingWindow_LongestSubstringWithoutRepeatingCharacters {
    public class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s == null || s.length() == 0 ){
                return 0;
            }
            int max = 0;
            boolean[] map = new boolean[128];
            int start = 0, end = 0;
            while(end < s.length()){
                char ch = s.charAt(end);
                if(map[ch] == false){
                    map[ch] = true;
                }else{
                    while(s.charAt(start) != ch){
                        map[s.charAt(start)] = false;
                        start++;
                    }
                    start++;
                }
                if(end - start + 1 > max){
                    max = end - start + 1;
                }
                end++;
            }
            return max;
        }
    }
}
