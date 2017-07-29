/**
 * Created by yongchizhang on 17/7/27.
 */
import java.util.*;
public class HashMap_LongestPalindrome {

    public class Solution_best {
        public int longestPalindrome(String s) {
            boolean[] map = new boolean[128];
            int len = 0;
            for (char c : s.toCharArray()) {
                map[c] = !map[c];         // flip on each occurrence, false when seen n*2 times
                if (!map[c]) len+=2;
            }
            if (len < s.length()) len++; // if more than len, atleast one single is present
            return len;
        }

    }



    public int longestPalindrome(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
    }




    public class Solution {
        public int longestPalindrome(String s) {
            HashMap<Character, Integer> map = new HashMap<>();
            int result = 0;
            for(int i = 0; i < s.length(); i++){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for(int ele : map.values()){
                result += ele % 2 == 0 ? ele : ele - 1;
            }
            return result == s.length() ? result : result + 1;
        }
    }
}
