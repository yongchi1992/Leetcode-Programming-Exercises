/**
 * Created by yongchizhang on 17/6/17.
 */
public class BinarySearch_where {

        public int searchInsert(int[] nums, int target) {
            int start = 0, end = nums.length -1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[mid]<target){
                    start = mid + 1;
                }else if(nums[mid]>target){
                    end = mid - 1;
                }else{
                    return mid;
                }
            }
            return start;

        }
    static int binary_search(int[] arr, int x){
        if(arr.length==0){
            return -1;
        }
        int low = 0, high = arr.length -1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(arr[mid]<x){
                low = mid + 1;
            }else if(arr[mid]>x){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    static int binSfirst(int[] arr, int x){
        if(arr.length ==0){
            return -1;
        }
        int low = 0, high = arr.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(arr[mid]<x){
                low = mid + 1;
            }else if(arr[mid]>x){
                high = mid - 1;
            }else{
                high = mid;
            }
        }
        if(arr[high]==x){
            return high;
        }
        return -1;
    }

    static int binSlast(int[] arr, int x){
        if(arr.length == 0){
            return -1;
        }
        int low = 0, high = arr.length - 1;
        while(low+1 < high){
            int mid = low + (high - low)/2 ;
            if(arr[mid]<x){
                low = mid + 1;
            }else if(arr[mid]>x){
                high = mid - 1;
            }else{
                low = mid;
            }
        }
        if(arr[high]== x){
            return high;
        }else if(arr[low]==x){
            return low;
        }
        return -1;
    }
}
