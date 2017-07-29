import java.util.HashMap;

/**
 * Created by yongchizhang on 17/6/20.
 */
public class FourSum {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer,Integer> hmp = new HashMap<>();
        for(int i =0; i<A.length; i++){
            for(int j = 0; j<B.length; j++){
                hmp.put(A[i]+B[j], hmp.getOrDefault(A[i]+B[j],0)+1);
            }
        }

        int res = 0;
        for(int i=0; i<C.length; i++){
            for(int j=0; j<D.length; j++){
                int sum = C[i]+D[j];
                if(hmp.containsKey(-sum)){
                    res += hmp.get(-sum);
                }
            }
        }
        return res;
    }
}
