import java.util.HashMap;

class RandomListNode {
    int label;
    RandomListNode next, random;
    RandomListNode(int x) { 
        this.label = x; 
        this.next=null;
        this.random=null;
    }
};

public class randomPointer{
    public static RandomListNode deepCopy(RandomListNode head){
        HashMap<RandomListNode,RandomListNode> map= new HashMap<>();
        RandomListNode cur=head,prev=null;;
        while(cur != null){
            RandomListNode temp= new RandomListNode(cur.label);
            map.put(cur, temp);
            if(prev != null){
                prev.next=temp;
                prev=prev.next;
            }else{
                prev=temp;
            }
            cur=cur.next;
        }
        //prev.next=null;
        RandomListNode head1=map.get(head);
        RandomListNode cur1=head1;
        cur=head;
        while(cur != null){
          cur1.random=map.get(cur.random);
          cur=cur.next;
          cur1=cur1.next;
        }
        return head1;
    }
    public static void main(String[] args) {
        RandomListNode a= new RandomListNode(1);
        RandomListNode b= new RandomListNode(2);
        RandomListNode c= new RandomListNode(3);
        a.next=b;
        b.next=c;
        c.next=null;
        a.random=c;
        c.random=b;
        b.random=a;
        RandomListNode head= deepCopy(a);
        while(head != null){
            System.out.println("head "+head+" val "+head.label+" next "+head.next+" random "+head.random);
            head=head.next;
        }
    }
}