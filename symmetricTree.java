class Tree{
    public TreeNode root;
    public Tree(){
        TreeNode t1=new TreeNode(10);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(2);
        TreeNode t4=new TreeNode(3);
        TreeNode t5=new TreeNode(4);
        TreeNode t6=new TreeNode(4);
        TreeNode t7=new TreeNode(3);
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;
        root=t1;
    }

}
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
public class symmetricTree{
    public static boolean isSymmetricTree(TreeNode left,TreeNode right){
        if(left == null || right == null)
            return left == right;
        if(left.data != right.data)
            return false;
        return isSymmetricTree(left.left,right.right) && isSymmetricTree(left.right,right.left);
    }
    public static void main(String[] args) {
       Tree bt= new Tree();
        System.out.println(isSymmetricTree(bt.root.left,bt.root.right));
    }
}