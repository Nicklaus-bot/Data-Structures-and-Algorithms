import java.util.*;
public class ToggleCase{
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        toggleCase(str);
    }

    public static void toggleCase(String str){
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<str.length() ; i++){
            char c = str.charAt(i);

            if(c >= 'a' && c<= 'z'){
                int uc = 'A' + c - 'a';
                sb.append((char)uc);
            }
            else if(c >= 'A' && c<= 'Z'){
                int lc = 'a' + c - 'A';
                sb.append((char)lc);
            }
        }
        sb.toString();
        System.out.println(sb);
    }
}