public class PaintColor{
    public enum Color{
        RED,BLUE,GREEN,YELLOW;
    };
    public static void paintHelper(Color[][] screen,int r,int c,Color ocolor,Color ncolor){
        //System.out.println(r+","+c+","+screen[r][c]);
        if(r<0 || r >= screen.length || c<0 || c>=screen.length || screen[r][c] != ocolor){
            return;
        }
        screen[r][c] = ncolor;
        paintHelper(screen, r+1, c, ocolor, ncolor);
        paintHelper(screen, r-1, c, ocolor, ncolor);
        paintHelper(screen, r, c+1, ocolor, ncolor);
        paintHelper(screen, r, c-1, ocolor, ncolor);
    }
    public static void paint(Color[][] screen,int r,int c,Color ncolor){
        paintHelper(screen, r, c, screen[r][c], ncolor);
    }
    public static void main(String[] args) {
        Color[][] screen={{Color.RED,Color.BLUE,Color.RED,Color.BLUE},
        {Color.GREEN,Color.RED,Color.RED,Color.RED},
        {Color.BLUE,Color.GREEN,Color.RED,Color.GREEN},
        {Color.BLUE,Color.RED,Color.RED,Color.GREEN}};
        System.out.println("BEFORE PAINTING================");
        for(int i=0;i<screen.length;i++){
            for(int j=0;j<screen.length;j++){
                System.out.print(screen[i][j]+",");
            }
            System.out.println();
        }
        System.out.println("AFTER PAINTING==================");
        paint(screen, 1, 1, Color.YELLOW);
        for(int i=0;i<screen.length;i++){
            for(int j=0;j<screen.length;j++){
                System.out.print(screen[i][j]+",");
            }
            System.out.println();
        }
    }
}