/**
 * Created by yongchizhang on 17/7/19.
 */
public class Math_ExcelSheetNum {
    public class Solution {
        public int titleToNumber(String s) {
            int result = 0;
            for(int i = 0; i < s.length(); i++){
                result = result * 26 + s.charAt(i) - 'A' + 1;
            }
            return result;
        }
    }
}
