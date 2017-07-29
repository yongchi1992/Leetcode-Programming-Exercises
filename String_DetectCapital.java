/**
 * Created by yongchizhang on 17/7/3.
 */
public class String_DetectCapital {
    public class Solution {
        public boolean detectCapitalUse(String word) {
            if(word == null || word.length() == 0){
                return false;
            }
            if(word.length() == 1){
                return true;
            }
            boolean flag = (Character.isUpperCase(word.charAt(0))) ? true : false;
            boolean flag2 = (Character.isUpperCase(word.charAt(1))) ? true : false;
            if(flag == false && flag2 == true){
                return false;
            }
            for(int i = 2; i < word.length(); i++){
                if(flag == false && Character.isUpperCase(word.charAt(i))){
                    return false;
                }
                if(flag == true && flag2 == false && Character.isUpperCase(word.charAt(i))){
                    return false;
                }
                if(flag == true && flag2 == true && Character.isLowerCase(word.charAt(i))){
                    return false;
                }
            }
            return true;
        }
    }


    public boolean detectCapitalUse(String word) {
        return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
    }

}
