/**
 * Created by yongchizhang on 9/3/17.
 */
public class BinaryTree_TrimABinaryTree {

    class Solution_best {
        public TreeNode trimBST(TreeNode root, int L, int R) {

            if(root == null)return null;
            if(L <= root.val && root.val <= R){
                root.left = trimBST(root.left, L, R);
                root.right = trimBST(root.right, L, R);
                return root;
            }else if(root.val < L){
                return trimBST(root.right, L, R);
            }else{
                return trimBST(root.left, L, R);
            }
        }
    }

    class Solution {
        public TreeNode trimBST(TreeNode root, int L, int R) {
            if(root == null){
                return root;
            }

            TreeNode left = trimBST(root.left, L, R);
            TreeNode right = trimBST(root.right, L, R);

            if(root.val >= L && root.val <= R){
                root.left = left;
                root.right = right;
                return root;
            } else {
                if(left != null && left.val >= L && left.val <= R){
                    return left;
                } else if (right != null && right.val >= L && right.val <= R){
                    return right;
                } else {
                    return null;
                }
            }



        }
    }







}
