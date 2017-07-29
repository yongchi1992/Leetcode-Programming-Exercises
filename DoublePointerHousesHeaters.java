import java.util.Arrays;
import java.util.TreeSet;

/**
 * Created by yongchizhang on 17/6/18.
 */
public class DoublePointerHousesHeaters {
    public int getMax(int[] arr){
        int max=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        return max;
    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int[] res = new int[houses.length];
        int j = 0;
        for(int i=0;i<houses.length;i++){
            int tmp = Math.abs(houses[i]-heaters[j]);
            while(j+1<heaters.length){
                int tmp2 = Math.abs(houses[i]-heaters[j+1]);
                if(tmp<tmp2)
                    break;
                else{
                    tmp = tmp2;
                    j++;
                }
            }
            res[i] = tmp;
        }

        return getMax(res);
    }


    public int findRadius2(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int maxres=0;
        int j = 0;
        for(int i=0;i<houses.length;i++){
            int tmp = Math.abs(houses[i]-heaters[j]);
            while(j+1<heaters.length){
                int tmp2 = Math.abs(houses[i]-heaters[j+1]);
                if(tmp<tmp2)
                    break;
                else{
                    tmp = tmp2;
                    j++;
                }
            }
            if(tmp>maxres)
                maxres = tmp;
        }

        return maxres;
    }

    public int findRadius3(int[] houses, int[] heaters) {
        TreeSet<Integer> treeset = new TreeSet<>();
        for (int heater : heaters) treeset.add(heater);
        int res = 0;
        for (int house : houses) {
            Integer upper = treeset.ceiling(house);
            Integer lower = treeset.floor(house);
            res = Math.max(res, Math.min(upper == null ? Integer.MAX_VALUE : upper - house, lower == null ? Integer.MAX_VALUE : house - lower));
        }
        return res;
    }
}
