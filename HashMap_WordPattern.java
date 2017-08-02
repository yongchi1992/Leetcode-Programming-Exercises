import java.util.HashSet;

/**
 * Created by yongchizhang on 17/8/1.
 */
public class HashMap_WordPattern {

    public class Solution {
        public boolean wordPattern(String pattern, String str) {
            if(pattern == null || str == null || pattern.length() == 0 || str.length() == 0){
                return false;
            }
            String[] s = str.split(" ");
            if(s.length != pattern.length()){
                return false;
            }
            String[] map = new String[128];
            HashSet<String> set = new HashSet<>();
            for(int i = 0; i < s.length; i++){
                char c = pattern.charAt(i);
                if(map[c] == null){
                    if(set.contains(s[i])){
                        return false;
                    }
                    map[c] = s[i];
                    set.add(s[i]);
                }else if(!map[c].equals(s[i])){
                    return false;
                }
            }
            return true;
        }
    }

}
