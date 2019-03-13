public class plus1{
    public static int[] plusOne(int[] num){
        for(int i=num.length-1;i>=0;i--){
            if(num[i]<9){
                num[i]++;
                return num;
            }
            num[i]=0;
        }
        int[] newNumber= new int[num.length+1];
        newNumber[0]=1;
        for(int i=0;i<num.length;i++){
            newNumber[i+1]=num[i];
        }
        return newNumber;
    }
    public static void main(String[] args) {
        int num[]={9,1,9};
        int newNum[]=plusOne(num);
        for(int i=0;i<newNum.length;i++)
            System.out.println(newNum[i]);
    }
}