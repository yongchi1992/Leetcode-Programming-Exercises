/**
 * Created by yongchizhang on 17/7/4.
 */
public class String_ReverseVowel {
    public class Solution {
        public String reverseVowels(String s) {
            int start = 0, end = s.length() - 1;
            char[] result = s.toCharArray();
            while(start < end){
                while(start < end && !isVowel(result[start])){
                    start++;
                }
                while(end > start && !isVowel(result[end])){
                    end--;
                }
                if(start >= end){
                    break;
                }
                char temp = result[start];
                result[start] = result[end];
                result[end] = temp;
                start++;
                end--;
            }
            return new String(result);
        }
        public boolean isVowel(char ch){
            if(Character.toLowerCase(ch) == 'a' || Character.toLowerCase(ch) == 'e' || Character.toLowerCase(ch) == 'i' || Character.toLowerCase(ch) == 'o' || Character.toLowerCase(ch) == 'u' ){
                return true;
            }else{
                return false;
            }
        }
    }
}
