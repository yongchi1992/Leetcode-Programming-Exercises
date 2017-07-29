/**
 * Created by yongchizhang on 17/7/4.
 */
public class String_AddBinary {
    public class Solution {
        public String addBinary(String a, String b) {
            int indexa = a.length() - 1, indexb = b.length() - 1;
            StringBuffer result = new StringBuffer();
            int flag = 0;
            while(indexa >=0 || indexb >= 0){
                int na = (indexa < 0)? 0 : a.charAt(indexa)-'0';
                int nb = (indexb < 0)? 0 : b.charAt(indexb)-'0';
                int tmp = na + nb + flag;
                if(tmp <= 1){
                    result.append(tmp);
                    flag = 0;
                }else{
                    result.append(tmp - 2);
                    flag = 1;
                }
                indexa--;
                indexb--;
            }
            if(flag == 1){
                result.append(1);
            }
            return result.reverse().toString();
        }
    }
}
