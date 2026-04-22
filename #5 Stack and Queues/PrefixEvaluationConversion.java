import java.io.*;
import java.util.*;
public class PrefixEvaluationConversion{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> VS = new Stack<>();
        Stack<String> IS = new Stack<>();
        Stack<String> PS = new Stack<>();

        for(int i = exp.length() - 1 ; i>=0 ; i--){
            char c = exp.charAt(i);

            if(c == '+' || c == '-' || c == '*' || c == '/'){
            
                int VSv1 = VS.pop();
                int VSv2 = VS.pop();
                int VSv = operation(VSv1 , VSv2 , c);
                VS.push(VSv);

                String ISv1 = IS.pop();
                String ISv2 = IS.pop();
                String ISv = "(" + ISv1 + c + ISv2 + ")";
                IS.push(ISv);

                String PSv1 = PS.pop();
                String PSv2 = PS.pop();
                String PSv = PSv1 + PSv2 + c;
                PS.push(PSv);



            }
            else{
                VS.push(c - '0');
                PS.push(c + "");
                IS.push(c + "");
            }
        }

        System.out.println(VS.peek());
        System.out.println(IS.pop());
        System.out.println(PS.pop());

        
         
    }

    public static int operation(int v1 , int v2 , char c){
        int val = 0;
        if(c == '+'){
            val = v1 + v2;
        }
        else if(c == '-'){
            val = v1 - v2;
        }
        else if (c == '*'){
            val = v1 * v2;
        }
        else if( c == '/'){
            val = v1 / v2;
        }
        return val;
    }
}