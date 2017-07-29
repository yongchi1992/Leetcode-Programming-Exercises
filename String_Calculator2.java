import java.util.Stack;

/**
 * Created by yongchizhang on 17/7/28.
 */
public class String_Calculator2 {

    // Calculator 都要用stack，push的是数字不是符号
    public class Solution_best {
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<>();
            char sign = '+';
            int num = 0;
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(Character.isDigit(ch)){
                    num = num * 10 + ch - '0';
                }
                if(( !Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                    if(sign == '+'){
                        stack.push(num);
                    }else if(sign == '-'){
                        stack.push(-num);
                    }else if(sign == '*'){
                        stack.push(num * stack.pop());
                    }else if(sign == '/'){
                        stack.push(stack.pop() / num);
                    }
                    sign = ch;
                    num = 0;
                }
            }
            int result = 0;
            for(int i : stack){
                result += i;
            }
            return result;
        }
    }



    // 超过内存限制
    public class Solution {
        public int calculate(String s) {
            String str = s.replaceAll(" ","");
            return helper(str);
        }
        public int helper(String str){
            int index = str.lastIndexOf("+");
            int start = 0, end = str.length();
            if(index != -1){
                return helper(str.substring(start, index)) + helper(str.substring(index + 1, end));
            }
            index = str.lastIndexOf("-");
            if(index != -1){
                return helper(str.substring(start, index)) - helper(str.substring(index + 1, end));
            }
            for(int i = end - 1; i >= start; i--){
                if(str.charAt(i) == '*'){
                    return helper(str.substring(start, i)) * helper(str.substring(i + 1, end));
                }
                if(str.charAt(i) == '/'){
                    return helper(str.substring(start, i)) / helper(str.substring(i + 1, end));
                }
            }
            return Integer.parseInt(str);
        }
    }
}
