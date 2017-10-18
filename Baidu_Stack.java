/**
 * Created by yongchizhang on 10/11/17.
 */
import java.util.*;

public class Baidu_Stack {
    public static class pair{
        int num;
        int pos;
        pair(int num, int pos){
            this.num = num;
            this.pos = pos;
        }
    }

    public static void main(String[] args){
        Stack<pair> stack = new Stack<>();
        int[] arr = new int[]{3, 2, 6, 4, 8, 5, -2};
        int[] res = new int[arr.length];
        for(int i = 0; i < res.length; i++){
            res[i] = -1;
        }
        for(int i = arr.length - 1; i >= 0; i--){
            if(stack.isEmpty() || stack.peek().num <= arr[i]){
                stack.push(new pair(arr[i], i));
            } else {
                while(!stack.isEmpty() && stack.peek().num > arr[i]){
                    pair tmp = stack.pop();
                    res[tmp.pos] = arr[i];
                }
                stack.push(new pair(arr[i], i));
            }
        }

        for(int n: res){
            System.out.print(n + "  ");
        }

    }
}
