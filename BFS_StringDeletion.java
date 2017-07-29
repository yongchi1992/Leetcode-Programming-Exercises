/**
 * Created by yongchizhang on 17/7/15.
 */
import java.util.*;
public class BFS_StringDeletion {
    public int delete(String query, HashSet<String> dict){
        if(query == null || query.length() == 0){
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        Set<String> queueEle = new HashSet<>();
        queue.add(query);
        queueEle.add(query);
        while(!queue.isEmpty()){
            String str = queue.poll();
            if(dict.contains(str)){
                return query.length() - str.length();
            }
            for(int i = 0; i < str.length(); i++){
                String tmp = str.substring(0, i) + str.substring(i+1, str.length());
                if(tmp.length() > 0 && !queueEle.contains(tmp)){
                    queue.add(tmp);
                    queueEle.add(tmp);
                }
            }
        }
        return -1;
    }
}
