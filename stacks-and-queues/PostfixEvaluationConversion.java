import java.io.*;
import java.util.*;
public class PostfixEvaluationConversion {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> val = new Stack<>();
        Stack<String> pre = new Stack<>();
        Stack<String> infix = new Stack<>();

        for(int i=0 ; i<exp.length() ; i++){
            char c = exp.charAt(i);

            if(c=='/' || c=='*' || c=='-' || c=='+'){
                //code here
            }
            else{
                //code here
            }
        }

        System.out.println(infix.pop());
        System.out.println(pre.pop());
        System.out.println(val.pop());

    }
    
    public static int ops(int v1 , int v2 , char c){
        int val = 0;
        if(c == '/'){
            val = v1 / v2;
        }
        else if(c == '*'){
            val = v1 * v2;
        }
        else if(c == '-'){
            val = v1 - v2;
        }
        else if(c == '+'){
            val = v1 + v2;
        }
        return val;
    }
}
