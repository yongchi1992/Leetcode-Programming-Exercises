/**
 * Created by yongchizhang on 17/8/1.
 */
public class Math_ConvertaNumbertoHexadecimal {
    public class Solution {
        public String toHex(int num) {
            if(num == 0){
                return "0";
            }
            long temp = num > 0 ? num : num & 0xffffffffL;
            StringBuilder sb = new StringBuilder();
            while(temp != 0){
                if(temp % 16 < 10)
                    sb.append(temp % 16);
                else{
                    sb.append((char)('a' + temp % 16 - 10));
                }
                temp /= 16;
            }
            return sb.reverse().toString();
        }
    }
}
