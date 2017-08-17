import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongchizhang on 17/8/16.
 */
public class Math_PermutationSequence {


    public class Solution_my {
        public String getPermutation(int n, int k) {
            ArrayList<Integer> list = new ArrayList<>(n);
            for(int i = 1; i <= n; i++){
                list.add(i);
            }
            StringBuilder sb = new StringBuilder();
            int[] cal = new int[n];
            cal[0] = 1;
            for(int i = 1; i < n; i++){
                cal[i] = cal[i - 1] * i;
            }
            int tmp = k;
            for(int i = n - 1; i >= 1; i--){
                int index = (tmp - 1) / cal[i];
                sb.append(list.get(index));
                list.remove(index);
                tmp -= index * cal[i];
            }
            sb.append(list.get(0));
            return sb.toString();
        }
    }




    public class Solution {
        public String getPermutation(int n, int k) {
            int pos = 0;
            List<Integer> numbers = new ArrayList<>();
            int[] factorial = new int[n + 1];
            StringBuilder sb = new StringBuilder();

            // create an array of factorial lookup
            int sum = 1;
            factorial[0] = 1;
            for (int i = 1; i <= n; i++) {
                sum *= i;
                factorial[i] = sum;
            }
            // factorial[] = {1, 1, 2, 6, 24, ... n!}

            // create a list of numbers to get indices
            for (int i = 1; i <= n; i++) {
                numbers.add(i);
            }
            // numbers = {1, 2, 3, 4}

            k--;

            for (int i = 1; i <= n; i++) {
                int index = k / factorial[n - i];
                sb.append(String.valueOf(numbers.get(index)));
                numbers.remove(index);
                k -= index * factorial[n - i];
            }

            return String.valueOf(sb);
        }

    }
}
