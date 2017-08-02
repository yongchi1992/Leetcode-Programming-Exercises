/**
 * Created by yongchizhang on 17/8/2.
 */
public class Array_SortColors {

    //A rather straight forward solution is a two-pass algorithm using counting sort.
    //First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

    //Could you come up with an one-pass algorithm using only constant space?



    // one pass in place solution
    void sortColors1(int A[], int n) {
        int n0 = -1, n1 = -1, n2 = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] == 0)
            {
                A[++n2] = 2; A[++n1] = 1; A[++n0] = 0;
            }
            else if (A[i] == 1)
            {
                A[++n2] = 2; A[++n1] = 1;
            }
            else if (A[i] == 2)
            {
                A[++n2] = 2;
            }
        }
    }

    // one pass in place solution
    void sortColors2(int A[], int n) {
        int j = 0, k = n - 1;
        for (int i = 0; i <= k; ++i){
            if (A[i] == 0 && i != j)
                swap(A[i--], A[j++]);
            else if (A[i] == 2 && i != k)
                swap(A[i--], A[k--]);
        }
    }

    // one pass in place solution
    void sortColors(int A[], int n) {
        int j = 0, k = n-1;
        for (int i=0; i <= k; i++) {
            if (A[i] == 0)
                swap(A[i], A[j++]);
            else if (A[i] == 2)
                swap(A[i--], A[k--]);
        }
    }


    void swap(int i, int j){

    }



    // Go through once and O(1) Space
    public class Solution {
        public void sortColors(int[] nums) {
            int[] pointer = new int[3];
            for(int i = 0; i < 3; i++)
                pointer[i] = Integer.MAX_VALUE;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == 0){
                    if(i > pointer[1]){
                        if(i > pointer[2]){
                            swap(nums, i, pointer[1]);
                            swap(nums, i, pointer[2]);
                            pointer[1]++;
                            pointer[2]++;
                        }else{
                            swap(nums, i, pointer[1]);
                            pointer[1]++;
                        }
                    } else if(i > pointer[2]){
                        swap(nums, i, pointer[2]);
                        pointer[2]++;
                    }
                } else if(nums[i] == 1){

                    if(i > pointer[2]){
                        swap(nums, i, pointer[2]);
                        if(pointer[1] == Integer.MAX_VALUE){
                            pointer[1] = pointer[2];
                        }
                        pointer[2]++;
                    }else{
                        if(pointer[1] == Integer.MAX_VALUE){
                            pointer[1] = i;
                        }
                    }
                } else if(nums[i] == 2){
                    if(pointer[2] == Integer.MAX_VALUE){
                        pointer[2] = i;
                    }
                }

            }
        }
        public void swap(int[] nums, int i, int j){
            if(i != j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }


}
