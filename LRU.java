import java.util.HashMap;

class Pair{
    int key;
    String value;
    public Pair(int key,String value){
        this.key=key;
        this.value=value;
    }
    public String toString(){
        return key+"-->"+value;
    }
}
class LinkedListNode{
    public Pair data;
    public LinkedListNode prev;
    public LinkedListNode next;
    public LinkedListNode(Pair data){
        this.data=data;
        this.prev=null;
        this.next=null;
    }
}
class cache{
    public int size;
    public HashMap<Integer,LinkedListNode> buckets;
    public LinkedListNode head;
    public LinkedListNode tail;
    public cache(int size){
        this.size=size;
        this.head=null;
        this.tail=null;
        this.buckets= new HashMap<Integer,LinkedListNode>();
    }
    public boolean isFull(){
        return this.buckets.size() == this.size;
    }
    public void addToCache(Pair data){ 
        System.out.println(this.buckets.size());
        if(this.isFull()){
            evict();
        }
        LinkedListNode temp = new LinkedListNode(data);
        addToHead(temp);
        this.buckets.put(data.key, temp); 
    }
    private void addToHead(LinkedListNode data){
        if(this.head == null){
            this.head=data;
            this.tail=this.head;
        }else{
            data.prev=null;
            data.next=this.head;
            this.head.prev=data;
            this.head=data;
        }
        
    }
    public void evict(){
        System.out.println("entered evict");
        if(tail != null){
            System.out.println("entered tail!=null");
            Pair data=this.tail.data;
            System.out.println("evict"+this.tail.data);
            removeNode(this.tail);
            this.buckets.remove(data.key); 
        }   
    }
    private void removeNode(LinkedListNode node){
        LinkedListNode prev=node.prev;
        LinkedListNode next=node.next; 
        if(prev != null) prev.next=next;
        if(next != null) next.prev=prev; 
        if(node == head) head=next;
        if(node == tail) tail=prev;
    }
    public Pair get(int key){
        LinkedListNode temp=this.buckets.get(key);
        removeNode(temp);
        addToHead(temp);
        return temp.data;
    }
    public void printCache(){
        LinkedListNode cur=head;
        System.out.println("LinkedList");
        while(cur != null){
            System.out.println(cur.data);
            cur=cur.next;
        }
        System.out.println("Map");
        for(Integer key: buckets.keySet()){
            System.out.println(buckets.get(key).data);
        }
    }
}

public class LRU{
    public static void main(String[] args) {
        cache lru = new cache(4);
        lru.addToCache(new Pair(1,"Aditya"));
        lru.addToCache(new Pair(2,"Prasanthi"));
        lru.addToCache(new Pair(3,"Ananth"));
        lru.addToCache(new Pair(4,"Sarada"));
        Pair data=lru.get(1);
        //System.out.println(data);
        //lru.printCache();
        lru.addToCache(new Pair(6,"Aditya"));
        //lru.evict();
        lru.printCache();
    }
}