import java.util.*;

/**
 * Created by yongchizhang on 17/6/27.
 */
public class QueueTaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] record = new int[26];
        for(char task : tasks){
            record[task - 'A'] ++;
        }
        Arrays.sort(record);
        int i = 25;
        while(record[25]==record[i] && i>0){
            i--;
        }
        return Math.max(tasks.length, (n+1)*(record[25]-1)+25-i );
    }


    public int leastInterval2(char[] tasks, int n) {
        HashMap<Character, Integer> hmp = new HashMap<>();
        for(char t: tasks){
            hmp.put(t, hmp.getOrDefault(t,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>(
                (a,b) -> a.getValue()!=b.getValue() ? b.getValue()-a.getValue() : a.getKey() - b.getKey());
        q.addAll(hmp.entrySet());
        int cnt = 0;
        while(!q.isEmpty()){
            int k = n+1;
            ArrayList<Map.Entry<Character,Integer>> record = new ArrayList<>();
            while(!q.isEmpty() && k>0){
                Map.Entry<Character,Integer> tmp = q.poll();
                tmp.setValue(tmp.getValue()-1);
                record.add(tmp);
                k--;
                cnt ++;
            }

            for(Map.Entry<Character,Integer> ele: record){
                if(ele.getValue()>0){
                    q.add(ele);
                }
            }

            if(!q.isEmpty() && k>0)
                cnt += k;


        }
        return cnt;
    }
}
