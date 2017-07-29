import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by yongchizhang on 17/7/4.
 */
public class RE_KeyboardRow {
    public class Solution {
        public String[] findWords(String[] words) {
            LinkedList<String> result = new LinkedList<>();
            for(String word: words){
                if(judge(word.toUpperCase())){
                    result.add(word);
                }
            }
            return result.toArray(new String[0]);
        }
        public boolean judge(String word){
            return word.matches("[QWERTYUIOP]+|[ASDFGHJKL]+|[ZXCVBNM]+");
        }
    }


    public class Solution2 {
        public String[] findWords(String[] words) {
            String[] strs = {"QWERTYUIOP","ASDFGHJKL", "ZXCVBNM"};
            HashMap<Character, Integer> hmp = new HashMap<>();
            for(int i = 0; i< strs.length; i++){
                for(int j = 0; j< strs[i].length(); j++){
                    hmp.put(strs[i].charAt(j), i);
                }
            }
            LinkedList<String> result = new LinkedList<>();
            for(String w : words){
                String word = w.toUpperCase();
                boolean judge = true;
                int flag = hmp.get(word.charAt(0));
                for(int i = 1; i< word.length(); i++){
                    if(hmp.get(word.charAt(i)) != flag){
                        judge = false;
                    }
                }
                if(judge){
                    result.add(w);
                }
            }
            return result.toArray(new String[0]);
        }

    }
}
