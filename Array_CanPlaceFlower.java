/**
 * Created by yongchizhang on 17/7/26.
 */
public class Array_CanPlaceFlower {
    public class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            if(n <= 0){
                return true;
            }
            int count = 0;
            for(int i = 0; i < flowerbed.length; i++){
                int left = i - 1 < 0 ? 0 : flowerbed[i - 1];
                int right = i + 1 >= flowerbed.length ? 0 : flowerbed[i + 1];
                if(left == 0 && right == 0 && flowerbed[i] == 0){
                    flowerbed[i] = 1;
                    count++;
                    if(count >= n){
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
