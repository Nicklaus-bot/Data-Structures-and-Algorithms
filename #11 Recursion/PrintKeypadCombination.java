import java.util.*;
public class PrintKeypadCombination{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String n = scn.next();

        printKPC(n , "");
    }

    public static String[] codes = {"!;" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tu" , "vwx" , "yz"};

    public static void printKPC(String ques , String ans){
        if(ques.length() == 0){
            System.out.print(ans + "\t");
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);

        String code = codes[ch - '0'];
        for(int i=0 ; i<code.length() ; i++){
            char co = code.charAt(i);
            printKPC(roq , ans+co);
        }
    }

}