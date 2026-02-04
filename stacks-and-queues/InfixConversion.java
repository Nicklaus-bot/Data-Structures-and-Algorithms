import java.io.*;
import java.util.*;
public class InfixConversion {
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();
        
        Stack<String> pre = new Stack<>();
        Stack<String> post = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i=0 ; i<exp.length() ; i++){
            char c = exp.charAt(i);

            if(c == '('){
                operator.push(c);
            }

            else if(c==')'){
                while(operator.peek() != '('){
                    char op = operator.pop();

                    String pre2 = pre.pop();
                    String pre1 = pre.pop();
                    String preval = op + pre1 + pre2;
                    pre.push(preval);

                    String post2 = post.pop();
                    String post1 = post.pop();
                    String postval = post1 + post2 + op;
                    post.push(postval);
                }
                operator.pop();
            }

            else if(c=='/' || c=='*' || c=='-' || c=='+'){
                while(!operator.isEmpty() && precedence(c)<=precedence(operator.peek()) && operator.peek()!='('){
                    char op = operator.pop();

                    String pre2 = pre.pop();
                    String pre1 = pre.pop();
                    String preval = op + pre1 + pre2;
                    pre.push(preval);

                    String post2 = post.pop();
                    String post1 = post.pop();
                    String postval = post1 + post2 + op;
                    post.push(postval);

                }
                operator.push(c);
            }

            else if((c>='a' && c<='z') || (c>='0' && c<='9') || (c>='A' && c<='Z')){
                pre.push(c + "");
                post.push(c + "");
            }
        }

        while(!operator.isEmpty()){
            char op = operator.pop();

            String pre2 = pre.pop();
            String pre1 = pre.pop();
            String preval = op + pre1 + pre2;
            pre.push(preval);

            String post2 = post.pop();
            String post1 = post.pop();
            String postval = post1 + post2 + op;
            post.push(postval);
        }

        System.out.println(pre.pop());
        System.out.println(post.pop());

    } 
    public static int precedence(char c){
        if(c == '/'  || c == '*'){
            return 2;
        }
        else if(c == '-'  || c == '+'){
            return 1;
        }
        else{
            return 0;
        }
    }   
}
