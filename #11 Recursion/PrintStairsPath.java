import java.util.*;
public class PrintStairsPath{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairsPath(n , "");
    }

    public static void printStairsPath(int n , String path){
        if(n<0){
            return;
        }
        else if(n==0){
            System.out.print(path + "\t");
            return;
        }

        printStairsPath(n-1 , path+"1");
        printStairsPath(n-2 , path+"2");
        printStairsPath(n-3 , path+"3");
    }
}