import LinkedListNode.LinkedList;
import LinkedListNode.Node;

public class partitionX{
    public static void main(String[] args) {
       LinkedList<Integer> list= new LinkedList<Integer>(); 
       list.add(3);
       list.add(5);
       list.add(8);
       list.add(5);
       list.add(10);
       list.add(2);
       list.add(1);
       Solution s = new Solution();
       LinkedList<Integer> list2=s.partitionAroundX(list,5);
       list2.print();
    }
}
class Solution{
    public LinkedList<Integer> mergeLists(LinkedList<Integer> list1,LinkedList<Integer> list2){
        if(list1==null)
            return list2;
        if(list2 == null)
            return list1;
        Node<Integer> list1head= list1.getHead();  
        Node<Integer> list2head= list2.getHead(); 
        Node<Integer> cur=list1head; 
        while(cur.next != null){
            cur=cur.next;
        }
        cur.next=list2head;
        return list1;
    }
    public LinkedList<Integer> partitionAroundX(LinkedList<Integer> list,int x){
        Node<Integer> head= list.getHead();
        Node<Integer> cur=head;
        int count=1;
        Node<Integer> pivot=list.getNthNode(x);
        LinkedList<Integer> lowList= new LinkedList<Integer>();
        LinkedList<Integer> highList= new LinkedList<Integer>();
        while(cur!=null){
            Node<Integer> temp=cur.next;
            if(count == x){
                highList.addNodeToHead(cur);
            }else {
                if(cur.data < x){
                    lowList.addNodeToHead(cur);
                }else{
                    highList.addNodeToHead(cur);
                }
            }
            cur=temp;
            count++;
        }
        LinkedList<Integer> finalList=mergeLists(lowList,highList);
        return finalList;
    }
}