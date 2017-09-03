/**
 * Created by yongchizhang on 9/3/17.
 */
import java.util.*;
public class Math_MaximumSwap {


    //短短三句话就将num转成了array
    public static int maximumSwap(int num) {
        String str = ""+num;
        char[] originalString = str.toCharArray();
        char[] sortedString = str.toCharArray();
        // Sort the digits in reverse order
        Arrays.sort(sortedString);
        sortedString = new StringBuilder(new String(sortedString)).reverse().toString().toCharArray();

        int i; // Find the position of mismatch between the original and sorted string
        for(i = 0; i < str.length(); i++) {
            if(originalString[i] != sortedString[i]) break;
        }

        if(i == str.length()) return num; // if no mismatch, no swap needed, return the original number
        int j = str.lastIndexOf(sortedString[i]); // find the last position of the mismatching digit in the original string

        // Interchange digits in position i and j
        char temp = originalString[i];
        originalString[i] = originalString[j];
        originalString[j] = temp;

        return Integer.parseInt(new String(originalString));
    }





    class Solution {
        public int maximumSwap(int num) {
            int[] record = new int[10];
            PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>(){
                @Override
                public int compare(Integer a, Integer b){
                    return b - a;
                }
            });
            int i = 0;
            int max = 0;
            int num2 = num;
            while(num != 0){
                record[i] = num % 10;
                queue.offer(record[i]);
                num /= 10;
                i++;
            }

            int p = i - 1;
            int tmpMax = 0;

            while(p >= 0){
                tmpMax = queue.poll();
                if(record[p] != tmpMax){
                    break;
                }
                p--;
            }

            if(p < 0){
                return num2;
            }

            int swap = record[p];
            record[p] = tmpMax;

            for(int m = 0; m < i; m++){
                if(record[m] == tmpMax){
                    record[m] = swap;
                    break;
                }
            }

            for(int m = i - 1; m >= 0; m--){
                num = num * 10 + record[m];
            }
            return num;
        }
    }




}
