import java.util.*;
public class Palindrome{
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        for(int i=0 ; i<str.length() ; i++){
            for(int j=i+1 ; j<=str.length() ; j++){
                String s = str.substring(i, j);
                if(palindrome(s) == true){
                    System.out.println(s);
                }
            }
        }
    }
    public static boolean palindrome(String s){
        int i = 0;
        int j = s.length() - 1;

        char c1 = s.charAt(i);
        char c2 = s.charAt(j);

        if(c1 != c2){
            return false;
        }

        i++;
        j--;
        
        return true;
    }
}