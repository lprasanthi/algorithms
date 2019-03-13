import java.util.ArrayList;

public class arrayPermutation{
    private static ArrayList<ArrayList<Integer>> getPermutationsHelper(int[] a,int n){
        ArrayList<ArrayList<Integer>> mainlist= new ArrayList<ArrayList<Integer>>();
        if(n == 1){
            ArrayList<Integer> temp=new ArrayList<Integer>();
            temp.add(a[n-1]);
            mainlist.add(temp);
            return mainlist;
        }
        mainlist= getPermutationsHelper(a, n-1);
        int size=mainlist.size();
        // System.out.println("size "+size+" n "+n);
        for(int i=0;i<size;i++){
            int num=a[n-1];
            ArrayList<Integer> each= mainlist.remove(0);
            // System.out.println("each "+each+" mainlist "+mainlist);
            for(int j=0; j<n;j++){
                ArrayList<Integer> temp=new ArrayList<Integer>();
                temp.addAll(each);
                temp.add(j,num);
                mainlist.add(temp);
            }
           // System.out.println(mainlist);
        }
        return mainlist;
    }
    public static ArrayList<ArrayList<Integer>> getPermutations(int[] a){
        return getPermutationsHelper(a,a.length);
    }
    public static void main(String[] args) {
        int a[]={1,2,3,4};
        ArrayList<ArrayList<Integer>> list= getPermutations(a);
        for(ArrayList<Integer> sublist: list){
            for(int each: sublist){
                System.out.print(each+", ");
            }
            System.out.println();
        }
    }
}