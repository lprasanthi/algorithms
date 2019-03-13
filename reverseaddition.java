import LinkedListNode.LinkedList;
import LinkedListNode.Node;
import Helper.PartialSum;


public class ReverseAddition{
    public static LinkedList<Integer> reverseAdd(LinkedList<Integer> list1,LinkedList<Integer> list2){
        Node<Integer> head1=list1.getHead();
        Node<Integer> head2=list2.getHead();
        Node<Integer> cur1=head1;
        Node<Integer> cur2=head2;
        LinkedList<Integer> list3 = new LinkedList<Integer>();
        int carry=0;
        int sum=0;
        if(list1.size()!=list2.size()){
            if(list1.size()>list2.size()){
                int count=list2.size();
                while(count != list1.size()){
                    list2.add(0);
                    count++;
                }
            }else{
                int count=list1.size();
                while(count != list2.size()){
                    list1.add(0);
                    count++;
                } 
            }
        }
        list2.print();
        while(cur1 != null){
            sum=cur1.data+cur2.data+carry;
            carry=(sum/10);
            list3.add(sum%10);
            cur1=cur1.next;
            cur2=cur2.next;
        }
        
        if(carry>0)
            list3.add(carry); 
        return list3;
    }
    public static PartialSum addHelper(Node<Integer> head1,Node<Integer> head2,LinkedList<Integer> list3){
        if(head1 == null && head2==null){
            PartialSum ps= new PartialSum();
            return ps;
        }
        PartialSum ps=addHelper(head1.next, head2.next,list3);
        int sum = ps.carry+head1.data+head2.data;
        ps.carry= (sum)/10;
        sum= (sum)%10;
        list3.addToHead(Integer.valueOf(sum));
        return ps;
    }
    public static LinkedList<Integer> add(LinkedList<Integer> list1,LinkedList<Integer> list2){
        Node<Integer> head1=list1.getHead();
        Node<Integer> head2=list2.getHead();
        Node<Integer> cur1=head1;
        Node<Integer> cur2=head2;
        LinkedList<Integer> list3 = new LinkedList<Integer>();
        int carry=0;
        int sum=0;
        if(list1.size()!=list2.size()){
            if(list1.size()>list2.size()){
                int count=list2.size();
                while(count != list1.size()){
                    list2.add(0);
                    count++;
                }
            }else{
                int count=list1.size();
                while(count != list2.size()){
                    list1.add(0);
                    count++;
                } 
            }
        }
        PartialSum pSum=addHelper(head1,head2,list3);
        if(pSum.carry > 0){
            list3.addToHead(pSum.carry);
        }
        return list3;
    }

    
    public static void main(String[] args) {
       LinkedList<Integer> list= new LinkedList<Integer>(); 
       list.add(1);
       list.add(2);
       list.add(3);
       LinkedList<Integer> list2= new LinkedList<Integer>(); 
       list2.add(4);
       list2.add(5);
       list2.add(6);
       LinkedList<Integer> sum=add(list,list2);
       sum.print();
    }
}
