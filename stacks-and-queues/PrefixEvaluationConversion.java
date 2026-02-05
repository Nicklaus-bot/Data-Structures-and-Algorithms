import java.io.*;
import java.util.*;
public class PrefixEvaluationConversion{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<String> infix = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Integer> val = new Stack<>();

        for(int i=exp.length() - 1 ; i>=0 ; i--){
            char c = exp.charAt(i);

            if(c=='/' || c=='*' || c=='-' || c=='+'){
                int val1 = val.pop();
                int val2 = val.pop();
                int vval = ops(val1 , val2 , c);
                val.push(vval);

                String v1 = infix.pop();
                String v2 = infix.pop();
                String inval = '(' + v1 + c + v2 + ')';
                infix.push(inval);

                String a1 = post.pop();
                String a2 = post.pop();
                String postval = a1 + a2 + c;
                post.push(postval);
            }
            else{
                infix.push(c + "");
                post.push(c + "");
                val.push(c - '0');
            }
        }

        System.out.println(infix.pop());
        System.out.println(post.pop());
        System.out.println(val.pop());
    }

    public static int ops(int v1 , int v2 , char c){
        int val = 0;
        if(c=='/'){
            val = v1/v2;
        }
        else if(c=='*'){
            val = v1*v2;
        }
        else if(c=='-'){
            val = v1-v2;
        }
        else if(c=='+'){
            val = v1+v2;
        }
        return val;
    }
}