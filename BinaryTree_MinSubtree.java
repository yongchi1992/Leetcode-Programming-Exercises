import apple.laf.JRSUIUtils;

/**
 * Created by yongchizhang on 17/7/10.
 */
public class BinaryTree_MinSubtree {
    public int min = Integer.MIN_VALUE;
    public TreeNode subtree = null;
    public TreeNode MinSubtree(TreeNode root){
        helper(root);
        return subtree;
    }
    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int sum = root.val + helper(root.left) + helper(root.right);
        if(sum < min){
            min = sum;
            subtree = root;
        }
        return sum;
    }
}
