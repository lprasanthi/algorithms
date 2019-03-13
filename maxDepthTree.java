class Tree{
    public TreeNode root;
    public Tree(){
        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);
        TreeNode t6=new TreeNode(6);
        TreeNode t7=new TreeNode(7);
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
public class maxDepthTree{
    private static int findMaxDepthHelper(TreeNode root, int count){
        int max=-1;
        if(root == null)
            return count; 
        count++;  
        max=Math.max(findMaxDepthHelper(root.left,count),findMaxDepthHelper(root.right,count));
        if(max < count)
            max=count;
        return max;
    }
    public static int findMaxDepth(Tree tree){
        return findMaxDepthHelper(tree.root, 0);
    }
    public static int elegantMaxDepth(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(elegantMaxDepth(root.left),elegantMaxDepth(root.right))+1;
    }
    public static void main(String[] args) {
        Tree tree= new Tree();
        System.out.println("output is ==> "+findMaxDepth(tree));
    }
}