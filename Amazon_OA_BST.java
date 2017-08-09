import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yongchizhang on 17/8/7.
 */
public class Amazon_OA_BST {
    class BTreeNode{
        BTreeNode left;
        BTreeNode right;
        int val;
        BTreeNode(BTreeNode left, int val, BTreeNode right){
            this.left = left;
            this.val = val;
            this.right = right;
        }
    }
    private BTreeNode root;

    public void CreateBST(int[] values){
        for(int i=0;i<values.length;i++){
            int item = values[i];
            if(root==null){
                root=new BTreeNode(null,item,null);
            }else{
                BTreeNode node = root;
                while(node != null){
                    if(item > node.val){
                        if(node.right != null)
                            node = node.right;
                        else {
                            node.right = new BTreeNode(null, item, null);
                            break;
                        }
                    } else {
                        if(node.left != null)
                            node = node.left;
                        else {
                            node.left = new BTreeNode(null, item, null);
                            break;
                        }
                    }
                }

            }
        }
    }


    public  int bstDistance(int node1, int node2){
        BTreeNode lca = findLCA(root, node1, node2);
        int l1 = Pathlength(lca, node1);
        int l2 = Pathlength(lca, node2);
        return l1 + l2;

    }

    public int Pathlength(BTreeNode root, int n) {
        return PathlengthHelp(root,n)-1;
    }

    public int PathlengthHelp(BTreeNode root, int n) {
        if (root != null) {
            int x = 0;
            if ((root.val == n) || (x = PathlengthHelp(root.left, n)) > 0
                    || (x = PathlengthHelp(root.right, n)) > 0) {
                return x+1 ;
            }
            return 0;
        }
        return 0;
    }

    public BTreeNode findLCA(BTreeNode root, int node1, int node2) {
        if (root != null) {
            if (root.val == node1 || root.val == node2) {
                return root;
            }
            BTreeNode left = findLCA(root.left, node1, node2);
            BTreeNode right = findLCA(root.right, node1, node2);

            if (left != null && right != null) {
                return root;
            }
            if (left != null) {
                return left;
            }
            if (right != null) {
                return right;
            }
        }
        return null;
    }


    public static void main(String[] args) {
        Amazon_OA_BST test=new Amazon_OA_BST();
        int values[]={5,6,3,1,2,4};
        test.CreateBST(values);
        int res=test.bstDistance(2, 4);
        System.out.println(res);
        System.out.println(test.bstDistance(2, 6));
        System.out.println(test.bstDistance(2, 5));


        List<int[]> list = new LinkedList<>();
        list.add(new int[]{1,2});
        list.add(new int[]{1,2});
        list.add(new int[]{1,2});
        int[][] nnee = list.toArray(new int[0][0]);
        //int[][] nnee = list.toArray(new int[list.size()][]);
        //  int[][] nnee = list.toArray(new int[0][0]);      两种都可以
        for(int[] elem : nnee){
            System.out.println(Arrays.toString(elem));
        }

    }

}
