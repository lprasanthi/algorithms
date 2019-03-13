import java.util.Stack;

class Tower{
    public Stack<Integer> disks;
    public int size;
    Tower(int n){
        disks=new Stack<Integer>();
        size=n;
    }
    public void addDisk(int i){
        disks.push(i);
    }
    public void addAllDisks(int n){
        if(n>size){
           System.out.println("Stack size exceeded !!!"); 
        }else{
            for(int i=n;i>0;i--){
                disks.push(i);
            }
        }
    }
}
public class TowersOfHanoi{
    private static void moveDisksHelper(Tower t1, Tower t2, Tower buffer, int n){ 
        if(n<1){
            return;
        }
        if(n == 1){
            int disk=t1.disks.pop();
            t2.addDisk(disk);
            return;
        }
        moveDisksHelper(t1, buffer,t2, n-1);
        moveDisksHelper(t1, t2, buffer, 1);
        moveDisksHelper(buffer, t2,t1,n-1);
    }
    public static void moveDisks(Tower t1, Tower t2,int n){
        Tower buffer= new Tower(n);
        moveDisksHelper(t1, t2, buffer, n);
    }
    public static void main(String[] args) {
        Tower t1= new Tower(4);
        t1.addAllDisks(4);
        Tower t2= new Tower(4);
        System.out.println("Before");
        System.out.println(t1.disks);
        moveDisks(t1,t2,4);
        System.out.println("after");
        System.out.println(t2.disks);
    }
}