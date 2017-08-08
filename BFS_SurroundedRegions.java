import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yongchizhang on 17/8/8.
 */
public class BFS_SurroundedRegions {
    public class Solution {
        public class Pair{
            int x, y;
            Pair(int x, int y){
                this.x = x;
                this.y = y;
            }
        }
        public int m, n;
        public void solve(char[][] board) {
            if(board == null || board.length == 0){
                return;
            }
            int[] directX = {0, 1, 0, -1};
            int[] directY = {1, 0, -1, 0};
            int curr_x = 0, curr_y = 0, i = 0;
            m = board.length;
            n = board[0].length;
            if(m <= 2 || n <= 2){
                return;
            }
            boolean[][] visited = new boolean[m][n];
            do {

                if(board[curr_x][curr_y] == 'O' && visited[curr_x][curr_y] == false){
                    bfs(board, visited, curr_x, curr_y);
                }
                if(!isValid(curr_x + directX[i], curr_y + directY[i])){
                    i++;
                }
                curr_x += directX[i];
                curr_y += directY[i];

            } while(curr_x != 0 || curr_y != 0);
            for(int j = 1; j < m - 1; j++){
                for(int k = 1; k < n - 1; k++){
                    if(board[j][k] == 'O' && !visited[j][k]){
                        board[j][k] = 'X';
                    }
                }
            }
        }


        public void bfs(char[][] grid, boolean[][] visited, int x, int y){
            int[] directX = {0, 1, 0, -1};
            int[] directY = {1, 0, -1, 0};
            Queue<Pair> queue = new LinkedList<>();
            queue.offer(new Pair(x, y));
            while(!queue.isEmpty()){
                Pair curr = queue.poll();
                for(int i = 0; i < 4; i++){
                    int temp_x = curr.x + directX[i];
                    int temp_y = curr.y + directY[i];
                    if(isValid(temp_x, temp_y) && grid[temp_x][temp_y] == 'O' && !visited[temp_x][temp_y]){
                        visited[temp_x][temp_y] = true;
                        queue.offer(new Pair(temp_x, temp_y));
                    }
                }
            }
        }

        public boolean isValid(int x, int y){
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }
}
