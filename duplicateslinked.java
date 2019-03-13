import LinkedListNode.LinkedList;
import LinkedListNode.Node;
import java.util.HashMap;
import java.util.HashSet;

public class duplicateslinked{
    public static void main(String[] args) {
       LinkedList<String> list= new LinkedList<String>(); 
       list.add("H");
       list.add("E");
       list.add("L");
       list.add("O");
       list.add("L");
       list.add("L");
       list.add("L");
       list.add("L");
       Solution s = new Solution();
       s.removeDuplicatesNoBuffer(list);
       list.print();

    }
}
class Solution{
    public void removeDuplicatesBuffer(LinkedList<String> list){
        HashSet<String> hashset= new HashSet<String>();
        Node<String> head=list.getHead();
        Node<String> prev=head;
        Node<String> cur=head;
        while(cur != null){
            if(hashset.contains(cur.data)){
                prev.next=cur.next;
            }else{
                hashset.add(cur.data);
                prev=cur;
            }
            cur= cur.next;
        }

    }
    public void removeDuplicatesNoBuffer(LinkedList<String> list){
        Node<String> head= list.getHead();
        Node<String> cur=head;
        while(cur != null){
            String curData= cur.data;
            Node<String> prev=cur;
            Node<String> runner=cur.next;
            while(runner != null){
                if(runner.data == curData){
                    prev.next = runner.next;
                }else{
                    prev=runner;
                }
                runner=runner.next;
            }
            cur=cur.next;
        }
        list.delete("E");
    }
}