/**
 * Created by yongchizhang on 17/7/13.
 */
public class String_addStrings {
    public class Solution {
        public String addStrings(String num1, String num2) {
            int len1 = num1.length() - 1, len2 = num2.length() -1 ;
            StringBuffer result = new StringBuffer();
            int flag = 0;
            while(len1 >=0 || len2 >=0){
                int digit1 = (len1>=0 ? num1.charAt(len1) - '0' : 0);
                int digit2 = (len2>=0 ? num2.charAt(len2) - '0' : 0);
                int digit_sum = digit1 + digit2 + flag;
                if(digit_sum > 9){
                    flag = 1;
                    digit_sum -= 10;
                }else{
                    flag = 0;
                }
                result.append(digit_sum);
                len1--;
                len2--;
            }
            if(flag == 1){
                result.append(flag);
            }
            return result.reverse().toString();
        }
    }
}
