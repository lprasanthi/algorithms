public class Tree<T>{
    public TreeNode<T> root;
    public Tree(T type){
        if(type.getClass().getSimpleName() == "Integer"){
            TreeNode<Integer> t1=new TreeNode(1);
            TreeNode<Integer> t2=new TreeNode(2);
            TreeNode<Integer> t3=new TreeNode(3);
            TreeNode<Integer> t4=new TreeNode(4);
            TreeNode<Integer> t5=new TreeNode(5);
            TreeNode<Integer> t6=new TreeNode(6);
            TreeNode<Integer> t7=new TreeNode(7);
            t1.left=t2;
            t1.right=t3;
            t2.left=t4;
            t2.right=t5;
            t3.left=t6;
            t3.right=t7;
        }else{
            TreeNode<String> t1=new TreeNode("A");
            TreeNode<String> t2=new TreeNode("B");
            TreeNode<String> t3=new TreeNode("C");
            TreeNode<String> t4=new TreeNode("D");
            TreeNode<String> t5=new TreeNode("E");
            TreeNode<String> t6=new TreeNode("F");
            TreeNode<String> t7=new TreeNode("G");
            t1.left=t2;
            t1.right=t3;
            t2.left=t4;
            t2.right=t5;
            t3.left=t6;
            t3.right=t7;
        }
        
    }
}