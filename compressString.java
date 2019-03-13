public class compressString{
    private static int countCompressedLength(String a){
        int consecutive=1;
        int finallength=0;
        for(int i=0;i<a.length();i++){
            if(i+1< a.length() && a.charAt(i) == a.charAt(i+1)){
                consecutive++;
            }else{
                finallength=finallength+1+(String.valueOf(consecutive).length());
                consecutive=1;
            }
        }
        return finallength;
    }
    public static String compress(String a){
        int compressLength=countCompressedLength(a);
        if(compressLength>=a.length())
            return a;
        int consecutive=1;
        StringBuilder b=new StringBuilder();
        for(int i=0;i<a.length();i++){
            if(i+1< a.length() && a.charAt(i) == a.charAt(i+1)){
                consecutive++;
            }else{
                b=b.append(a.charAt(i));
                b=b.append(consecutive);
                consecutive=1;
            }
        }
        return b.toString();
    }
    public static void main(String[] args) {
        String a="abcccccccccccccc";
        String b=compress(a);
        System.out.println(b);
    }
}