import java.util.*;

/**
 * Created by yongchizhang on 17/6/18.
 */
public class FindRightInterval {
    public class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
    }

    public int[] findRightInterval(Interval[] intervals) {
        int[] ans = new int[intervals.length];
        HashMap<Integer,Integer> hmp = new HashMap<>();
        TreeSet<Integer> tset = new TreeSet<>();
        for(int i=0; i<intervals.length; i++){
            hmp.put(intervals[i].start,i);
            tset.add(intervals[i].start);
        }
        for(int i=0; i<intervals.length; i++){
            Integer r = tset.ceiling(intervals[i].end);
            if(r!=null)
                ans[i] = hmp.get(r);
            else{
                ans[i]=-1;
            }
        }
        return ans;
    }



    public int[] findRightInterval2(Interval[] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] res = new int[intervals.length];
        for(int i=0;i<intervals.length;i++) map.put(intervals[i].start, i);
        for(int i=0;i<intervals.length;i++) {
            Integer key = map.ceilingKey(intervals[i].end);
            res[i] = key!=null ?map.get(key) : -1;
        }
        return res;
    }


    class nodes{
        int start;
        int idx;
        nodes(int _st, int _idx){
            start = _st;
            idx = _idx;
        }
    }
    public int[] findRightInterval_my(Interval[] intervals) {
        nodes[] arr = new nodes[intervals.length];
        int[] ans = new int[intervals.length];
        for(int i=0; i<intervals.length;i++){
            arr[i] = new nodes(intervals[i].start, i);
        }
        Arrays.sort(arr, new Comparator<nodes>(){
            public int compare(nodes A, nodes B){
                return A.start - B.start;
            }
        });
        for(int i=0; i<intervals.length; i++){
            int low = 0, high = intervals.length - 1;
            while(low<=high){
                int mid = low + (high - low)/2;
                if(intervals[i].end > arr[mid].start){
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
            if(low==intervals.length || high == -1)
                ans[i]=-1;
            else
                ans[i]=arr[low].idx;
        }
        return ans;
    }
}
