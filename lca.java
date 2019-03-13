class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val){
        this.val=val;
        this.left=null;
        this.right=null;
    }
    public String toString(){
        return String.valueOf(val);
    }
}

public class lca{
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root== q)
            return root;
        TreeNode left=lowestCommonAncestor(root.left, p, q);
        TreeNode right=lowestCommonAncestor(root.right, p, q);
        System.out.println("left->"+left+"right->"+right+"root->"+root);
        if(left != null && right != null)
            return root;
        if(left == null)
            return right;
        return left; 
    }
    public static void main(String[] args) {
       TreeNode a=new TreeNode(1);
       TreeNode b=new TreeNode(2);
       TreeNode c=new TreeNode(3);
       TreeNode d=new TreeNode(4);
       TreeNode e=new TreeNode(5);
       TreeNode f=new TreeNode(6);
       TreeNode g=new TreeNode(7);
       TreeNode h=new TreeNode(8);
       a.left=b;
       a.right=c;
       b.left=d;
       b.right=e;
       c.left=f;
       c.right=g;
       d.left=h;
       TreeNode ancestor=lowestCommonAncestor(a,e,g);
       System.out.println(ancestor.val);
    }
}