import java.util.*;
public class StringsBasics{
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);

        String s1 = scn.nextLine();

        System.out.println(s1.length());

        for(int i=0 ; i<s1.length() ; i++){
            char c = s1.charAt(i);
            System.out.println(c);
        }

        System.out.println(s1.substring(0,  1));

        System.out.println(s1.substring(2));

        s1 += "x";
        s1 += "y";

        System.out.println(s1);

        



    }
}