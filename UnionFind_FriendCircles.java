import java.util.*;

/**
 * Created by yongchizhang on 17/8/7.
 */
public class UnionFind_FriendCircles {



    public class Solution_dfs {
        public void dfs(int[][] M, int[] visited, int i) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && visited[j] == 0) {
                    visited[j] = 1;
                    dfs(M, visited, j);
                }
            }
        }
        public int findCircleNum(int[][] M) {
            int[] visited = new int[M.length];
            int count = 0;
            for (int i = 0; i < M.length; i++) {
                if (visited[i] == 0) {
                    visited[i] = 1;
                    dfs(M, visited, i);
                    count++;
                }
            }
            return count;
        }
    }


    //BFS
    public class Solution_bfs {
        public int findCircleNum(int[][] M) {
            int n = M.length, count = 0;
            boolean[] visited = new boolean[n];
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    queue.add(i);
                    while(!queue.isEmpty()){
                        int ele = queue.poll();
                        visited[ele] = true;
                        for(int j = 0; j < n; j++){
                            if(visited[j] == false && M[ele][j] == 1){
                                queue.add(j);
                            }
                        }
                    }
                    count++;
                }
            }
            return count;
        }
    }



    public class Solution {
        public class UnionFind{
            int[] parent;
            int[] rank;
            int count = 0;
            UnionFind(int n){
                count = n;
                rank = new int[n];
                parent = new int[n];
                for(int i = 0; i < n; i++){
                    parent[i] = i;
                }
            }
            public int root(int x){
                while(parent[x] != x){
                    parent[x] = parent[parent[x]];
                    x = parent[x];
                }
                return x;
            }
            public void union(int x, int y){
                int root_x = root(x), root_y = root(y);
                if(root_x == root_y){
                    return;
                }else if(rank[root_x] > rank[root_y]){
                    parent[root_y] = root_x;
                }else{
                    parent[root_x] = root_y;
                    if(rank[root_x] == rank[root_y]){
                        rank[root_y]++;
                    }
                }
                count--;
            }
        }
        public int findCircleNum(int[][] M) {
            int n = M.length;
            UnionFind res = new UnionFind(n);
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(i != j && M[i][j] == 1){
                        res.union(i, j);
                    }
                }
            }
            return res.count;
        }
    }






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


}
