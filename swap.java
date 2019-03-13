public class swap{
    public static void main(String[] args) {
        int a=1500,b=2000;
        System.out.println(a+","+b);
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println(a+","+b);
    }
}