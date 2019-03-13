import java.util.Arrays;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
        left=null;
        right=null;
    }
}
public class BuildTreeFromPreInorder{
    static int index=0;
    public static void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    private static int search(int[] numbers,int key){
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] == key){
                return i;
            }
        }
        return -1;
    }
    public static TreeNode buildTreeHelper(int[] preorder, int[] inorder,int low,int high) {
        if(index < preorder.length && low<=high){
            TreeNode root = new TreeNode(preorder[index++]);
            int mid=search(inorder, root.val);
            root.left=buildTreeHelper(preorder, inorder, low, mid-1);
            root.right=buildTreeHelper(preorder,inorder,mid+1,high);
            return root;
        }
        return null;
     }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
       return buildTreeHelper(preorder, inorder,0,inorder.length-1);
       //return null; 
    }
    public static void main(String[] args) {
        int preorder[]={-1};
        int inorder[]={-1};
        TreeNode root= buildTree(preorder,inorder);
        inorder(root);
    }
}