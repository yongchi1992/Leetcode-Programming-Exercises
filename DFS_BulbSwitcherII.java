/**
 * Created by yongchizhang on 9/3/17.
 */
import java.util.*;

public class DFS_BulbSwitcherII {


//    for n > 3, result is same as n = 3, if same series of operations apply on 3 bulbs generate k distinct result, apply them on more than 3 bulbs would also generate k distinct result.
//    only even and odd matters for each operation. So the total possible op series would be [0,0,0,0], [0,0,0,1]...to [1,1,1,1], 16 total
//    order of operations doesn't matter




    class Solution {
        public int flipLights(int n, int m) {
            int odd = 0b101;
            int even = 0b010;
            int three = 0b001;
            if (n > 3) n = 3;
            Set<Integer> res = new HashSet<>();
            for (int i = 0; i < 16; ++i) {
                int cnt = 0;

                for (int k = 0; k < 4; ++k) if ((i&(1<<k)) != 0)++cnt;
                if (cnt % 2 != m % 2 || m < cnt) continue;
                int v = (1 << n) - 1;
                int mask = v;
                if ((i & 1) != 0) v = ~v;
                if ((i & 2) != 0) v = (even&~v)|(v&~even);
                if ((i & 4) != 0) v = (odd&~v)|(v&~odd);
                if ((i & 8) != 0) v = (three&~v)|(v&~three);
                res.add(v&mask);
            }
            return res.size();
        }

    }




    class Solution_my {
        public int flipLights(int n, int m) {
            //这两句是重点，因为进行一个动作的时候，不能再进行同样的动作了，否则动作无效
            //简化问题也是很重要的
            n = Math.min(n, 6);
            m = Math.min(m, 6);

            int num = 0;
            boolean[] record = new boolean[n];
            HashMap<String, HashSet<Integer>> map = new HashMap<>();
            helper(record, map, m);
            for(String key : map.keySet()){
                if(map.get(key).contains(0)){
                    num++;
                }
            }
            return num;
        }

        public void helper(boolean[] record, HashMap<String, HashSet<Integer>> map, int m){

            String str = convert(record);
            if(map.containsKey(str) && map.get(str).contains(m)){
                return;
            }
            if(!map.containsKey(str)){
                map.put(str, new HashSet<Integer>());
            }
            map.get(str).add(m);

            if(m == 0){
                return;
            }

            boolean[] fun1 = fun1(record);
            helper(fun1, map, m - 1);
            boolean[] fun2 = fun2(record);
            helper(fun2, map, m - 1);
            boolean[] fun3 = fun3(record);
            helper(fun3, map, m - 1);
            boolean[] fun4 = fun4(record);
            helper(fun4, map, m - 1);

        }

        public String convert(boolean[] arr){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < arr.length; i++){
                if(arr[i]){
                    sb.append(1);
                } else {
                    sb.append(0);
                }
            }
            return sb.toString();
        }

        public boolean[] fun1(boolean[] arr){
            boolean[] arrcp = new boolean[arr.length];
            for(int i = 0; i < arr.length; i++){
                arrcp[i] = !arr[i];
            }
            return arrcp;
        }

        public boolean[] fun2(boolean[] arr){
            boolean[] arrcp = new boolean[arr.length];
            for(int i = 0; i < arr.length; i++){
                if(i % 2 == 0)
                    arrcp[i] = !arr[i];
                else
                    arrcp[i] = arr[i];
            }
            return arrcp;
        }


        public boolean[] fun3(boolean[] arr){
            boolean[] arrcp = new boolean[arr.length];
            for(int i = 0; i < arr.length; i++){
                if(i % 2 == 1)
                    arrcp[i] = !arr[i];
                else
                    arrcp[i] = arr[i];
            }
            return arrcp;
        }


        public boolean[] fun4(boolean[] arr){
            boolean[] arrcp = new boolean[arr.length];
            for(int i = 0; i < arr.length; i++){
                if(i % 3 == 0)
                    arrcp[i] = !arr[i];
                else
                    arrcp[i] = arr[i];
            }
            return arrcp;
        }
    }




    class Solution_best {
        public int flipLights(int n, int m) {
            n = Math.min(n, 20);
            int mask = (1<<n)-1;
            int u = 0;
            for(int t = 0;t < n;t+=3){
                u |= 1<<t;
            }
            Set<Integer> set = new HashSet<>();
            for(int i = 0;i < 1<<4;i++){
                if(Integer.bitCount(i) <= m && Integer.bitCount(i) % 2 == m % 2){
                    int x = 0;
                    if(i<<~0<0){
                        x ^= mask;
                    }
                    if(i<<~1<0){
                        x ^= mask&0x55555555;
                    }
                    if(i<<~2<0){
                        x ^= mask&0xaaaaaaaa;
                    }
                    if(i<<~3<0){
                        x ^= u;
                    }
                    set.add(x);
                }
            }
            return set.size();
        }
    }

}
