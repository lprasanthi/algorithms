
class TreeNode{
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class BSTFromSorted{
    public static void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static TreeNode createBSTHelper(int start,int end,int[] arr){
        if(start>=end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root= new TreeNode(arr[mid]);
        root.left=createBSTHelper(start,mid,arr);
        root.right=createBSTHelper(mid+1,end,arr);
        return root;
    }
    public static TreeNode createBST(int[] n){
        TreeNode root=createBSTHelper(0,n.length-1,n);
        System.out.println(root.data);
        return root;
    }
    public static void main(String[] args) {
        int[] n={1,2,3,4,5,6,7};
        TreeNode root=createBST(n);
        inorder(root);
    }
}