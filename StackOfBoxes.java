import java.util.ArrayList;
import java.util.Collections;

class Box implements Comparable<Box>{
    public int length;
    public int width;
    public int height;
    public int area;
    public Box(int length,int width,int height){
        if(length > width){
            this.length=length;
            this.width=width;
        }else{
            this.length=width;
            this.width=length;
        }
        this.height=height;
        this.area=length*width;
    }
    public boolean canBePlacedOn(Box a){
        return this.area < a.area;
    }
    @Override
    public String toString(){
        return this.height+","+this.width+","+this.length;
    }
    @Override
    public int compareTo(Box a) { 
        return a.area - this.area; 
    } 
}
public class StackOfBoxes{
    public static int maxStackWithBase(ArrayList<Box> boxList, int index){
        int maxHeight=0;
        Box base=boxList.get(index);
        for(int i=index+1;i<boxList.size();i++){
            if(boxList.get(i).canBePlacedOn(base)){
                int height=maxStackWithBase(boxList,i);
               // System.out.println("base-->"+base+",box-->"+boxList.get(i));
                maxHeight=Math.max(height, maxHeight);
            }
        }
        maxHeight=base.height+maxHeight;
        return maxHeight;
    }
    public static ArrayList<Box> generateNewList(ArrayList<Box> boxList){
        ArrayList<Box> newList=new ArrayList<Box>();
        for(int i=0;i<boxList.size();i++){
            Box box=boxList.get(i);
            newList.add(box);
            newList.add(new Box(box.length,box.height,box.width));
            newList.add(new Box(box.width,box.height,box.length));
        }
        Collections.sort(newList);
        for(int i=0;i<newList.size();i++)
            System.out.println(newList.get(i));
        return newList;
    }
    public static int maxStackHeight(ArrayList<Box> boxList){
        int maxHeight=0;
        ArrayList<Box> newList=generateNewList(boxList);
        for(int i=0;i<newList.size();i++){
            int height=maxStackWithBase(newList,i);
            //System.out.println("Height with base-->"+newList.get(i)+"is-->"+height);
            maxHeight=Math.max(height, maxHeight);
        }
        return maxHeight;
    }
    public static void main(String[] args) {
        ArrayList<Box> boxList=new ArrayList<Box>();
        boxList.add(new Box(6,7,4));
        boxList.add(new Box(2,3,1));
        boxList.add(new Box(5,6,4));
        boxList.add(new Box(12,32,10));
        int height=maxStackHeight(boxList);
        System.out.println(height);
    }
}