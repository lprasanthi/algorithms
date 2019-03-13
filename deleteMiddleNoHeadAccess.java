import LinkedListNode.LinkedList;
import LinkedListNode.Node;
public class deleteMiddleNoHeadAccess{
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
       s.deleteMiddleNoHeadAccess(list.getNthNode(1));
       list.print();
    }
}
class Solution {
    public Boolean deleteMiddleNoHeadAccess(Node<String> n){
        if(n == null || n.next == null)
            return false;
        n.data=n.next.data;
        n.next=n.next.next;
        return true;
    }
}