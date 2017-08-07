/**
 * Created by yongchizhang on 17/8/7.
 */
import java.util.*;
public class Amazon_OA_FriendAssociation {

    public static void main(String[] args) {

        System.out.println(Arrays.equals(
                new String[] {"friend3", "friend4", "friend5"}
                , new Amazon_OA_FriendAssociation().findLargestFriendCircle(new String[][]{
                        {"friend1", "friend2"},
                        {"friend3", "friend4"},
                        {"friend4", "friend5"},
                })));


        System.out.println(Arrays.equals(
                new String[] {"friend3", "friend4", "friend5"}
                , new Amazon_OA_FriendAssociation().findLargestFriendCircle2(new String[][]{
                        {"friend2", "friend1"},
                        {"friend6", "friend1"},
                        {"friend3", "friend5"},
                        {"friend4", "friend5"},
                })));


        System.out.println(Arrays.equals(
                new String[] {"friend3", "friend4", "friend5"}
                , new Amazon_OA_FriendAssociation().findLargestFriendCircle3(new String[][]{
                        {"friend2", "friend1"},
                        {"friend6", "friend1"},
                        {"friend3", "friend5"},
                        {"friend4", "friend5"},
                })));


        System.out.println(Arrays.equals(
                new String[] {"friend1", "friend2"}
                , new Amazon_OA_FriendAssociation().findLargestFriendCircle(new String[][]{
                        {"friend1", "friend2"},
                        {"friend3", "friend4"},
                })));


    }


    //BFS
    private String[] findLargestFriendCircle3(String[][] arr1) {
        int max = 0, count = 0;
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();     // 用treemap给key排序，先得到的就是字典序最小的
        ArrayList<String> res = new ArrayList<>(), temp = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < arr1.length; i++){
            String key = arr1[i][0], val = arr1[i][1];
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(val);
            if(!map.containsKey(val)){
                map.put(val, new ArrayList<String>());
            }
            map.get(val).add(key);
        }
        HashSet<String> visited = new HashSet<>();
        for(String key : map.keySet()){
            if(!visited.contains(key)){
                queue.add(key);
                while(!queue.isEmpty()){
                    String ele = queue.poll();
                    temp.add(ele);
                    visited.add(ele);
                    for(String v : map.get(ele)){
                        if(!visited.contains(v))
                            queue.add(v);
                    }
                }
                if(temp.size() > max){
                    res = new ArrayList<>(temp);
                    max = temp.size();
                }
                temp.clear();
                count++;
            }
        }
        String[] result = res.toArray(new String[0]);
        Arrays.sort(result);
        System.out.println("Result:" + Arrays.toString(result) + "       Nums: " + count);
        return result;
    }



    //DFS
    private String[] findLargestFriendCircle2(String[][] arr1) {
        int max = 0, count = 0;
        TreeMap<String, ArrayList<String>> map = new TreeMap<>();     // 用treemap给key排序，先得到的就是字典序最小的
        ArrayList<String> res = new ArrayList<>(), temp = new ArrayList<>();
        for(int i = 0; i < arr1.length; i++){
            String key = arr1[i][0], val = arr1[i][1];
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(val);
            if(!map.containsKey(val)){
                map.put(val, new ArrayList<String>());
            }
            map.get(val).add(key);
        }
        HashSet<String> visited = new HashSet<>();
        for(String key : map.keySet()){
            if(!visited.contains(key)){
                visited.add(key);
                dfs(map, visited, key, temp);
                if(temp.size() > max){
                    res = new ArrayList<>(temp);
                    max = temp.size();
                }
                count++;
                temp.clear();
            }
        }
        String[] result = res.toArray(new String[0]);
        Arrays.sort(result);
        System.out.println("Result:" + Arrays.toString(result));
        System.out.println(count);
        return result;
    }

    public void dfs(TreeMap<String, ArrayList<String>> map, HashSet<String> visited, String key, ArrayList<String> temp){
        temp.add(key);
        if(map.containsKey(key)) {
            for (String s : map.get(key)) {
                if (!visited.contains(s)) {
                    visited.add(s);
                    dfs(map, visited, s, temp);
                }
            }
        }
    }




    private String[] findLargestFriendCircle(String[][] arr1) {

        Map<String, String> unionKeys = new HashMap<>();
        for(String []pair:arr1) {
            unionKeys.put(pair[0],pair[0]);
            unionKeys.put(pair[1],pair[1]);
        }


        for(String[] pair: arr1) {
            String unionKey = null, other = null;
            String key0 = unionKeys.get(pair[0]), key1 = unionKeys.get(pair[1]);
            if(key0.compareTo(key1) < 0) {
                unionKey = key0;
                other = pair[1];
            } else {
                unionKey = key1;
                other = pair[0];
            }
            unionKeys.put(other, unionKey);

        }

        Map<String, Integer> counts = new HashMap<>();
        for(Map.Entry<String, String> ent : unionKeys.entrySet()) {
            counts.put(ent.getValue(), counts.getOrDefault(ent.getValue(), 0) + 1);
        }

        int max = -1;
        String maxKey = null;
        for(Map.Entry<String, Integer> ent : counts.entrySet()) {
            if(ent.getValue() > max || (ent.getValue() == max && ent.getKey().compareTo(maxKey) < 0)) {
                max = ent.getValue();
                maxKey = ent.getKey();
            }
        }

        String[] res = new String[max];
        for(Map.Entry<String, String> ent : unionKeys.entrySet()) {
            if(ent.getValue().equals(maxKey)) {
                res[--max] = ent.getKey();
            }
        }

        Arrays.sort(res);
        System.out.println(Arrays.toString(res));

        return res;
    }


}
