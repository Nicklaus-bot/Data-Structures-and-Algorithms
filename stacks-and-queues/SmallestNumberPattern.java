import java.io.*;
import java.util.*;
public class SmallestNumberPattern{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> st = new Stack<>();
        int num = 1;
        

        for(int i=0 ; i<exp.length() ; i++){
            char c = exp.charAt(i);
            st.push(num);
            num++;
            
            if(c == 'i'){
                st.push(num);
                num++;
                i++;

                while(!st.isEmpty()){
                    System.out.print(st.pop() + "\t");
                }
            }
        }    

        st.push(num);
        while(!st.isEmpty()){
            System.out.print(st.pop() + "\t");
        }
        
    }
}