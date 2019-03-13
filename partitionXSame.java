import LinkedListNode.LinkedList;
import LinkedListNode.Node;

public class partitionXSame{
    public static void main(String[] args) {
       LinkedList<Integer> list= new LinkedList<Integer>(); 
       list.add(3);
       list.add(5);
       list.add(10);
       list.add(6);
       list.add(7);
       list.add(2);
       list.add(12);
       Solution s = new Solution();
       s.partitionAroundX(list,4);
    }
}
class Solution{
    
    public void partitionAroundX(LinkedList<Integer> list,int x){
        Node<Integer> pivot=list.getNthNode(x);
        Node<Integer> head=list.getHead();
        Node<Integer> cur=head;
        Node<Integer> tail=head;
        Node<Integer> temp=head;  
        while(cur != null){
            temp=cur.next;
            System.out.println("temp"+temp.data);
            if(cur.data<pivot.data){
                cur.next=head;
                head=cur;
                System.out.println("less after"+head.data);
                System.out.println("less after tail"+tail.data);
            }else{
                tail.next=cur;
                tail=cur;
                System.out.println("more after"+tail.data);
                System.out.println("more after head"+head.data);
            }
            cur=temp;
        }
    }
}