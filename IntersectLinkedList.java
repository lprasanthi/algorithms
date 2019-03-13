import LinkedListNode.LinkedList;
import LinkedListNode.Node;

public class IntersectLinkedList{
    public static Node<Integer> findIntersection(LinkedList<Integer> list1,LinkedList<Integer> list2){
        Node<Integer> head1= list1.getHead();
        Node<Integer> head2= list2.getHead();
        if(list1.size() != list2.size()){
            System.out.println("not equal");
            if(list1.size() > list2.size()){
                int count=list2.size();
                while(count != list1.size()){
                    head1=head1.next;
                    count++;
                }
            } else{
                System.out.println("else");
                int count=list1.size();
                System.out.println("else"+count);
                System.out.println("b4 head2"+head2.data);
                while(count != list2.size()){
                    System.out.println("inside head2"+head2.data);
                    head2=head2.next;
                    count++;
                }
                System.out.println("head2"+head2.data);
            }
        }
        System.out.println("head1,head2"+head1.data+head2.data);
        while(head1 != head2){
            head1=head1.next;
            head2=head2.next;
        }
        return head1;
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
       LinkedList<Integer> list2= new LinkedList<Integer>(); 
       list2.add(4);
       list2.add(5);
       list2.add(6);
       LinkedList<Integer> list3= new LinkedList<Integer>(); 
       list3.add(7);
       list3.add(8);
       list3.add(9);
       merge(list1,list3);
       merge(list2,list3);
       System.out.println("lis1");
       list1.print();
       System.out.println("list2");
       list2.print();
       System.out.println("data");
       Node<Integer> n=findIntersection(list1,list2);
       System.out.println("data"+n.data);
       
    }
}