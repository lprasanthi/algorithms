import LinkedListNode.LinkedList;
import LinkedListNode.Node;

public class Reverse{
    public static void reverse(LinkedList<Integer> list){
        Node<Integer> head= list.getHead();
        Node<Integer> temp,cur,prev;
        temp=head;
        cur=head;
        prev=null;
        while(cur!=null){
            temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        temp=prev;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
        
    }
    public static void main(String[] args) {
       LinkedList<Integer> list= new LinkedList<Integer>(); 
       list.add(1);
       list.add(2);
       list.add(3);
       list.add(4);
       reverse(list);
    }
}
