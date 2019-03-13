
class TreeNode<T>{
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;
    public TreeNode(T data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
}
public class BSTfromSortedArray{
    public static TreeNode<Integer> createBSTHelper(int start,int end,Integer[] arr){
        if(start>=end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode<Integer> root= new TreeNode<Integer>(arr[mid]);
        root.left=createBSTHelper(start,mid,arr);
        root.right=createBSTHelper(mid+1,end,arr);
        return root;
    }
    public static TreeNode<Integer> createBST(Integer[] n){
        TreeNode<Integer> root=createBSTHelper(0,n.length-1,n);
        System.out.println(root.data);
        return root;
    }
    public static void main(String[] args) {
        Integer[] n={1,2,3,4,5,6,7};
        TreeNode<Integer> root=createBST(n);
    }
}