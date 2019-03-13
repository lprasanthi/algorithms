import LinkedListNode.LinkedList;
import LinkedListNode.Node;

public class Palindrome{
    public static Node<Integer> reverse(Node<Integer> head){
        Node<Integer> prev,cur,temp;
        prev=null;
        cur=head;
        temp=head;
        while(cur!=null){
            temp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;

    }
    public static Boolean isPalindrome(LinkedList<Integer> list){
        Node<Integer> head=list.getHead();
        Node<Integer> slow,fast,temp;
        slow=head;
        fast=head;
        if(head==null || head.next==null)
            return true;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null){
            slow=slow.next;
        }
        fast=reverse(slow);
        slow=head;
        while(fast!=null){
            if(fast.data != slow.data)
                return false;
            slow=slow.next;
            fast=fast.next;    
        }
        return true;
    }
    private static Boolean isPalindromeHelper(LinkedList<Integer> list,Node<Integer> head){
        
    }
    public static Boolean isPalindromeRec(LinkedList<Integer> list){
        return isPalindromeHelper(list,list.head);
    }
    public static void main(String[] args) {
        LinkedList<Integer> list= new LinkedList<Integer>(); 
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(2);
        list.add(1);
        Boolean pal=isPalindrome(list);
        System.out.println(pal);
    }
}
