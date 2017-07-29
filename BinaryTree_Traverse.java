/**
 * Created by yongchizhang on 17/7/10.
 */
import java.util.*;
public class BinaryTree_Traverse {
    // version 1: Traverse
    public ArrayList<Integer> preorder(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        traverse(root, result);
        return result;
    }
    public void traverse(TreeNode root, ArrayList<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        traverse(root.left, result);
        traverse(root.right,result);
    }

    //version 2: Divide and Conquer
    public ArrayList<Integer> preorderdivide(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }

        //Divide
        ArrayList<Integer> left = preorderdivide(root.left);
        ArrayList<Integer> right = preorderdivide(root.right);

        //Conquer
        result.add(root.val);
        result.addAll(left);
        result.addAll(right);
        return result;
    }

    //version 3: preorder stack
    public List<Integer> preorderstack(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> preorder = new LinkedList<>();

        if(root == null){
            return preorder;
        }

        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            preorder.add(node.val);
            if(node.right != null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }
        }
        return preorder;
    }

    //version 4: Stack Non Recursion
    public ArrayList<Integer> InorderNonRecusion(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        while(curt != null || !stack.isEmpty()){
            while(curt!= null){
                stack.add(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            result.add(curt.val);
            curt = curt.right;
        }
        return result;
    }

}
