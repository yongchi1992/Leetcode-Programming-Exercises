/**
 * Created by yongchizhang on 17/8/9.
 */
import java.util.*;
public class String_isSubseq {
    public class Solution {
        public boolean isSubsequence(String s, String t) {
            if(s.length() == 0){
                return true;
            }
            if(t.length() < s.length()){
                return false;
            }
            int p = 0;
            for(int i = 0; i < t.length(); i++){
                if(t.charAt(i) == s.charAt(p)){
                    p++;
                    if(p == s.length()){
                        return true;
                    }
                }
            }
            return false;
        }
    }



    public class Solution_mybest {
        public boolean isSubsequence(String s, String t) {
            ArrayList<Integer>[] record = new ArrayList[256];
            for(int i = 0; i < t.length(); i++){
                char c = t.charAt(i);
                if(record[c] == null){
                    record[c] = new ArrayList<Integer>();
                }
                record[c].add(i);
            }

            int prev = 0;
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(record[c] == null){
                    return false;
                }
                ArrayList<Integer> list = record[c];
                if(list.get(list.size() - 1) < prev){
                    return false;
                }
                int index = Collections.binarySearch(list, prev);
                if(index < 0){
                    index = -index - 1;
                }
                prev = list.get(index) + 1;
            }

            return true;
        }
    }


    /* If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?

    *
    * 意思就是将t的字符都存在HashMap里面，然后用binarySearch
    *
    */


    public boolean isSubsequence(String s, String t) {
        List<Integer>[] idx = new List[256]; // Just for clarity
        for (int i = 0; i < t.length(); i++) {
            if (idx[t.charAt(i)] == null)
                idx[t.charAt(i)] = new ArrayList<>();
            idx[t.charAt(i)].add(i);
        }

        int prev = 0;
        for (int i = 0; i < s.length(); i++) {
            if (idx[s.charAt(i)] == null) return false; // Note: char of S does NOT exist in T causing NPE
            int j = Collections.binarySearch(idx[s.charAt(i)], prev);    //  j 负数 表示不存在，并给出应该插入的位置
            if (j < 0) j = -j - 1;
            if (j == idx[s.charAt(i)].size()) return false;
            prev = idx[s.charAt(i)].get(j) + 1;
        }
        return true;
    }

}
