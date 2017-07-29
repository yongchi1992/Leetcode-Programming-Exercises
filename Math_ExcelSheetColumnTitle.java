/**
 * Created by yongchizhang on 17/7/25.
 */
public class Math_ExcelSheetColumnTitle {
    public class Solution {
        public String convertToTitle(int n) {
            StringBuilder result = new StringBuilder();
            while(n > 0){
                char ch = (char) ((n - 1) % 26 + 'A');
                result.append(ch);
                if(n % 26 == 0){
                    n /= 26;
                    n--;
                }else{
                    n /= 26;
                }
            }
            return result.reverse().toString();
        }
    }



    public class Solution2 {
        public String convertToTitle(int n) {
            StringBuilder result = new StringBuilder();

            while(n>0){
                n--;
                result.insert(0, (char)('A' + n % 26));
                n /= 26;
            }

            return result.toString();
        }
    }

}
