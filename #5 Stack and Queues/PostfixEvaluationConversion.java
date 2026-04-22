import java.io.*;
import java.util.Stack;
public class PostfixEvaluationConversion{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> VS = new Stack<>();
        Stack<String> IS = new Stack<>();
        Stack<String> PS = new Stack<>();

        for(int i=0 ; i<exp.length() ; i++){
            char c = exp.charAt(i);
            
            if(c == '+' || c == '-' || c == '*' || c == '/'){
                int VSv2 = VS.pop();
                int VSv1 = VS.pop();
                int VSval = operation(VSv1 , VSv2 , c);
                VS.push(VSval);

                String ISv2 = IS.pop();
                String ISv1 = IS.pop();
                String ISv = "(" + ISv1 + c  + ISv2 + ")";
                IS.push(ISv);

                String PSv2 = PS.pop();
                String PSv1 = PS.pop();
                String PSv = c + PSv1 + PSv2;
                PS.push(PSv);

            }
            else{
                VS.push(c - '0');
                IS.push(c + "");
                PS.push(c + "");
            }
        }

        System.out.println(VS.pop());
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
        else if(c == '/'){
            val = v1 / v2;
        }
        else if(c == '*'){
            val = v1 * v2;
        }
        return val;
    }
}