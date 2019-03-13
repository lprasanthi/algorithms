class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
}
public class KthSmallestBST{
    static int count=0;
    static int val=0;
    private static int kthSmallestHelper(TreeNode root,int k){
        if(root==null)
            return val;
        System.out.println("root "+root.val+" val "+val+" count "+count);
        if(count == k)
            return val;
        if(val == 0){
            val=kthSmallestHelper(root.left, k);
            count++;
            if(k==count){
                val=root.val;
                System.out.println("val"+val);
                return val;
            }
            val=kthSmallestHelper(root.right, k);
        }
        return val;
    }
    public static int kthSmallest(TreeNode root, int k) {
       return kthSmallestHelper(root, k); 
    }

    public static void main(String[] args) {
       TreeNode one=new TreeNode(1);
       TreeNode two=new TreeNode(2);
       TreeNode three=new TreeNode(3);
       TreeNode four=new TreeNode(4);
       three.left=one;
       three.right=four;
       one.right=two;
       TreeNode root=three;
       System.out.println(kthSmallest(root,1));
    }
}