import java.io.*;
import java.util.*;
public class BalancedBrackets{
    public static void main(String[]args) throws Exception{

        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        Stack<Character> st = new Stack <> ();

        for(int i=0 ; i<str.length() ; i++){
            char c = str.charAt(i);
            if(c == '(' || c == '{'  ||  c == '['){
                st.push(c);
            }
            else if(c == ')'){
                boolean val = Closing( st  , '(');
                if(val == false ){
                    System.out.println(val);
                    return;
                }
            }
            else if(c == '}'){
                boolean val = Closing( st  , '{');
                if(val == false ){
                    System.out.println(val);
                    return;
                }
            }
            else if(c == ']'){
                boolean val = Closing( st  , '[');
                if(val == false ){
                    System.out.println(val);
                    return;
                }
            }
        }
        if(st.size() == 0){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }

    public static boolean Closing(Stack<Character> st  , char c){
        if(st.size() == 0  ){
            return false;
        }
        else if (st.peek() != c ){
            return false;
        }
        else {
            st.pop();
            return true;
        }
    }
}