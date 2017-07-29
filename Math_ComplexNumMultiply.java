/**
 * Created by yongchizhang on 17/7/13.
 */
public class Math_ComplexNumMultiply {
    public class Solution {
        public String complexNumberMultiply(String a, String b) {
            int[] num1 = parse(a);
            int[] num2 = parse(b);
            int n1 = num1[0] * num2[0] - num1[1] * num2[1];
            int n2 = num1[0] * num2[1] + num1[1] * num2[0];
            return n1+"+"+n2+"i";
        }

        public int[] parse(String str){
            int[] num = new int[2];
            num[0] = Integer.valueOf(str.substring(0, str.indexOf("+")));
            num[1] = Integer.valueOf(str.substring(str.indexOf("+") + 1, str.indexOf("i")));
            return num;
        }
    }
}
