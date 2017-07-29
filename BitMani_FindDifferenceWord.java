/**
 * Created by yongchizhang on 17/7/17.
 */
public class BitMani_FindDifferenceWord {
    public class Solution {
        public char findTheDifference(String s, String t) {
            int n = 0;
            for(int i = 0; i < s.length(); i++){
                n ^= s.charAt(i) - 'a' + 1;
                n ^= t.charAt(i) - 'a' + 1;
            }
            n ^= t.charAt(t.length() - 1) - 'a' + 1;
            char result = (char)('a' + n - 1);
            return result;
        }
    }
}
