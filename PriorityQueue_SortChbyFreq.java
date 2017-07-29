/**
 * Created by yongchizhang on 17/7/18.
 */
import java.util.*;

public class PriorityQueue_SortChbyFreq {
    public class Solution {
        public String frequencySort(String s) {
            HashMap<Character, Integer> hmp = new HashMap<>();
            for(int i = 0; i < s.length(); i++){
                hmp.put(s.charAt(i), hmp.getOrDefault(s.charAt(i), 0) + 1);
            }
            LinkedList<Character>[] array = new LinkedList[s.length() + 1];
            for(Character c: hmp.keySet()){
                int count = hmp.get(c);
                if(array[count] == null){
                    array[count] = new LinkedList<Character>();
                }
                array[count].add(c);
            }
            StringBuilder sb = new StringBuilder();
            for(int i = array.length - 1; i>=0; i--){
                if(array[i] != null){
                    for(Character c: array[i]){
                        for(int j = 0; j < i; j++){
                            sb.append(c);
                        }
                    }
                }
            }
            return sb.toString();
        }
    }



    public class Solution2 {
        public String frequencySort(String s) {
            HashMap<Character, Integer> hmp = new HashMap<>();
            for(int i = 0; i < s.length(); i++){
                hmp.put(s.charAt(i), hmp.getOrDefault(s.charAt(i), 0) + 1);
            }
            PriorityQueue<Map.Entry<Character, Integer>> prioque = new PriorityQueue<>(
                    new Comparator<Map.Entry<Character, Integer>>(){
                        @Override
                        public int compare(Map.Entry<Character, Integer> a, Map.Entry<Character, Integer> b){
                            if(b.getValue() != a.getValue())
                                return b.getValue() - a.getValue();
                            else
                                return (int)(a.getKey() - b.getKey());
                        }
                    }
            );


//            PriorityQueue<Map.Entry<Character, Integer>> prioque = new PriorityQueue<>(
//                    (a,b) -> b.getValue() - a.getValue()
//            );


//            PriorityQueue<Map.Entry<Character, Integer>> prioque = new PriorityQueue<>(
//                    (a,b) -> b.getValue() == a.getValue() ? a.getKey() - b.getKey() : b.getValue() - a.getValue()
//            );



            prioque.addAll(hmp.entrySet());
            StringBuilder sb = new StringBuilder();
            while(!prioque.isEmpty()){
                Map.Entry ele = prioque.poll();
                char ch = (char)ele.getKey();
                for(int i = 0; i < (int)ele.getValue(); i++){
                    sb.append(ch);
                }
            }
            return sb.toString();
        }
    }
}
