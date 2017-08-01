import java.util.HashMap;

/**
 * Created by yongchizhang on 17/7/29.
 */
public class HashMap_IsomorphicStrings {

    // 用数组应该是最好了   假如是 HashMap<Character, Integer>  可以用   Integer[128]
    // 假如是   HashMap<Character, Character>   可以用    Character[128]
    // 总之    HashMap<Character, xxx>   可以用   xxx[128]

    public class Solution_best {
        public boolean isIsomorphic(String s, String t) {
            if(s == null || t == null){
                return false;
            }
            if(s.length() != t.length()){
                return false;
            }
            Character[] record = new Character[128];
            boolean[] used = new boolean[128];
            for(int i = 0; i < s.length(); i++){
                if(record[s.charAt(i)] == null){
                    record[s.charAt(i)] = t.charAt(i);
                    if(used[t.charAt(i)]){
                        return false;
                    }
                    used[t.charAt(i)] = true;
                }else{
                    if(record[s.charAt(i)] != t.charAt(i)){
                        return false;
                    }
                }
            }
            return true;
        }
    }



    //use HashMap
    public class Solution {
        public boolean isIsomorphic(String s, String t) {
            if(s == null || t == null){
                return false;
            }
            if(s.length() != t.length()){
                return false;
            }
            HashMap<Character, Character> record = new HashMap<>();
            for(int i = 0; i < s.length(); i++){
                if(record.containsKey(s.charAt(i))){
                    char ch = record.get(s.charAt(i));
                    if(ch != t.charAt(i)){
                        return false;
                    }
                }else{
                    if(record.values().contains(t.charAt(i))){
                        return false;
                    }
                }
                record.put(s.charAt(i), t.charAt(i));
            }
            return true;
        }
    }
}
