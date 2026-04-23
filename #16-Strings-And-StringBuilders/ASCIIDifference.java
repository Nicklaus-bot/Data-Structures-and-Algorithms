import java.util.*;
public class ASCIIDifference{
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        ASCIIDiff(str);
    }

    public static void ASCIIDiff(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));

        for(int i=1 ; i<str.length() ; i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);

            int gap = curr - prev;

            sb.append(gap);
            sb.append(curr);
        }

        sb.toString();
        System.out.println(sb);
    }
}