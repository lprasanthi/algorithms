class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){
        val=x;
    }
}
public class BstFromPreorder{
    private static TreeNode contructTree(int[] preorder,int start,int end){
        if(start > end || start<0 || start> preorder.length-1 || end < 0 || end > preorder.length-1){
            return null;
        }
        int val=preorder[start];
        System.out.println(val+"start"+start+"end"+end);
        TreeNode root=new TreeNode(val);
        int mid=end+1;
        for(int i=start+1; i<=end;i++){
            if(preorder[i]> preorder[start]){
                mid=i;
                break;
            }
        }
        System.out.println(val+"start"+start+"end"+end+"mid"+mid);
        root.left= contructTree(preorder, start+1, mid-1);
        root.right= contructTree(preorder, mid, end);
        return root;
    }
    public static TreeNode bstFromPreorder(int[] preorder) {
        return contructTree(preorder, 0, preorder.length-1);
    }
    public static void main(String[] args) {
        int[] preorder={8,10,12};
        TreeNode n=bstFromPreorder(preorder);
        System.out.println(n.val);
        System.out.println(n.right.val);
        System.out.println(n.right.right.val);
    }
}