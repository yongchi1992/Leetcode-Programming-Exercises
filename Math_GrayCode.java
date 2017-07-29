import java.util.LinkedList;
import java.util.List;

/**
 * Created by yongchizhang on 17/7/6.
 */
public class Math_GrayCode {

    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }
    //The idea is simple. G(i) = i^ (i/2).


}
