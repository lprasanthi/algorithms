class TreeLinkNode{
    int val;
    TreeLinkNode left,right,next;
    public TreeLinkNode(int x){
        val=x;
        next=null;
        left=null;
        right=null;
    }
}

public class PopulateNextPointers{
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        root.next=null;
        TreeLinkNode curRoot=root;
        while(curRoot!=null){
            TreeLinkNode cur=curRoot;
            TreeLinkNode prev=null;
            while(cur != null && cur.left != null){
                if(prev != null){
                    prev.right.next=cur.left;
                }
                cur.left.next=cur.right;
                cur.right.next=null;
                prev=cur;
                cur=cur.next;
            }
            curRoot= curRoot.left;
        }
    }
    public static void main(String[] args) {
        TreeLinkNode a1= new TreeLinkNode(1);
        TreeLinkNode a2= new TreeLinkNode(2);
        TreeLinkNode a3= new TreeLinkNode(3);
        TreeLinkNode a4= new TreeLinkNode(4);
        TreeLinkNode a5= new TreeLinkNode(5);
        TreeLinkNode a6= new TreeLinkNode(6);
        TreeLinkNode a7= new TreeLinkNode(7);
        a1.left=a2;
        a1.right=a3;
        a2.left=a4;
        a2.right=a5;
        a3.left=a6;
        a3.right=a7;
    }
}