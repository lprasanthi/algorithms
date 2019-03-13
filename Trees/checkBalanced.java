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
public class checkBalanced{
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
        TreeNode root=createBSTHelper(0,7,n);
        System.out.println(root.data);
        return root;
    }
    private static int checkHeight(TreeNode root){
        if(root == null)
            return -1;
        int leftheight=checkHeight(root.left);
        int rightheight=checkHeight(root.right);
        if(leftheight == Integer.MIN_VALUE || rightheight == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        if(Math.abs(leftheight-rightheight) > 1){
            return Integer.MIN_VALUE;
        }
        return Math.max(leftheight, rightheight)+1;
        
    }
    public static boolean isBalanced(TreeNode root){
        if(checkHeight(root) != Integer.MIN_VALUE)
            return true;
        return false;
    }
    public static void main(String[] args) {
        int[] n={1,2,3,4,5,6,7};
        TreeNode root=createBST(n);
        System.out.println(isBalanced(root));
    }
}