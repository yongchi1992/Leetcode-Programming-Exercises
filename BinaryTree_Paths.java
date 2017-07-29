/**
 * Created by yongchizhang on 17/7/10.
 */
import java.util.*;

public class BinaryTree_Paths {


    public class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            StringBuffer str = new StringBuffer();
            List<String> result = new LinkedList<>();
            if(root == null){
                return result;
            }
            DFS(root, result, str);
            return result;
        }

        public void DFS(TreeNode root, List<String> result, StringBuffer str){

            str.append(root.val);

            if(root.left != null){
                StringBuffer str2 = new StringBuffer(str);
                str2.append("->");
                TreeNode next = root.left;
                DFS(next, result, str2);
            }

            if(root.right != null){
                StringBuffer str2 = new StringBuffer(str);
                str2.append("->");
                TreeNode next = root.right;
                DFS(next, result, str2);
            }

            if(root.left == null && root.right ==null){
                result.add(str.toString());
            }

        }
    }



    public class Solution2 {
        public List<String> binaryTreePaths(TreeNode root) {
            StringBuffer str = new StringBuffer();
            List<String> result = new LinkedList<>();
            if(root == null){
                return result;
            }
            str.append(root.val);
            DFS(root, result, str);
            return result;
        }

        public void DFS(TreeNode root, List<String> result, StringBuffer str){

            int old_len = str.length();

            if(root.left != null){
                str.append("->");
                str.append(root.left.val);
                TreeNode next = root.left;
                DFS(next, result, str);
                str.delete(old_len, str.length());
            }

            if(root.right != null){
                str.append("->");
                str.append(root.right.val);
                TreeNode next = root.right;
                DFS(next, result, str);
                str.delete(old_len, str.length());
            }

            if(root.left == null && root.right ==null){
                result.add(str.toString());
            }

        }
    }


    public class Solution3{
        public List<String> binaryTreePaths(TreeNode root){
            List<String> paths = new ArrayList<>();
            if(root == null){
                return paths;
            }
            if(root.left == null && root.right == null){
                paths.add(root.val + "");
                return paths;
            }
            List<String> leftPaths = binaryTreePaths(root.left);
            List<String> rightPaths = binaryTreePaths(root.right);

            for(String path: leftPaths){
                paths.add(root.val + "->" + path);
            }
            for(String path: rightPaths){
                paths.add(root.val + "->" + path);
            }
            return paths;
        }
    }
}
