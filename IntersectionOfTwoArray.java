/**
 * Created by yongchizhang on 17/6/17.
 */
import java.util.*;
public class IntersectionOfTwoArray {

    //假如是sort过的array, 用双指针
    public class Solution {

        public int[] intersection_Set(int[] nums1, int[] nums2) {
            HashMap<Integer,Integer> hmp = new HashMap<>();
            HashSet<Integer> res = new HashSet<>();
            for(int ele: nums1){
                hmp.put(ele,1);
            }
            for(int ele: nums2){
                if(hmp.containsKey(ele)){
                    res.add(ele);
                }
            }
            int[] arr = new int[res.size()];
            int i=0;
            for(Iterator iter = res.iterator(); iter.hasNext();){
                arr[i] = (int)iter.next();
                i++;
            }
            return arr;
        }


        public int[] intersection(int[] nums1, int[] nums2) {
            HashMap<Integer,Integer> hmp = new HashMap<>();
            LinkedList<Integer> res = new LinkedList<Integer>();
            for(int ele: nums1){
                hmp.put(ele,1);
            }
            for(int ele: nums2){
                if(hmp.containsKey(ele)){
                    hmp.remove(ele);
                    res.add(ele);
                }
            }
            int[] arr = new int[res.size()];
            int i=0;
            for(Iterator iter = res.iterator(); iter.hasNext();){
                arr[i] = (int)iter.next();
                i++;
            }
            return arr;
        }


        public int[] intersect(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int p1 = 0;
            int p2 = 0;
            List <Integer> s = new ArrayList<>();
            while(p1 < nums1.length && p2 < nums2.length){
                if (nums1[p1] == nums2[p2]){
                    s.add(nums1[p1]);
                    p1 ++;
                    p2 ++;
                }


                else if (nums1[p1] < nums2[p2])
                    p1 ++;
                else
                    p2 ++;
            }
            int [] r = new int[s.size()];
            for (int i =0; i < s.size(); i++){
                r[i] = s.get(i);
            }
            return r;
        }
    }

    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1.length ==0 || nums2.length == 0){
            int[] arr = new int[0];
            return arr;
        }
        HashMap<Integer, Integer> hmp = new HashMap<Integer, Integer>();
        for(int ele: nums1){
            if(hmp.containsKey(ele)){
                hmp.put(ele,hmp.get(ele)+1);
            }else{
                hmp.put(ele,1);
            }
        }
        LinkedList<Integer> ll = new LinkedList<Integer>();
        for(int i=0;i<nums2.length;i++){
            int ele = nums2[i];
            if(hmp.containsKey(ele) && hmp.get(ele)>0){
                hmp.put(ele,hmp.get(ele)-1);
                ll.add(ele);
            }
        }
        int[] arr=new int[ll.size()];
        int j=0;
        for(int ele:ll){
            arr[j]=ele;
            j++;
        }
        return arr;
    }

    //If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.


    //If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a time in memory, record intersections.


}
