package LinkedListNode;

public class LinkedList<T>{
    public Node<T> head; 
    public LinkedList(){
        this.head=null;
    }
    public void add(T data){
        Node<T> n = new Node<T>(data);
        if(head == null){
            head=n;
        }else {
            Node<T> temp=head;
            while(head.next != null){
                head=head.next;
            }
            head.next=n;
            head=temp;
        }
    }
    public void addNode(Node<T> n){
        if(head == null){
            head=n;
        }
        else{
            Node<T> temp=head;
            while(head.next != null){
                head=head.next;
            }
            head.next=n;
            head=temp;
        }   
    }
    public void addToHead(T data){
        Node<T> n = new Node<T>(data);
        Node<T> temp=head;
        head=n;
        n.next=temp;
    }
    public void addNodeToHead(Node<T> n){
        Node<T> temp=head;
        head=n;
        n.next=temp;
    }
    public void delete(T data){
        Node<T> cur=head;
        Node<T> prev=head;
        while(cur != null){
            if(cur.data == data){
                prev.next=cur.next;
            }else{
                prev=cur;
            }
            cur=cur.next;
        }
    }
    public Node<T> getNthNode(int n){
        int count =1;
        Node<T> cur=head;
        while(cur!=null && count !=n ){
            cur=cur.next;
            count++;
        }
        return cur;
    }
    public Node<T> getHead(){
        return this.head;
    }
    public void print(){
        Node<T> cur=head;
        while(cur != null){
            System.out.println(cur.data);
            cur=cur.next;
        }
    }
    public int size(){
        Node<T> cur=head;
        int count=0;
        while(cur != null){
            count++;
            cur=cur.next;
        }
        return count; 
    }
}