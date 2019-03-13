public class Count1Bits{
    private static int countBitsHelper(int num, int count){
        if(num == 0){
            return count;
        }
        count=count+ (num&1);
        num=num>>>1;
        return countBitsHelper(num, count);
    }
    public static int countBits(int num){
        return countBitsHelper(num,0);
    }
    public static void main(String[] args) {
        System.out.println(countBits(-15));
    }
}