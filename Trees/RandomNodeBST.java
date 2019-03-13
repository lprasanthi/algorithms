import java.util.Random;

class TreeNode{
    public int data;
    public int size=0;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int data){
        this.data=data;
        this.size=1;
        this.left=null;
        this.right=null;
    }
    public void insert(int val){
        if(val < this.data){
            if(this.left == null){
                this.left=new TreeNode(val);
            }else{
                this.left.insert(val);
            }
        }else{
            if(this.right == null){
                this.right=new TreeNode(val);
            }else{
                this.right.insert(val);
            }
        }
        this.size=size+1;
    }
    public TreeNode getIthNode(int index){
        int leftsize= this.left == null ? 0 : this.left.size;
        if(index == leftsize+1){
            return this;
        }else if(index<=leftsize){
            return this.left.getIthNode(index);
        }
        index=index-leftsize+1;
        return this.right.getIthNode(index);   
    }
    public TreeNode getRandomNode(){
        Random random=new Random();
        int index=random.nextInt(this.size);
        return this.getIthNode(index);  
    }
    public String toString(){
        return "val->"+data+"size->"+size;
    }
}


public class RandomNodeBST{
    public static void main(String[] args) {
        TreeNode root=new TreeNode(20);
        int a[]={10,30,5,3,7,15,17,35};
        for(int i=0;i<a.length;i++){
            root.insert(a[i]);
        }
        System.out.println(root.getIthNode(4));
    }
}