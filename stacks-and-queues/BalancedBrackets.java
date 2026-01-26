import java.io.*;
import java.util.*;
public class BalancedBrackets {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> st = new Stack<>();

        for(int i=0 ; i<str.length() ; i++){
            char c = str.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                st.push(c);
            }

            else if(c == ')'){
                boolean val = check(st , '(');
                if(val == false){
                    System.out.println(val);
                    return;
                }
            }

            else if(c == '}'){
                boolean val = check(st , '{');
                if(val == false){
                    System.out.println(val);
                    return;
                }
            }

            else if(c == ']'){
                boolean val = check(st , '[');
                if(val == false){
                    System.out.println(val);
                    return;
                }
            }
        }

        if(st.size() > 0){
            System.out.println("false");
        }
        else{
            System.out.println("true");
        }
        
    }    

    public static boolean check(Stack<Character> st , char c){
        if(st.size() == 0){
            return false;
        }
        else if(st.peek() != c){
            return false;
        }
        else{
            st.pop();
            return true;
        }
    }
}
