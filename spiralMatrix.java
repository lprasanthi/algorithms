import java.util.ArrayList;
import java.util.List;

public class spiralMatrix{
    public static List<Integer> spiralOrder(int[][] matrix) {
       List<Integer> list=new ArrayList<Integer>();
       if(matrix.length == 0){
            return list;
       }
        // for(int i=0;i<=n/2;i++){
        //     for(int j=i;j<=m-i;j++){
        //         //System.out.println(matrix[i][j]);
        //         list.add(matrix[i][j]);
        //     }
        //     for(int j=i+1;j<n-i;j++){
        //         list.add(matrix[j][m-i]);
        //     }
        //     for(int j=m-i;j>i && (n-1)>i;j--){
        //         list.add(matrix[n-i][j]);
        //     }
        //     for(int j=n-i;j>i;j--){
        //         list.add(matrix[j][i]);
        //     }
        // }
        // return list;
        int rowBegin=0,rowEnd=matrix.length-1;
        int colBegin=0,colEnd=matrix[0].length-1;

        while(rowBegin<=rowEnd && colBegin<=colEnd){
            for(int j=colBegin;j<=colEnd;j++){
                list.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            for(int j=rowBegin;j<=rowEnd;j++){
                list.add(matrix[j][colEnd]);
            }
            colEnd--;
            if(rowBegin <= rowEnd){
                for(int j=colEnd;j>=0;j--){
                    list.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            if(colBegin <= colEnd){
                for(int j=rowEnd;j>=rowBegin;j--){
                    list.add(matrix[j][colBegin]);
                }
                colBegin++;
            }
        }

        return list;
    }


    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix1={{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2={{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        int[][] matrix3={{1},{2},{3}};
        List<Integer> list=spiralOrder(matrix3);
        for(Integer i : list){
            System.out.println(i);
        }
    }
}