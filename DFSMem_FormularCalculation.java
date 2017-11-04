/**
 * Created by yongchizhang on 11/4/17.
 */
import java.util.*;
public class DFSMem_FormularCalculation {
    private Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {
        if(map.containsKey(input)){
            return map.get(input);
        }
        List<Integer> retlist = new ArrayList<>();
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(!Character.isDigit(c)){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for(int l : left){
                    for(int r : right){
                        if(c == '+'){
                            retlist.add(l + r);
                        } else if(c == '-'){
                            retlist.add(l - r);
                        } else if (c == '*'){
                            retlist.add(l * r);
                        }
                    }
                }
            }
        }
        if(retlist.size() == 0){
            retlist.add(Integer.parseInt(input));
        }
        map.put(input, retlist);
        return retlist;
    }
}
