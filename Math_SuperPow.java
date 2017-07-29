import java.util.ArrayList;

/**
 * Created by yongchizhang on 17/7/26.
 */
public class Math_SuperPow {
    public class Solution {
        int DIV = 1337;
        public int superPow(int a, int[] b) {
            if (a==0 || a==DIV || b==null || b.length == 0) return 0;
            if (a==1) return 1;

            a = a % DIV;
            ArrayList<Integer> record = getRemainderList(a);
            int m = record.size();
            int index = 0;
            for(int i = 0; i < b.length; i++){
                index = (index * 10 + b[i]) % m;
            }
            index = index == 0 ? m - 1 : index - 1;
            return record.get(index);
        }
        public ArrayList<Integer> getRemainderList(int a){
            ArrayList<Integer> result = new ArrayList<>();
            boolean[] happen = new boolean[DIV];
            int temp = a;
            while (!happen[temp]){
                happen[temp] = true;
                result.add(temp);
                temp = (temp * a) % DIV;
            }
            return result;
        }
    }
}
