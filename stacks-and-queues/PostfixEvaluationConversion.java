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
                int val2 = val.pop();
                int val1 = val.pop();
                int vval = ops(val1 , val2 , c);
                val.push(vval);

                String inval2 = infix.pop();
                String inval1 = infix.pop();
                String vinval = '(' + inval1 + c + inval2 + ')';
                infix.push(vinval);

                String pre2 = pre.pop();
                String pre1 = pre.pop();
                String vpre = c + pre1 + pre2;
                pre.push(vpre);
            }
            else{
                pre.push(c + "");
                infix.push(c + "");
                val.push(c - '0');
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
