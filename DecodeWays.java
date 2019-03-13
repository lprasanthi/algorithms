public class DecodeWays{
    static int count=0;
    private static int toInt(String s){
        int num=Integer.parseInt(s);
        int count=0;
        if(num> 9 && num <= 26){
            count++;
        }
        if(num % 10 != 0){
            count++;
        }
        return count;
    }
    public static int numDecodings(String s){
        int count=0;
        if(s.length() == 0)
            return 0;
        if(s.startsWith("0"))
            return 0;
        if(s.length() <= 2 && Integer.parseInt(s)<=26){
            return toInt(s);
        }
        if(Integer.parseInt(s.substring(0,1)) > 0){
            count=count+numDecodings(s.substring(1));
        } 

        if(Integer.parseInt(s.substring(0,2))<=26){
            count=count+numDecodings(s.substring(2));
        } 
        return count;
    }
    public static void main(String[] args) {
        String num="27";
        int output=numDecodings(num);
        System.out.println(output);
    }
}