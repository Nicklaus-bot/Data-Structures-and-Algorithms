import java.io.*;
import java.util.*;
public class DuplicateBrackets {
    public static void main(String[]args) throws Exception{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Character> st = new Stack<>();

        for(int i=0 ; i<exp.length() ; i++){
            char c = exp.charAt(i);

            if(c == ')'){
                if(st.peek() == '('){
                    System.out.println("True");
                    return;
                }
                else{
                    while(st.peek() != '('){
                        st.pop();
                    }
                    st.pop();
                }
            }
            else{
                st.push(c);
            }
        }
        System.out.println("False");
        
    }    
}
