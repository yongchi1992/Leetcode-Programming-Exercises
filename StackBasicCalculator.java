import java.util.Stack;

/**
 * Created by yongchizhang on 17/6/25.
 */
public class StackBasicCalculator {
    public int calculate(String s) {
        int idx = s.lastIndexOf("(");
        if(idx!=-1){
            int idx2 = s.indexOf(")", idx+1);
            int result = calculate(s.substring(idx+1,idx2));
            return calculate(s.substring(0,idx)+result+s.substring(idx2+1));
        }
        s=s.replace("--","+");
        idx = s.lastIndexOf("+");
        if(idx!=-1){
            return calculate(s.substring(0,idx))+calculate(s.substring(idx+1));
        }
        idx = s.lastIndexOf("-");
        if(idx!=-1){
            return calculate(s.substring(0,idx))-calculate(s.substring(idx+1));
        }

        return s.replace(" ","").equals("")?0:Integer.parseInt(s.replace(" ",""));

    }


    public int calculate2(String s) {
        int idx = 0;
        int sign = 1;
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        while(idx<s.length()){
            if(Character.isDigit(s.charAt(idx))){
                int num = 0;
                while(idx<s.length() && Character.isDigit(s.charAt(idx))){
                    num = num*10 + s.charAt(idx) - '0';
                    idx++;
                }
                res = res + sign*num;
            }else if(s.charAt(idx)=='+'){
                sign = 1;
                idx++;
            }else if(s.charAt(idx)=='-'){
                sign = -1;
                idx++;
            }else if(s.charAt(idx)=='('){
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
                idx++;
            }else if(s.charAt(idx)==')'){
                res = res*stack.pop() + stack.pop();
                idx++;
            }else{
                idx++;
            }

        }
        return res;

    }
}
