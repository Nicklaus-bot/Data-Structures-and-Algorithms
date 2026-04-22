import java.util.*;
public class PrintMazePath {
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        printMazePath(1 , 1 , n , m , "");
    }    

    public static void printMazePath(int sr , int sc , int dr , int dc , String path){
        if(sr>dr || sc>dc){
            return;
        }
        else if(sr==dr && sc==dc){
            System.out.print(path + "\t");
            return;
        }

        printMazePath(sr+1 , sc , dr , dc , path + "v");
        printMazePath(sr , sc+1 , dr , dc , path + "h");

    }
}
