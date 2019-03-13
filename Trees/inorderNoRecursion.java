import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode{
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int data){
        this.val=data;
        this.left=null;
        this.right=null;
    }
    public String toString(){
        return ""+this.val;
    }
}

public class inorderNoRecursion{
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list= new ArrayList<>();
        Stack<TreeNode> s= new Stack<TreeNode>();
        if(root == null)
            return list;
        s.add(root);
        while(!s.isEmpty() && root!= null){
            while(root.left != null){
                root=root.left;
                s.push(root);
            }
            root=s.pop();
            list.add(root.val);
            while(!s.isEmpty() && root.right == null){
                root=s.pop();
                list.add(root.val);
            }
            root=root.right;
            s.push(root);
        }
        return list;
    }
    public static void main(String[] args) {
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
        List<Integer> list=inorderTraversal(t1);
        System.out.println(list);
    }
}