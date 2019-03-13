import java.util.HashMap;
class RomanMap{
    public HashMap<Integer,String> roman= new HashMap<Integer,String>();
    public RomanMap(){
        roman.put(1, "I");
        roman.put(5, "V");
        roman.put(10, "X");
        roman.put(50,"L");
        roman.put(100, "C");
        roman.put(500, "D");
        roman.put(1000, "M");
    }
}
public class Roman{
    private static String getRomanHelper(int num){
        RomanMap rm= new RomanMap();
        int min=0;
        int max=0;
        HashMap<Integer,String> romanTable= rm.roman;
        if(romanTable.containsKey(num))
            return romanTable.get(num);
        for(Integer i: romanTable.keySet()){
            if(i<num){
                min = i;
            }else{
                max = i;
                break;
            }
        }
        int mid=(min+max)/2;
        int diff;
        if(num <= mid){
            diff=num-min;
            String s=romanTable.get(min);
            return s+getRoman(diff);
        }else{
            diff=max-num;
            String s=romanTable.get(max);
            return getRoman(diff)+s; 
        }
    }
    public static String getRoman(int num){
        if(num <= 1000){
            return getRomanHelper(num);
        }
        String result="";
        int div=1;
        int rem=0;
        while(num != 0){
            rem= num%10 * div;
            result=getRomanHelper(rem)+result;
            div=div*10;
            num=num/10;
        }
        return result;
    }
    public static String intToRoman(int num){
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
    public static void main(String[] args) {
        System.out.println(intToRoman(860));
        System.out.println(Integer.parseInt("3"));
    }
}