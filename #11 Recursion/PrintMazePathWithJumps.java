import java.util.*;
public class PrintMazePathWithJumps {
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        printMazePathJumps(1, 1 , n , m , "");
    }    

    public static void printMazePathJumps(int sr , int sc , int dr , int dc , String path){
        if(sr==dr && sc==dc){
            System.out.print(path + "\t");
            return;
        }

        for(int ms=1 ; ms<=dr-sr ; ms++){
            printMazePathJumps(sr+ms , sc , dr , dc , path + "h" + ms);
        }

        for(int ms=1 ; ms<=dc-sc ; ms++){
            printMazePathJumps(sr , sc+ms , dr , dc , path + "v" + ms);
        }

        for(int ms=1 ; ms<=dc-sc && ms<=dr-ms ; ms++){
            printMazePathJumps(sr+ms , sc+ms , dr , dc , path + "d" + ms);
        }

    }
}
