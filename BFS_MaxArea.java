import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yongchizhang on 10/7/17.
 */
public class BFS_MaxArea {
    private static int max = 0;
    public static int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        int m = grid.length, n = grid[0].length;
        boolean[][] visit = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && visit[i][j] == false){
                    bfs(grid, m, n, i, j, queue, visit);
                }
                visit[i][j] = true;
            }
        }
        return max;
    }

    public static void bfs(int[][] grid, int m, int n, int i, int j, Queue<int[]> queue, boolean[][] visit){
        int cnt = 0;
        int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        queue.add(new int[]{i, j});
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            cnt++;
            int curi = cur[0], curj = cur[1];
            visit[curi][curj] = true;
            for(int[] dire: direction){
                int[] next = new int[]{curi + dire[0], curj + dire[1]};
                if(next[0] >= 0 && next[0] < m && next[1] >= 0 && next[1] < n && visit[next[0]][next[1]] == false && grid[next[0]][next[1]] == 1){
                    queue.add(next);
                    visit[next[0]][next[1]] = true;
                }
            }
        }
        max = Math.max(max, cnt);
    }
}
