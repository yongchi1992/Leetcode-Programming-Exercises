import java.util.HashMap;
import java.util.Stack;

/**
 * Created by yongchizhang on 17/6/23.
 */
public class Stack1 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character,Character> hmp = new HashMap<>();
        hmp.put('(',')');
        hmp.put('[',']');
        hmp.put('{','}');
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                stack.push(s.charAt(i));
            }else{
                if(stack.empty())
                    return false;
                char ele = stack.pop();
                if(hmp.get(ele)!=s.charAt(i)){
                    return false;
                }
            }
        }
        if(!stack.empty()){
            return false;
        }else{
            return true;
        }
    }
}
