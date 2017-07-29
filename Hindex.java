/**
 * Created by yongchizhang on 17/6/21.
 */
public class Hindex {
    public int hIndex(int[] citations) {
        int[] arr = new int[citations.length + 1];
        for(int i=0; i<citations.length; i++){
            if(citations[i]>=citations.length){
                arr[citations.length] ++;
            }else{
                arr[citations[i]]++;
            }
        }
        int res = 0;
        for(int i=citations.length; i>=0; i--){
            if(res + arr[i] < i){
                res += arr[i];
            }else{
                return i;
            }

        }
        return 0;
    }



    public int hIndex_II(int[] citations) {
        if(citations.length == 0)
            return 0;
        int start=1, end=citations.length;
        while(start<=end){
            int i = start + (end - start)/2;
            if(citations[citations.length - i] >= i ){
                start = i+1;
            }else{
                end = i-1;
            }
        }
        return start-1;
    }
}
