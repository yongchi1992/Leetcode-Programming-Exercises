import java.util.Stack;

/**
 * Created by yongchizhang on 17/6/25.
 */
public class Stack_DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        int idx = 0;

        while(idx<s.length()){
            char ch = s.charAt(idx);
            if(Character.isDigit(ch)){
                int num = ch - '0';
                while(Character.isDigit(s.charAt(++idx))){
                    num = num*10 + s.charAt(idx) - '0';
                }
                stack2.push(num);
            }else if(Character.isLetter(ch)){
                StringBuffer str = new StringBuffer();
                while(idx<s.length() && Character.isLetter(s.charAt(idx))){
                    str.append(s.charAt(idx));
                    idx++;
                }
                if(stack.empty() || stack.peek().equals("["))
                    stack.push(str.toString());
                else{
                    StringBuffer str2 = new StringBuffer(stack.pop());
                    str2.append(str);
                    stack.push(str2.toString());
                }
            }else if(ch == '['){
                StringBuffer str = new StringBuffer(""+ch);
                stack.push(str.toString());
                idx++;
            }else if(ch == ']'){
                int n = stack2.pop();
                String tmp = stack.pop();
                stack.pop();
                StringBuffer str = new StringBuffer();
                for(int i=0; i<n; i++){
                    str.append(tmp);
                }
                if(stack.empty() || stack.peek().equals("[")){
                    stack.push(str.toString());
                }else{
                    StringBuffer str2 = new StringBuffer(stack.pop());
                    str2.append(str);
                    stack.push(str2.toString());
                }
                idx++;
            }
        }
        return stack.empty()?"":stack.pop();
    }
}
