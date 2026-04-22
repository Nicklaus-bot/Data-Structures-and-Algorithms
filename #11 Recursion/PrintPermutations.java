import java.util.*;
public class PrintPermutations{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        printPermutations(str , "");
    }

    public static void printPermutations(String str , String p){
        if(str.length() == 0){
            System.out.println(p);
            return;
        }

        for(int i=0 ; i<str.length() ; i++){
            char c = str.charAt(i);
            String lq = str.substring(0 , i);
            String rq = str.substring(i+1);
            String roq = lq + rq;
            printPermutations(roq , p + c);
        }
    }
}