import java.util.ArrayList;

public class pondSize{
    public static int getPonds(int[][] n,int row,int col,int sum){
        if(row == n.length ){
            return sum;
        }
        if(col == n.length){
            return sum;
        }
        if(n[row][col] != 0){
            return sum;
        }
        n[row][col]=-1;
        sum=sum+1;
        sum=getPonds(n,row+1,col,sum);
        sum=getPonds(n,row,col+1,sum);
        sum=getPonds(n,row+1,col+1,sum);
        return sum;
    }
    public static ArrayList<Integer> getPondsCount(int[][] n){
        ArrayList<Integer> ponds=new ArrayList<Integer>();
        for(int i=0;i<n.length;i++){
            for(int j=0;j<n.length;j++){
                if(n[i][j] == 0){
                    int sum =getPonds(n, i, j, 0);
                    if(sum>0){
                        ponds.add(sum);
                    }
                }
            }
        }
        
        return ponds;
    }
    public static void main(String[] args) {
        int n[][]={{0,2,1,0},{0,1,0,1},{1,1,0,1},{0,1,0,1}};
        ArrayList<Integer> a=getPondsCount(n);
        for(int i=0;i<a.size();i++){
            System.out.println(a.get(i));
        }
    }
}