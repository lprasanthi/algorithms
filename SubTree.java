class Tree{
    public TreeNode root;
    public TreeNode t3,t5;
    public Tree(){
        TreeNode t1=new TreeNode(10);
        TreeNode t2=new TreeNode(5);
        t3=new TreeNode(15);
        TreeNode t4=new TreeNode(3);
        t5=new TreeNode(8);
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

public class SubTree{
    public static Boolean matchTree(TreeNode T1,TreeNode T2){
        if(T1 == null){
            if(T2 == null)
                return true;
            return false;
        }
        if(T2 == null){
            return false;
        }
        if(T1.data != T2.data)
           return false;
        else {
            return matchTree(T1.left, T2.left) && matchTree(T1.right, T2.right);
        }  
    }
    public static Boolean SubTreeHelper(TreeNode T1,TreeNode T2){
        if(T1 == null)
            return false;
        System.out.println("T1-->"+T1.data+" ,T2-->"+T2.data);
        if(T1.data == T2.data){
            return matchTree(T1,T2);
        }
        return SubTreeHelper(T1.left,T2) || SubTreeHelper(T1.right,T2);
    }
    public static Boolean isSubtree(TreeNode T1,TreeNode T2){
        return SubTreeHelper(T1,T2);
    }
    public static void main(String[] args) {
        Tree t = new Tree();
        Boolean bst=isSubtree(t.root,t.t3);
        System.out.println(bst);
    }
}