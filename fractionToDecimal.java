import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class fractionToDecimal{
    public static String divideFraction(int numerator, int denominator) {
        if(numerator == 0){
            return "0";
        }
        StringBuilder result=new StringBuilder();
        int count=0;
        Map<Long,Integer> map=new HashMap<Long,Integer>();
        if(denominator<0){
            count++;
        }
        if(numerator<0){
            count++;
        }
        if(count == 1){
            result=result.append("-");
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        result.append(num/den);
        long rem=num % den;
        if(rem == 0){
           return result.toString();
        }
        result.append(".");
        map.put(rem, result.length());
        while(rem != 0){
            rem=rem*10;
            long remainder=rem%den;
            long quotient=rem/den;
            if(map.containsKey(remainder)){
                int index=map.get(remainder);
                result.insert(index, "(");
                result.append(quotient);
                result.append(")");
                return result.toString();
            }
            result.append(quotient);
            map.put(remainder, result.length());
            rem=remainder;
        }
        return result.toString();
    }
    public static void main(String[] args) {
        int numerator=-1, denominator=-2147483648;
        String s=divideFraction(numerator,denominator);
        System.out.println(s);
    }
}