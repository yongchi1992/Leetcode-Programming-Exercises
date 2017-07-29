/**
 * Created by yongchizhang on 17/7/5.
 */
public class String_NumberofSegmentsinaString {
    public class Solution {
        public int countSegments(String s) {
            String[] part = s.split(" +");
            if(part.length == 0){
                return 0;
            }else if(part[0].length() == 0){
                return part.length - 1;
            }else{
                return part.length;
            }
        }
    }


    public class Solution2 {
        public int countSegments(String s) {
            int result = 0;
            for(int i = 0; i< s.length(); i++){
                while(i < s.length() && s.charAt(i)==' '){
                    i++;
                }
                if(i < s.length()){
                    result ++;
                }else{
                    break;
                }
                while(i < s.length() && s.charAt(i) != ' '){
                    i++;
                }
            }
            return result;
        }
    }
}
