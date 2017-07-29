/**
 * Created by yongchizhang on 17/7/14.
 */
public class String_SolveEquation {
    public String solveEquation(String equation) {
        int[] res = evaluateExpression(equation.split("=")[0]),
                res2 = evaluateExpression(equation.split("=")[1]);
        res[0] -= res2[0];
        res[1] = res2[1] - res[1];
        if (res[0] == 0 && res[1] == 0) return "Infinite solutions";
        if (res[0] == 0) return "No solution";
        return "x=" + res[1]/res[0];
    }

    public int[] evaluateExpression(String exp) {
        String[] tokens = exp.split("(?=[-+])");
        int[] res =  new int[2];
        for (String token : tokens) {
            if (token.equals("+x") || token.equals("x")) res[0] += 1;
            else if (token.equals("-x")) res[0] -= 1;
            else if (token.contains("x")) res[0] += Integer.parseInt(token.substring(0, token.indexOf("x")));
            else res[1] += Integer.parseInt(token);
        }
        return res;
    }



    public class Solution {
        public String solveEquation(String equation) {
            int index = equation.indexOf("=");
            int[] coef_left = parse(equation, 0, index - 1);
            int[] coef_right = parse(equation, index + 1, equation.length() - 1);
            int coef_x = coef_left[0] - coef_right[0];
            int coef_n = coef_left[1] - coef_right[1];
            if(coef_x == 0 && coef_n == 0){
                return "Infinite solutions";
            }else if(coef_x == 0){
                return "No solution";
            }else{
                return "x="+(-coef_n/coef_x);
            }
        }
        public int[] parse(String str, int start, int end){
            int[] res = new int[2];
            for(int i = end; i >= start; i--){
                char ch = str.charAt(i);
                if(ch == 'x'){
                    if(i == start){
                        res[0]++;
                    }else if(str.charAt(i - 1) == '+'){
                        res[0]++;
                        i--;
                    }else if(str.charAt(i - 1) == '-'){
                        res[0]--;
                        i--;
                    }else{
                        int tmp = i;
                        while(i >= start && str.charAt(i) != '+' && str.charAt(i) != '-' ){
                            i--;
                        }
                        i = (i < start ? start: i);
                        res[0] += Integer.parseInt(str.substring(i, tmp));
                    }
                }else{
                    int tmp = i + 1;
                    while(i >= start && str.charAt(i) != '+' && str.charAt(i) != '-' ){
                        i--;
                    }
                    i = (i < start ? start: i);
                    res[1] += Integer.parseInt(str.substring(i, tmp));
                }
            }
            return res;
        }
    }

}
