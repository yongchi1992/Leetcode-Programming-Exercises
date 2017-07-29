import java.util.HashMap;

/**
 * Created by yongchizhang on 17/7/4.
 */
public class HashMap_RamsonNote {
    public class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            HashMap<Character, Integer> hmp = new HashMap<>();
            for(char ch : magazine.toCharArray()){
                hmp.put(ch, hmp.getOrDefault(ch, 0) + 1);
            }
            for(char ch: ransomNote.toCharArray()){
                hmp.put(ch, hmp.getOrDefault(ch, 0) - 1);
                if(hmp.get(ch)<0){
                    return false;
                }
            }
            return true;
        }
    }

    public class Solution2 {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] ch = new int[128];
            for(int i = 0; i< magazine.length(); i++){
                ch[magazine.charAt(i)]++;
            }
            for(int i = 0; i < ransomNote.length(); i++){
                if(--ch[ransomNote.charAt(i)] < 0){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] table = new int[128];
        for (char c : magazine.toCharArray())   table[c]++;
        for (char c : ransomNote.toCharArray())
            if (--table[c] < 0) return false;
        return true;
    }

}
