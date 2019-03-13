import java.util.ArrayList;
import java.util.List;

import LinkedListNode.LinkedList;
import LinkedListNode.Node;

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
public class levelOrder{
    public static void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        System.out.println(root.data);
        inorder(root.right);
    }
    public static TreeNode createBSTHelper(int start,int end,int[] arr){
        if(start>=end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode root= new TreeNode(arr[mid]);
        root.left=createBSTHelper(start,mid,arr);
        root.right=createBSTHelper(mid+1,end,arr);
        return root;
    }
    public static TreeNode createBST(int[] n){
        TreeNode root=createBSTHelper(0,7,n);
        System.out.println(root.data);
        return root;
    }
    public static void preorder(TreeNode root,int level,ArrayList<LinkedList<TreeNode>> al){
        if(root==null){
            return;
        }
        LinkedList<TreeNode> levelList;
        if(al.size() > level){
            levelList=al.get(level);
        }else{
            levelList=new LinkedList<TreeNode>();
            al.add(levelList);
        }
        levelList.add(root);
        preorder(root.left,level+1,al);
        preorder(root.right,level+1,al);
    }
    public static void print(LinkedList<TreeNode> list){
        Node<TreeNode> head=list.head;
        while(head != null){
            System.out.println(head.data.data);
            head=head.next;
        }
    }
    public static ArrayList<LinkedList<TreeNode>> getDepthLists(TreeNode root){
        ArrayList<LinkedList<TreeNode>> al= new ArrayList<LinkedList<TreeNode>>();
        preorder(root, 0, al);
        return al;
    }

    private static void zigzaghelper(TreeNode root,int level,List<List<Integer>> list){
        if(root == null){
            return;
        }
        if(level >= list.size()){
            list.add(new ArrayList<Integer>());
        }
        List<Integer> levelList=list.get(level);
        if(level % 2 == 0){
            levelList.add(root.data);
        }else{
            levelList.add(0,root.data);
        }
        zigzaghelper(root.left, level+1, list);
        zigzaghelper(root.right, level+1, list);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> al= new ArrayList<List<Integer>>();
        zigzaghelper(root, 0, al);
        return al;
    }
    public static void main(String[] args) {
        int[] n={1,2,3,4,5,6,7};
        TreeNode root=createBST(n);
        inorder(root);
        ArrayList<LinkedList<TreeNode>> al= getDepthLists(root);
        List<List<Integer>> zz=zigzagLevelOrder(root);
        System.out.println("zz"+zz);
    }
}