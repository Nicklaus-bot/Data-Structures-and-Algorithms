import java.util.*;
public class PrintSubsequence{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String ques = scn.next();

        printSS(ques , "");
    }

    public static void printSS(String ques , String ans){
        if(ques.length() == 0){
            System.out.print(ans + "\t");
            return;
        }
        char c = ques.charAt(0);
        String roq = ques.substring(1);

        printSS(roq , ans+"");
        printSS(roq , ans+c);

    }
}