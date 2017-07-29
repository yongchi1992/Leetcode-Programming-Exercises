/**
 * Created by yongchizhang on 17/7/4.
 */
public class LongestCommonPrefix {
    public class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0){
                return "";
            }
            StringBuffer result = new StringBuffer();
            int i = 0;
            boolean breakflag = false;
            while(!breakflag){
                char ch = 0;
                boolean flag = false;
                for(String str : strs){
                    if(str.length() == i){
                        breakflag = true;
                        break;
                    }
                    if(!flag){
                        ch = str.charAt(i);
                        flag = true;
                    }else{
                        if(str.charAt(i)!=ch){
                            breakflag = true;
                            break;
                        }
                    }
                }
                if(!breakflag){
                    result.append(ch);
                    i++;
                }
            }
            return result.toString();
        }
    }

    public class Solution2 {
        public String longestCommonPrefix(String[] strs) {
            if(strs.length == 0){
                return "";
            }
            StringBuffer result = new StringBuffer();
            boolean breakflag = false;
            for(int i = 0; i < strs[0].length() ; i++){
                char ch = strs[0].charAt(i);
                for(int j = 1; j < strs.length; j++){
                    if(strs[j].length() <= i || strs[j].charAt(i) != ch){
                        breakflag = true;
                        break;
                    }
                }
                if(breakflag){
                    break;
                }
                result.append(ch);
            }
            return result.toString();
        }
    }



}
