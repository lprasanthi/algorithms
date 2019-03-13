import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'buildSubsequences' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING s as parameter.
     */
    // private static List<String> getSubString(String s, int size){
    //     List<String> temp = new ArrayList<>();
    //     if(size == 1){
    //         for(int i=0;i<s.length();i++){
    //             temp.add(String.valueOf(s.charAt(i)));
    //         }
    //         return temp;
    //     }

    // }
    public static List<String> buildSubsequences(String s) {
    // Write your code here
        List<String> list = new ArrayList<>();
        char input[]=s.toCharArray();
        int n=s.length();
        for (int length = 0; length < n; length++) {  
            for (int start = 0; start < n - length; start++) {   
                int end = start + length; 
                char[] temp= new char[end+1];
                int index=0;
                for (int k = start; k <= end; k++) { 
                    temp[index]=input[k];
                    index++;
                }
                list.add(String.valueOf(temp));
            } 
        } 
        return list;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Result rs= new Result();
        List<String> list=Result.buildSubsequences("xyz");
        System.out.println(list);
    }
}
