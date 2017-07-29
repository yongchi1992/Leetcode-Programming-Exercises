/**
 * Created by yongchizhang on 17/6/26.
 */
public class DoublePointerTrappingRainWater {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        while(left<height.length-1 && height[left]<=height[left+1]){
            left++;
        }
        while(right>0 && height[right]<=height[right-1]){
            right--;
        }
        if(left>=right){
            return 0;
        }
        int res = 0;
        while(left<right){
            if(height[left]<=height[right]){
                int tmp = left+1;
                while(height[left]>=height[tmp] && tmp<right){
                    res += height[left]-height[tmp];
                    tmp++;
                }
                left = tmp;
            }else if(height[right]<height[left]){
                int tmp = right - 1;
                while(height[right]>=height[tmp] && tmp>left){
                    res+=height[right]-height[tmp];
                    tmp--;
                }
                right = tmp;
            }
        }
        return res;
    }
}
