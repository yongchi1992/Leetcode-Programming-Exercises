/**
 * Created by yongchizhang on 17/7/4.
 */
public class String_CountAndSay {
    public class Solution {
        public String countAndSay(int n) {
            StringBuffer temp = new StringBuffer("1");
            StringBuffer result = new StringBuffer();
            for(int i = 1; i < n; i++){
                int start = 0;
                while(start < temp.length()){
                    int times = 1;
                    int end = start + 1;
                    while(end < temp.length() && temp.charAt(end) == temp.charAt(start)){
                        end ++;
                        times++;
                    }
                    result.append(times);
                    result.append(temp.charAt(start));
                    start = end;
                }
                temp = new StringBuffer(result);
                // 可以写成 temp = result;
                result = new StringBuffer();
            }
            return temp.toString();
        }
    }
}
