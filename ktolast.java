import LinkedListNode.LinkedList;
import LinkedListNode.Node;

public class ktolast{
    public static void main(String[] args) {
       LinkedList<String> list= new LinkedList<String>(); 
       list.add("H");
       list.add("E");
       list.add("L");
       list.add("O");
       list.add("L");
       list.add("L");
       list.add("L");
       list.add("S");
       Solution s = new Solution();
       Node<String> n=s.getktolast(list,1);
       System.out.println(n.data);
    }
}
class Solution{
    public Node<String> getktolast(LinkedList<String> list,int k){
        int count=0;
        Node<String> head=list.getHead();
        Node<String> slow=head;
        Node<String> fast=head;
        while(fast!=null && count != k){
            fast=fast.next;
            count++;
        }
        while(fast != null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow;
    }
}