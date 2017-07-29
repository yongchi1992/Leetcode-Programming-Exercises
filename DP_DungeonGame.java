/**
 * Created by yongchizhang on 17/6/23.
 */
public class DP_DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] res = new int[n][m];



        for(int i=n-1, j=m-1; i>=0; i--){
            if(i==n-1)
                res[i][j] = (dungeon[i][j]<0)?(1-dungeon[i][j]):1;
            else
                res[i][j] = (dungeon[i][j]>=res[i+1][j]? 1: res[i+1][j] - dungeon[i][j] );
        }
        if(m>1){
            for(int i=n-1, j=m-2; j>=0; j--){
                res[i][j] = dungeon[i][j]<=0?res[i][j+1] - dungeon[i][j] : dungeon[i][j]>=res[i][j+1]?1: res[i][j+1] - dungeon[i][j] ;
            }
        }
        if(n>1 && m>1){
            for(int i=n-2; i>=0; i--){
                for(int j=m-2; j>=0; j--){
                    if(res[i+1][j]>=res[i][j+1]){
                        res[i][j] = dungeon[i][j]>=res[i][j+1]?1: res[i][j+1] - dungeon[i][j];
                    }else{
                        res[i][j] = dungeon[i][j]>=res[i+1][j]?1: res[i+1][j] - dungeon[i][j];
                    }
                }
            }
        }
        return res[0][0];
    }


    public int calculateMinimumHP2(int[][] dungeon) {
        int n = dungeon.length;
        int m = dungeon[0].length;
        int[][] res = new int[n+1][m+1];

        for(int i = n, j=0; j<m; j++)
            res[i][j] = Integer.MAX_VALUE;
        for(int i=0, j=m; i<n; i++)
            res[i][j] = Integer.MAX_VALUE;
        res[n][m-1]=1;
        res[n-1][m]=1;


        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                if(res[i+1][j]>=res[i][j+1]){
                    res[i][j] = dungeon[i][j]>=res[i][j+1]?1: res[i][j+1] - dungeon[i][j];
                }else{
                    res[i][j] = dungeon[i][j]>=res[i+1][j]?1: res[i+1][j] - dungeon[i][j];
                }
            }
        }

        return res[0][0];
    }
}
