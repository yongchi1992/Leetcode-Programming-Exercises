import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yongchizhang on 10/8/17.
 */
public class BFS_stickerstoSpellWorld {
    class Solution {
        public int minStickers(String[] stickers, String target) {
            if(stickers == null || stickers.length == 0 || target == null || target.length() == 0){
                return 0;
            }
            Queue<String> queue = new LinkedList<>();
            HashSet<String> set = new HashSet<>();
            queue.add(target);
            set.add(target);
            int[][] sti = new int[stickers.length][26];
            for(int i = 0; i < stickers.length; i++){
                for(int j = 0; j < stickers[i].length(); j++){
                    char c = stickers[i].charAt(j);
                    sti[i][c - 'a']++;
                }
            }
            int cnt = 0;
            while(!queue.isEmpty()){
                int size = queue.size();
                cnt++;
                for(int m = 0; m < size; m++){
                    String tmp = queue.poll();
                    int[] tmpMap = map(tmp);

                    for(int i = 0; i < stickers.length; i++){
                        StringBuilder sb = new StringBuilder();
                        for(int j = 0; j < 26; j++){
                            if(tmpMap[j] != 0){
                                for(int k = 0; k < tmpMap[j] - sti[i][j]; k++){
                                    sb.append((char)('a' + j));
                                }
                            }
                        }
                        String str = sb.toString();
                        if(str.length() == 0){
                            return cnt;
                        }
                        if(sb.length() < tmp.length() && !set.contains(str)){
                            queue.add(str);
                            set.add(str);
                        }
                    }
                }

            }
            return -1;
        }


        public int[] map(String target){
            int[] tar = new int[26];
            for(int i = 0; i < target.length(); i++){
                char c = target.charAt(i);
                tar[c - 'a']++;
            }
            return tar;
        }
    }
}
