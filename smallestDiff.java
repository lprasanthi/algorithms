import java.util.Arrays;

class Pair{
    int difference;
    int pair[]={1,2};
    Pair(){
        difference=1900;
    }
}
public class smallestDiff{
    public static void updateDifference(int a,int b,Pair p){
        int diff=a-b;
        if(diff < p.difference){
            p.difference=diff;
            p.pair[0]=a;
            p.pair[1]=b;
        }
    }
    public static Pair getSmallest(int[] a,int[] b){
        Pair p=new Pair();
        Arrays.sort(a);
        Arrays.sort(b);
        int i,j;
        i=j=0;
        while(i<a.length && j<b.length){
            if(a[i]<b[j]){
                updateDifference(b[j],a[i],p);
                i++;
            }else{
                updateDifference(a[i],b[j],p);
                j++;
            }  
        }
        return p;
    }
    public static void main(String[] args) {
        int a[]={1,3,15},b[]={16,127,235,19,8};
        Pair p=getSmallest(a,b);
        //System.out.println(p.difference);
        System.out.println(p.difference+"->{"+p.pair[0]+","+p.pair[1]+"}");
    }
}