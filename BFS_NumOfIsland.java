/**
 * Created by yongchizhang on 17/8/8.
 */
import java.util.*;
public class BFS_NumOfIsland {
    public class Solution {
        public class Pair{
            int x;
            int y;
            Pair(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        public int numIslands(char[][] grid) {
            if(grid == null || grid.length == 0){
                return 0;
            }
            int m = grid.length, n = grid[0].length;
            int count = 0;
            boolean[][] visited = new boolean[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] == '1' && visited[i][j] == false){
                        bfs(grid, visited, i, j);
                        count++;
                    }
                }
            }
            return count;
        }
        public void bfs(char[][] grid, boolean[][] visited, int i, int j){
            int[] directionX = {0, 0, -1, 1};
            int[] directionY = {1, -1, 0, 0};
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(i, j));
            visited[i][j] = true;
            while(!queue.isEmpty()){
                Pair curr = queue.poll();
                for(int k = 0; k < 4; k++){
                    int x = curr.x + directionX[k];
                    int y = curr.y + directionY[k];
                    if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == '1' && !visited[x][y]){
                        queue.offer(new Pair(x, y));
                        visited[x][y] = true;
                    }
                }
            }
        }
    }
}
