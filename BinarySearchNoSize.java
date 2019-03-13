import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

class Listy{
    ArrayList<Integer> list;
    public Listy(){
        list=new ArrayList<Integer>();
    }
    public void add(int ele){
        list.add(ele);
    }
    public void addAll(int[] list){
        for(int i=0;i<list.length;i++){
            this.list.add(list[i]);
        }
    }
    public int elementAt(int index){
        if(index >= list.size()){
            return -1;
        }else{
            return list.get(index);
        }
    }
    public void print(){
        for(int i=0;i<list.size();i++)
            System.out.println("index-->"+i+",element-->"+list.get(i));
    }
}
public class BinarySearchNoSize{ 
    public static int size=20;
    private static int searchHelper(Listy list,int n,int low,int high){
        if(low > high)
            return -1;
        else{
            int mid=(low+high)/2;
            int element=list.elementAt(mid);
            //System.out.println("low-->"+low+",high-->"+high+",mid-->"+mid+",element-->"+element+",n-->"+n);
            if(element == n)
                return mid;
            else if(element == -1 || n < element)
                return searchHelper(list, n, low, mid-1);
            else
                return searchHelper(list, n, mid+1, high);
        } 
    }
    public static int search(Listy list,int n){
        int index=1;
        int element=list.elementAt(index);
        while(element != -1 && n >= element){
            //System.out.println("index"+index);
            if(n == element)
                return index;
            if(n>element){
                index=index*2;
                element=list.elementAt(index);
                //System.out.println("index-->"+index+",element-->"+element);
            }     
        }
        return searchHelper(list, n, index/2, index-1);
    }
    public static void main(String[] args) {
        Listy list = new Listy();
        int arr[]=new int[size]; 
        for(int i=0;i<size;i++){
            arr[i]=i+2;
        }
        list.addAll(arr);
        list.print();
        int n=22;
        int index=search(list, n);
        System.out.println("element "+n+"is fount at index "+index);
    }
}