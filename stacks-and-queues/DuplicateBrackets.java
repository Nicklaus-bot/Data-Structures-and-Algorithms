import java.util.*;
public class DuplicateBrackets {
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String exp = scn.nextLine();

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
