import java.util.*;
public class PrintEncodings{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        printEncodings(str , "");

    }

    public static void printEncodings(String ques , String ans){
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }
        else if(ques.length() == 1){
            char ch = ques.charAt(0);
            if(ch == '0'){
                return;
            }
            else{
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                System.out.println(ans + code);
                return;
            }
        }
        else{
            char ch = ques.charAt(0);
            String roq = ques.substring(1);

            if(ch == '0'){
                return;
            }
            else{
                int chv = ch - '0';
                char code = (char)('a' + chv - 1);
                printEncodings(roq , ans + code);
            }

            String c12 = ques.substring(0 , 2);
            String roq12 = ques.substring(2);

            int c12v = Integer.parseInt(c12);
            if(c12v <= 26){
                char code = (char)('a' + c12v - 1);
                printEncodings(roq12 , ans + code);
            }


        }
    }
}