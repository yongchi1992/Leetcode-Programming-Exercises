/**
 * Created by yongchizhang on 17/7/21.
 */
public class String_StringMultiply {
    public class Solution {
        public String multiply(String num1, String num2) {
            int m = num1.length(), n = num2.length();
            int[] result = new int[m + n];
            for(int i = m - 1; i >=0; i--){
                for(int j = n - 1; j >=0; j--){
                    int mul = (num1.charAt(i) - '0' ) * (num2.charAt(j) - '0');
                    int sum = mul + result[i + j + 1];
                    result[i + j + 1] = sum % 10;
                    result[i + j] += sum / 10;
                }
            }
            StringBuilder sb = new StringBuilder();
            for(int res: result){
                if(!(sb.length() == 0 && res == 0)){
                    sb.append(res);
                }
            }
            return sb.length() == 0 ? "0" : sb.toString();
        }
    }
}
