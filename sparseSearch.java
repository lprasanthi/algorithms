public class sparseSearch{
    private static int searchHelper(String[] input,String str,int low,int high){
        if(low > high)
            return -1;
        int mid=(low+high)/2;
        while(input[mid].equalsIgnoreCase("")){
            mid--;
        }
        //System.out.println("low-->"+low+",mid-->"+mid+",high-->"+high);
        if(input[mid].equalsIgnoreCase(str))
            return mid;
        //System.out.println("str.compareToIgnoreCase(input[mid])-->"+str.compareToIgnoreCase(input[mid]));
        else if(str.compareToIgnoreCase(input[mid]) < 0)
            return searchHelper(input, str, low, mid-1);
        else
            return searchHelper(input, str, low+1, high);

    }
    public static int search(String[] input,String str){
        return searchHelper(input, str,0,input.length-1);
    }
    public static void main(String[] args) {
        String input[]={"at","","","","ball","","","car","","","dad","",""};
        int index=search(input,"CAR");
        System.out.println(index);
    }
}