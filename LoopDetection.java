import javax.lang.model.util.ElementScanner6;

import LinkedListNode.LinkedList;
import LinkedListNode.Node;

public class LoopDetection{
    public static Node<Integer> getLoopNode(LinkedList<Integer> list1){
        Node<Integer> fast,slow;
        slow=list1.getHead();
        fast=list1.getHead();
        do{
            slow=slow.next;
            fast=fast.next.next;
        }while(slow != fast && slow!=null && fast!=null && fast.next!=null);
        if(slow == fast){
            slow=list1.getHead();
            while(slow != fast && slow!=null && fast!=null){
                slow=slow.next;
                fast=fast.next;
            }
            return slow;
        }
        return null;
    }
    public static Boolean isCircularList(LinkedList<Integer> list1){
        Node<Integer> fast,slow;
        slow=list1.getHead();
        fast=list1.getHead();
        do{
            slow=slow.next;
            fast=fast.next.next;
        }while(slow != fast && slow!=null && fast!=null && fast.next!=null);
        return slow == fast;
    }
    public static void merge(LinkedList<Integer> list1,LinkedList<Integer> list2){
        Node<Integer> head1= list1.getHead();
        while(head1.next != null){
            head1=head1.next;
        }
        head1.next=list2.getHead();
    }
    public static void main(String[] args) {
        LinkedList<Integer> list1= new LinkedList<Integer>(); 
        list1.add(1);
        list1.add(2);
        Boolean isCircular=isCircularList(list1);
        System.out.println(isCircular);
        LinkedList<Integer> list2= new LinkedList<Integer>(); 
        list2.add(4);
        list2.add(5);
        list2.add(6);
        Boolean isCircular1=isCircularList(list1);
        System.out.println(isCircular1);
        Node<Integer> head2= list2.getHead();
        Node<Integer> cur2=head2;
        while(cur2.next != null){
            cur2=cur2.next;
        }
        cur2.next=head2;
        merge(list1,list2);
        //list1.print();
        Node<Integer> circularNode=getLoopNode(list1);
        System.out.println(circularNode.data);
    }
}