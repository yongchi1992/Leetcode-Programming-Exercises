/**
 * Created by yongchizhang on 17/6/16.
 */
public class BinarySearch_TwoArrayMedian {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            if(nums1.length > nums2.length){
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
            }
            if(nums1.length == 0){
                return (nums2.length%2==1)? nums2[nums2.length/2] : 0.5*(nums2[nums2.length/2] + nums2[nums2.length/2 -1]);
            }
            int imin = 0, imax = nums1.length;
            int len = nums1.length + nums2.length;
            while(imin<=imax){
                int i = imin + (imax-imin)/2 ;
                int j = (len + 1)/2 - i;
                if(i==0){
                    if(nums2[j-1]<=nums1[i]){
                        if(len%2==1){
                            return nums2[j-1];
                        }else{
                            if(nums1.length != nums2.length)
                                return (nums2[j-1]+Math.min(nums1[i], nums2[j]))*0.5 ;
                            else
                                return (nums1[i]+nums2[j-1])*0.5;
                        }
                    }else{
                        imin = i+1;
                    }
                }else if(i==nums1.length){
                    if(nums1[i-1]<=nums2[j]){
                        if(len%2==1){
                            return Math.max(nums2[j-1], nums1[i-1]);
                        }else{
                            if(nums1.length != nums2.length)
                                return (nums2[j]+Math.max(nums1[i-1], nums2[j-1]))*0.5 ;
                            else
                                return (nums1[i-1]+nums2[j])*0.5;
                        }
                    }else{
                        imax = i -1;
                    }
                }else{
                    if(nums1[i-1]<= nums2[j] && nums2[j-1]<= nums1[i]){
                        if(len%2==1){
                            return Math.max(nums2[j-1],nums1[i-1]);
                        }else{
                            return (Math.max(nums2[j-1],nums1[i-1])+Math.min(nums1[i], nums2[j]))*0.5 ;
                        }
                    }else if(nums1[i-1]>nums2[j]){
                        imax = i-1;
                    }else if(nums2[j-1]>nums1[i]){
                        imin = i+1;
                    }
                }

            }
            return -1;
        }



        public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
            if(nums1.length > nums2.length){
                int[] tmp = nums1;
                nums1 = nums2;
                nums2 = tmp;
            }
            if(nums1.length == 0){
                return (nums2.length%2==1)? nums2[nums2.length/2] : 0.5*(nums2[nums2.length/2] + nums2[nums2.length/2 -1]);
            }
            int imin = 0, imax = nums1.length;
            int len = nums1.length + nums2.length;
            while(imin<=imax){
                int i = imin + (imax-imin)/2 ;
                int j = (len + 1)/2 - i;
                if( i< nums1.length && nums1[i]<nums2[j-1]){
                    imin = i+1;
                }else if(i>0 && nums1[i-1]>nums2[j]){
                    imax = i-1;
                }else{
                    int max_of_left, min_of_right;
                    if(i==0){
                        max_of_left = nums2[j-1];
                    }else if(j==0){
                        max_of_left = nums1[i-1];
                    }else{
                        max_of_left = Math.max(nums1[i-1],nums2[j-1]);
                    }
                    if(len%2==1)
                        return max_of_left;
                    if(i==nums1.length){
                        min_of_right = nums2[j];
                    }else if(j== nums2.length){
                        min_of_right = nums1[i];
                    }else{
                        min_of_right = Math.min(nums1[i],nums2[j]);
                    }
                    return (max_of_left+min_of_right)*0.5;
                }

            }
            return -1;
        }


    public int kth(int a[],int sa,int lena, int b[],int sb,int lenb,int k){
        if(lena < lenb) return kth(b,sb,lenb,a,sa,lena,k); //将较短的数组放置到后面
        //上一行的代码的理由是，保证 int j = Math.min(lenb,k/2) 是对小数组进行处理
        //如果比进行调换，int j = Math.min(lenb,k/2) 对大的数组进行处理，得出j=k/2 i=k/2 将可能造成数组的越界
        if(lenb == 0) return a[sa+k-1]; //其中一个数组为0 那么k值必定在另一个数组中
        if(k == 1) return Math.min(a[sa],b[sb]); //如果k=1，那么就其中的最小者

        int j = Math.min(lenb,k/2);//保证不会越界
        int i = k-j;

        if(a[sa+i-1]>b[sb+j-1]) return kth(a,sa,i,b,sb+j,lenb-j,k-j);
        else return kth(a,sa+i,lena-i,b,sb,j,k-i);

    }
    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int k = (len1+len2)/2;
        int result1 = kth(nums1,0,len1,nums2,0,len2,k+1);
        if((len1+len2)%2 == 0){
            int result2 = kth(nums1,0,len1,nums2,0,len2,k);
            return((result1+result2)*1.0/2); //这里求的是两个数的均值
        }
        return result1;
    }



    public class Solution {
        public int kth(int[] nums1,int[] nums2,int k){
            int len1 = nums1.length, len2 = nums2.length;
            int start=0, end=(k>=len1)?(len1 -1):(k-1);
            if(len1==0){
                return nums2[k-1];
            }else if(len2==0){
                return nums1[k-1];
            }
            while(start<=end){
                int i = start + (end-start)/2;
                int j1 = k-2-i, j2 = k-1-i;
                if(k-2-i<0){
                    if(nums1[i]<=nums2[0]){
                        return nums1[i];
                    }else{
                        end = i-1;
                        continue;
                    }
                }else if(k-1-i>len2){
                    start = i+1;
                }else if(k-1-i==len2){
                    if(nums1[i]>=nums2[k-2-i]){
                        return nums1[i];
                    }else{
                        start = i+1;
                    }
                }else if(nums1[i]>=nums2[j1] && nums1[i]<=nums2[j2]){
                    return nums1[i];
                }else if(nums1[i]<nums2[j1]){
                    start = i+1;
                }else if(nums1[i]>nums2[j2]){
                    end = i-1;
                }
            }
            if(start<=len1-1 && end>=0){
                return nums2[k-2-end];
            }else if(start==len1){
                return nums2[k-len1-1];
            }else if(end<0){
                return nums2[k-1];
            }
            return 0;
        }
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len1 = nums1.length;
            int len2 = nums2.length;
            int k = (len1+len2)/2;
            int result1 = kth(nums1,nums2,k+1);
            if((len1+len2)%2 == 0){
                int result2 = kth(nums1,nums2,k);
                return((result1+result2)*1.0/2); //这里求的是两个数的均值
            }
            return result1;
        }

    }


}
