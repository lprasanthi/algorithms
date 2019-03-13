class Tree{
    public TreeNode root;
    public Tree(){
        TreeNode t1=new TreeNode(10);
        TreeNode t2=new TreeNode(5);
        TreeNode t3=new TreeNode(15);
        TreeNode t4=new TreeNode(3);
        TreeNode t5=new TreeNode(8);
        TreeNode t6=new TreeNode(12);
        TreeNode t7=new TreeNode(18);
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

public class validateBST{
    public static Boolean isBSTHelper(TreeNode root, int min, int max){
        if(root == null)
            return true;
        if(root.data<min || root.data>max ){
            System.out.println("root.val"+root.data+" min "+min+" max "+max);
            return false;
        }
        
        return isBSTHelper(root.left, min, root.data) && isBSTHelper(root.right, root.data, max);
        // if(!isBSTHelper(root.left, min, root.data)){
        //     return false;
        // }
            
        // if(!isBSTHelper(root.right, root.data, max)){
        //     return false;
        // }
            
        // return true;
    }
    public static Boolean isBST(TreeNode root){
        return isBSTHelper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    public static void main(String[] args) {
        Tree t = new Tree();
        TreeNode t1= new TreeNode(2147483647);
        Boolean bst=isBST(t1);
        System.out.println(bst);
    }
}