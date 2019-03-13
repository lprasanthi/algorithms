class Tree{
    public TreeNode root;
    public Tree(){
        this.root=null;
    }
    public Tree(TreeNode root){
        this.root=root;
    }
    public void track(int x){
        TreeNode node=new TreeNode(x);
        insert(node);
    }
    private void insert(TreeNode node){
        if(this.root == null)
            this.root=node;
        else{
            this.root.insert(node);
        }
    }
    public int getRank(int n){
        if(this.root == null)
            return -1;
        return this.root.getRank(n);
    }
    public void getRank(){
        if(this.root != null)
            this.root.getRank();
    }
    
}
class TreeNode{
    public int rank;
    public int data;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int data){
        this.data=data;
        this.rank=0;
        this.left=null;
        this.right=null;
    }
    public void updateRank(){
        this.rank++;
        if(this.left != null)
            this.left.updateRank();
        if(this.right != null)
            this.right.updateRank();
    }
    public void insert(TreeNode node){
        if(node.data <= this.data){
            this.rank++;
            if(this.right != null)
                this.right.updateRank();
            if(this.left != null)
                this.left.insert(node);
            else{
                this.left=node;
                node.rank=this.rank - 1;
            }
        }
        if(node.data > this.data){
            if(this.right != null)
                this.right.insert(node);
            else{
                this.right = node;
                node.rank=this.rank + 1;
            }
        }
    }
    public int getRank(int data){
        if(this.data == data){
            return this.rank;
        }else if(data < this.data){
            if(this.left != null)
                return this.left.getRank(data);
            return -1;
        }else{
            if(this.right != null)
                return this.right.getRank(data);
            return -1;
        }
    }
    public void getRank(){
        if(this.left != null)
            this.left.getRank();
        System.out.println("Node-->"+this.data+", Rank-->"+this.rank);
        if(this.right != null)
            this.right.getRank();
    }
}
public class rankFromStream{
    public static void main(String[] args) {
      Tree tree=new Tree();
      tree.track(5);
      tree.track(1);
      tree.track(4);
      tree.track(4);
      tree.track(5);
      tree.track(9);
      tree.track(7);
      tree.track(13);
      tree.track(3);
      tree.track(6);
      tree.track(-1);
      tree.track(-8);
      tree.track(30);
      tree.track(10);
      int n=tree.getRank(7);
      //System.out.println(n);  
      tree.getRank();
    }
}