import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yongchizhang on 17/6/25.
 */
public class StackRemoveKdigits {
    public String removeKdigits(String num, int k) {
        if(k>=num.length())
            return "0";
        StringBuffer str = new StringBuffer(num);
        StringBuffer ans = new StringBuffer();
        int min =0;
        while(k < str.length() && k>0 ){
            int tmp = min;
            for(int i=tmp + 1; i<=tmp + k; i++){
                if(str.charAt(i)<str.charAt(min)){
                    min = i;
                }
            }
            int tmp2 = min;
            for(int i=tmp; i<tmp2;i++){
                str.deleteCharAt(tmp);
                k--;
                min--;
            }
            min ++;
            if(min == str.length() - k){
                while(k>0){
                    str.deleteCharAt(str.length() - 1);
                    k--;
                }
            }

        }
        while(str.charAt(0)=='0' && str.length()>1)
            str.deleteCharAt(0);
        return str.toString();

    }


    public String removeKdigits2(String num, int k) {
        int len = num.length();
        //corner case
        if(k==len)
            return "0";

        Deque<Character> stack = new LinkedList<>();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
            i++;
        }

        // corner case like "1111"
        while(k>0){
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pollLast());

        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }


    public String removeKdigits3(String num, int k) {
        int len = num.length();
        //corner case
        if(k==len)
            return "0";

        Deque<Character> stack = new LinkedList<>();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && !stack.isEmpty() && stack.peek()>num.charAt(i)){
                stack.pop();
                k--;
            }
            if(k==0){
                break;
            }
            stack.push(num.charAt(i));
            i++;
        }

        // corner case like "1111"
        while(k>0){
            stack.pop();
            k--;
        }

        //construct the number from the stack
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pollLast());
        sb.append(num.substring(i));

        //remove all the 0 at the head
        while(sb.length()>1 && sb.charAt(0)=='0')
            sb.deleteCharAt(0);
        return sb.toString();
    }



    public String removeKdigitsfinal(String num, int k) {
        int len = num.length();
        //corner case
        if(k==len)
            return "0";

        Deque<Character> stack = new LinkedList<>();
        StringBuffer ans = new StringBuffer();
        int i =0;
        while(i<num.length()){
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(k>0 && ans.length()>0 && ans.charAt(ans.length()-1)>num.charAt(i)){
                ans.deleteCharAt(ans.length()-1);
                k--;
            }
            if(k==0){
                break;
            }
            ans.append(num.charAt(i));
            i++;
        }

        // corner case like "1111"
        if(k>0){
            ans.delete(ans.length()-k,ans.length());
        }

        ans.append(num.substring(i));

        //remove all the 0 at the head
        while(ans.length()>1 && ans.charAt(0)=='0')
            ans.deleteCharAt(0);
        return ans.toString();
    }
}
