/**
 * Created by yongchizhang on 17/8/2.
 */
import java.util.*;
public class Sort_MergeIntervals {


      public class Interval {
          int start;
          int end;
          Interval() { start = 0; end = 0; }
          Interval(int s, int e) { start = s; end = e; }
      }

    public class Solution {
        public List<Interval> merge(List<Interval> intervals) {
            if(intervals == null || intervals.size() == 0){
                return new ArrayList<Interval>();
            }
            Collections.sort(intervals,
                    new Comparator<Interval>(){
                        @Override
                        public int compare(Interval a, Interval b){
                            return a.start - b.start;
                        }
                    });
            List<Interval> result = new ArrayList<>(intervals.size());
            for(int i = 1; i < intervals.size(); i++){
                Interval cur = intervals.get(i);
                Interval prev = intervals.get(i - 1);
                if(cur.start <= prev.end){
                    cur.start = prev.start;
                    cur.end = Math.max(cur.end, prev.end);
                }else{
                    result.add(prev);
                }
            }
            result.add(intervals.get(intervals.size() - 1));
            return result;
        }
    }
}
