import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yongchizhang on 17/6/25.
 */
public class DequeSimplifyPath {
    public String simplifyPath(String path) {
        Deque<String> deque = new LinkedList<>();
        String[] str = path.split("/");
        for(String s:str){
            if(s.equals("")){
                continue;
            }else if(s.equals(".")){
                continue;
            }else if(s.equals("..")){
                if(!deque.isEmpty())
                    deque.removeLast();
            }else{
                deque.addLast(s);
            }
        }
        StringBuffer ans = new StringBuffer();
        while(!deque.isEmpty()){
            ans.append("/");
            ans.append(deque.pollFirst());
        }
        return (ans.length()==0)?"/":ans.toString();
    }
}
