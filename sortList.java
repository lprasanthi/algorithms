class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) { 
        val = x;
    }
}
public class sortList{
    public static ListNode mergListNodes(ListNode head1,ListNode head2){
        if(head1 == null){
            return head2;
        }
        if(head2 == null){
            return head1;
        }
        ListNode head= new ListNode(Integer.MIN_VALUE);
        ListNode cur=head;
        while(head1 != null && head2 != null){
          if(head1.val < head2.val){
              cur.next=head1;
              head1=head1.next;
          }else{
              cur.next=head2;
              head2=head2.next;
          }
          cur=cur.next;  
        }
        if(head1 == null){
            cur.next=head2;
        }else{
            cur.next=head1;
        }
        return head.next;
    }
    public static ListNode sortListNode(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev=null,slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode l1=sortListNode(head);
        ListNode l2=sortListNode(slow);
        return mergListNodes(l1,l2);
    }
    public static void main(String[] args) {
        ListNode a= new ListNode(4);
        ListNode b= new ListNode(2);
        ListNode c= new ListNode(1);
        ListNode d= new ListNode(3);
        //ListNode e= new ListNode(0);
        ListNode head=a;
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=null;
        //e.next=null;
        head=sortListNode(head);
        while(head != null){
            System.out.println(head.val+" , ");
            head=head.next;
        }
    }
}