/**
 * Created by yongchizhang on 17/7/27.
 */
public class BinaryTree_ConvertSortedArrayToBalancedBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            return helper(nums, 0, nums.length - 1);
        }
        public TreeNode helper(int[] nums, int start, int end){
            if(end < start){
                return null;
            }else if(end == start){
                return new TreeNode(nums[start]);
            }
            int mid = start + (end - start) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = helper(nums, start, mid - 1);
            root.right = helper(nums, mid + 1, end);
            return root;
        }
    }
}
