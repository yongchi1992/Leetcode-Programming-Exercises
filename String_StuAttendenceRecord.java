/**
 * Created by yongchizhang on 17/7/21.
 */
public class String_StuAttendenceRecord {
    public class Solution {
        public boolean checkRecord(String s) {
            int A = 0, L = 0;
            for(int i = 0; i < s.length(); i++){
                char ch = s.charAt(i);
                if(ch == 'A'){
                    A++;
                    L = 0;
                    if(A > 1){
                        return false;
                    }
                }else if(ch == 'L'){
                    L++;
                    if(L > 2){
                        return false;
                    }
                }else{
                    L = 0;
                }
            }
            return true;
        }
    }
}
