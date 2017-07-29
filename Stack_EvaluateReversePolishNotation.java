import java.util.Stack;

/**
 * Created by yongchizhang on 17/6/24.
 */
public class Stack_EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens){
            if(token.equals("+")){
                stack.push(stack.pop()+stack.pop());
            }else if(token.equals("-")){
                stack.push(-stack.pop()+stack.pop());
            }else if(token.equals("*")){
                stack.push(stack.pop()*stack.pop());
            }else if(token.equals("/")){
                int a = stack.pop();
                stack.push(stack.pop()/a);
            }else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
