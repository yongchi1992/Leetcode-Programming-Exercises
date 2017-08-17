/**
 * Created by yongchizhang on 17/8/17.
 */
import java.util.*;
public class HashMap_MaxPointsOnLine {

    class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }




    public class Solution_fraction_donotuseDoubleasKey {

        private int gcd(int a, int b) {
            if ( a==0 ) return b;
            return gcd ( b%a, a );
        }

        public int maxPoints(Point[] points) {
            if(points.length <= 0) return 0;
            if(points.length <= 2) return points.length;
            int result = 0;
            for(int i = 0; i < points.length; i++){
                Map<String, Integer> hm = new HashMap<>();
                int samex = 1;
                int samey = 1;
                int samep = 0;
                for(int j = 0; j < points.length; j++){
                    if(j != i) {
                        if((points[j].x == points[i].x) && (points[j].y == points[i].y))
                            samep++;
                        if(points[j].x == points[i].x){
                            samex++;
                            continue;
                        }
                        if(points[j].y == points[i].y) {
                            samey++;
                            continue;
                        }
                        int numerator = points[j].y - points[i].y;
                        int denaminator = points[j].x - points[i].x;
                        int gcd = gcd(numerator, denaminator);
                        String hashStr = (numerator/gcd) + "_" + (denaminator/gcd);
                        hm.put(hashStr,hm.getOrDefault(hashStr, 1) + 1);
                        result = Math.max(result, hm.get(hashStr) + samep);
                    }
                }
                result = Math.max(result, Math.max(samex, samey));
            }
            return result;
        }
    }






    public class Solution_my {
        public int maxPoints(Point[] points) {
            if(points == null || points.length == 0){
                return 0;
            }
            int max = 1;
            HashMap<Double, Integer> map = new HashMap<>();
            for(int i = 0; i < points.length - 1; i++){
                int same = 0;
                int tmp_max = 1;
                for(int j = i + 1; j < points.length; j++){
                    if(points[i].x == points[j].x && points[i].y == points[j].y){
                        same++;
                    } else{
                        double grad = gradient(points[i], points[j]);
                        map.put(grad, map.getOrDefault(grad, 0) + 1);
                        tmp_max = Math.max(tmp_max, map.get(grad) + 1);
                    }
                }
                tmp_max += same;
                max = Math.max(max, tmp_max);
                map.clear();
            }
            return max;
        }

        public double gradient(Point a, Point b){
            if(a.x == b.x){
                return Double.MAX_VALUE;
            } else if(a.y == b.y){
                return 0;
            }
            return (double)(b.y - a.y) / (double)(b.x - a.x);
        }
    }



    public class Solution {
        public int maxPoints(Point[] points) {
            if(points.length <= 0) return 0;
            if(points.length <= 2) return points.length;
            int result = 0;
            for(int i = 0; i < points.length; i++){
                HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
                int samex = 1;
                int samep = 0;
                for(int j = 0; j < points.length; j++){
                    if(j != i){
                        if((points[j].x == points[i].x) && (points[j].y == points[i].y)){
                            samep++;
                        }
                        if(points[j].x == points[i].x){
                            samex++;
                            continue;
                        }
                        double k = (double)(points[j].y - points[i].y) / (double)(points[j].x - points[i].x);
                        if(hm.containsKey(k)){
                            hm.put(k,hm.get(k) + 1);
                        }else{
                            hm.put(k, 2);
                        }
                        result = Math.max(result, hm.get(k) + samep);
                    }
                }
                result = Math.max(result, samex);
            }
            return result;
        }
    }

}
