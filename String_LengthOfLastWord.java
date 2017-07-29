/**
 * Created by yongchizhang on 17/7/4.
 */
public class String_LengthOfLastWord {
    public class Solution {
        public int lengthOfLastWord(String s) {
            String[] part = s.split(" ");
            if(part.length == 0){
                return 0;
            }else if(part[part.length - 1].length() != 0){
                return part[part.length - 1].length();
            }else if(part.length == 1){
                return 0;
            }else{
                return part[part.length - 2].length();
            }
        }
    }


    public int lengthOfLastWord(String s) {
        String[] part = s.split(" ");
        if(part.length == 0){
            return 0;
        }else{
            return part[part.length - 1].length();
        }
    }


    public class Solution2 {
        public int lengthOfLastWord(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }
            int end = s.length() - 1;
            int result = 0;
            while(end >=0 && s.charAt(end) == ' '){
                end--;
            }
            while(end >= 0 && Character.isLetter(s.charAt(end))){
                end--;
                result++;
            }
            return result;
        }
    }
}
