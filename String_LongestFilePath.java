import java.util.Stack;

/**
 * Created by yongchizhang on 17/8/14.
 */
public class String_LongestFilePath {


    public class Solution_best {
        public int lengthLongestPath(String input) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0); // "dummy" length
            int maxLen = 0;
            for(String s:input.split("\n")){
                int lev = s.lastIndexOf("\t")+1; // number of "\t"
                while(lev+1<stack.size()) stack.pop(); // find parent
                int len = stack.peek()+s.length()-lev+1; // remove "/t", add"/"
                stack.push(len);
                // check if it is file
                if(s.contains(".")) maxLen = Math.max(maxLen, len-1);
            }
            return maxLen;
        }
    }



    public class Solution {
        public int lengthLongestPath(String input) {
            Stack<Integer> stack = new Stack<>();
            int longest = 0;
            int idx = 0;
            boolean f2 = false;
            while(idx < input.length() && input.charAt(idx) != '\n'){
                if(input.charAt(idx) == '.'){
                    f2 = true;
                }
                idx++;
            }
            if(f2){
                longest = idx;
            } else {
                stack.push(idx);
            }
            while(idx < input.length()){
                idx++;
                int cnt = 0, space = 0;
                while(idx < input.length() && input.charAt(idx) == '\t'){
                    cnt++;
                    idx++;
                }
                while(idx < input.length() && input.charAt(idx) == ' '){
                    space++;
                    idx++;
                }
                cnt += space / 4;
                int tmp = idx;
                boolean flag = false;
                while(idx < input.length() && input.charAt(idx) != '\n'){
                    if(input.charAt(idx) == '.'){
                        flag = true;
                    }
                    idx++;
                }
                int len = idx - tmp;
                if(cnt > stack.size()){
                    len += (cnt - stack.size()) * 4;
                    cnt = stack.size();
                }

                if(cnt == 0){
                    stack.clear();
                    stack.push(len);
                    continue;
                }
                while(stack.size() != cnt){
                    stack.pop();
                }
                int curr = stack.peek() + len;
                if(flag){
                    longest = Math.max(longest, curr + stack.size());
                    continue;
                }
                stack.push(curr);
            }
            return longest;
        }
    }
}
