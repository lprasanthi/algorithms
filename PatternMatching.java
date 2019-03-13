public class PatternMatching{
    public static int count(String input,char a){
        char pattern[]=input.toCharArray();
        int count=0;
        for(int i=0;i<pattern.length;i++){
            if(pattern[i] == a)
                count++;
        }
        return count;
    }
    public static String buildPattern(String Pattern,String a,String b){
        String value="";
        for(int i=0;i<Pattern.length();i++){
            if(Pattern.charAt(i) == 'a'){
                value=value+a;
            }else{
                value=value+b;
            }
        }
        return value;
    }
    public static boolean isPattern(String Pattern, String value){
        char a=Pattern.charAt(0);
        char b=(a=='a')?'b':'a';
        int bindex=Pattern.indexOf(b);
        int aindex=0;
        int vlength=value.length();
        int plength=Pattern.length();
        int alength=count(Pattern,a);
        int blength=count(Pattern,b);
        for(int i=1;i<vlength/alength;i++){
            String valueA=value.substring(0, i);
            int valueBindex=bindex*i;
            int Bsize=(vlength-alength*i)/blength;
            String valueB=value.substring(valueBindex, valueBindex+Bsize);
            if(buildPattern(Pattern,valueA,valueB).equals((value))){
                System.out.println(valueA);
                System.out.println(valueB);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        boolean test=isPattern("aaab", "gogogocatttt");
        System.out.println(test);
    }
}