import java.util.Stack;

/**
 * Created by yongchizhang on 8/29/17.
 */
public class Stack_RemoveDuplicateLetter {
    class Solution {
        public String removeDuplicateLetters(String s) {
            Stack<Character> stack = new Stack<>();
            int[] map = new int[26];
            boolean[] used = new boolean[26];
            for(int i = 0; i < s.length(); i++){
                map[s.charAt(i) - 'a']++;
            }
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(!used[c - 'a']){
                    while(!stack.isEmpty() && stack.peek() > c && map[stack.peek() - 'a'] > 0){
                        used[stack.peek() - 'a'] = false;
                        stack.pop();
                    }
                    stack.push(c);
                    used[c - 'a'] = true;
                    map[c - 'a']--;
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!stack.isEmpty()){
                sb.insert(0, stack.pop());
            }
            return sb.toString();
        }
    }
}
