public class containerMostWater{
    public static int getMaxArea(int[] height){
        int area=0;
        int i=0,j=height.length-1,previ=0,prevj=height.length-1;
        while(j>0){
            while(height[j]<height[prevj] && j>0){
                j--;
            }
            while(i<j){
                if(height[i] >= height[previ]){
                    int tempArea= Math.min(height[i],height[j])*(j-i);
                    //System.out.println("entered i loop "+tempArea);
                    if(tempArea > area){
                        //System.out.println("i "+i+" j "+j+" area "+tempArea);
                        previ=i;
                        area=tempArea;
                    }         
                }
                i++;
            }
            i=previ;
            prevj=j;
            j--;
            //System.out.println("area "+area+" j "+j+" prevj "+prevj+" previ "+previ);
        }
        return area;  
    }
    public static int maxAreaOptimal(int[] height){
        int i=0,j=height.length-1;
        int area=0;
        while(i<j){
            area= Math.max(area,Math.min(height[i],height[j])*(j-i));
            if(height[i]<height[j])
                i++;
            else
                j--;
        }
        return area;
    }
    public static void main(String[] args) {
        int height[]={5,2,12,1,5,3,4,11,9,4};
        System.out.println(maxAreaOptimal(height));
    }
}