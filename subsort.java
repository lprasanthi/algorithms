class point{
    public int low,high;
    public point(int low,int high){
        this.low=low;
        this.high=high;
    }
    public String toString(){
        return "("+this.low+","+this.high+")";
    }
}

public class subsort{
    public static point findminmax(int a[],int low,int high){
        int min=a[low],max=a[high];
        for(int i=low;i<high;i++){
            if(a[i]<min){
                min=a[i];
            }else if(a[i]>max){
                max=a[i];
            }
        }
        return new point(min,max);
    }
    public static point getSubIndex(int a[]){
        int i=1,j=a.length-1;
        while(a[i]>a[i-1] && i<a.length){
            i++;
        }
        while(a[j]>a[j-1] && j>0){
            j--;
        }
        int left=i-1,right=j;
        point middle=findminmax(a,i,j-1);
        System.out.println(middle);
        System.out.println(left+"-->"+left+"right"+"-->"+a[j]);
        while(a[left]> middle.low || a[left] > a[j]){
           System.out.println(a[left]+","+left);
            left--;
        }
        System.out.println("left"+left);
        while(a[right] < middle.high || a[right]<a[i] ){
            //System.out.println(a[right]+","+right);
            right++;
        }
        System.out.println(left+"|"+right);
        return new point(left+1,right-1);
    }
    public static void main(String[] args) {
        int a[]={1,2,4,7,10,11,8,12,5,6,16,18,19};
        point p=getSubIndex(a);
        System.out.println(p);
    }
}