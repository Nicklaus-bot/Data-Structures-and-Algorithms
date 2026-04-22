import java.io.*;
import java.util.*;
public class InfixConversion{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Character> Operator = new Stack<>();
        Stack<String> Postfix = new Stack<>();
        Stack<String> Prefix = new Stack<>();

        for(int i=0 ; i< exp.length() ; i++){
            char c = exp.charAt(i);

            if(c == '('){
                Operator.push(c);
            }
            else if(c == '+' || c == '-' || c == '*' || c == '/' ){
                while(Operator.size() > 0  &&  precedence(c) <= precedence(Operator.peek())  &&   Operator.peek() != '('){
                    char op = Operator.pop();
                    
                    String postv2 = Postfix.pop();
                    String postv1 = Postfix.pop();
                    String post = postv1 + postv2 + op;
                    Postfix.push(post);

                    String prev2 = Prefix.pop();
                    String prev1 = Prefix.pop();
                    String pre = op + prev1 + prev2;
                    Prefix.push(pre);
                }
                Operator.push(c);

            }
            else if( c == ')'){
                while(Operator.peek()!='('){
                    char op = Operator.pop();
                    
                    String postv2 = Postfix.pop();
                    String postv1 = Postfix.pop();
                    String post = postv1 + postv2 + op;
                    Postfix.push(post);

                    String prev2 = Prefix.pop();
                    String prev1 = Prefix.pop();
                    String pre = op + prev1 + prev2;
                    Prefix.push(pre);
                }
                Operator.pop();
            }

            else if((c>='a' && c<='z')  ||  (c>='0'  &&  c<='9')  || (c>='A' && c<='Z')) {
                Postfix.push(c + "");
                Prefix.push(c + "");
            }
        }

        while(Operator.size() > 0 ){
            char op = Operator.pop();
                    
                    String postv2 = Postfix.pop();
                    String postv1 = Postfix.pop();
                    String post = postv1 + postv2 + op;
                    Postfix.push(post);

                    String prev2 = Prefix.pop();
                    String prev1 = Prefix.pop();
                    String pre = op + prev1 + prev2;
                    Prefix.push(pre);
        }

        System.out.println(Prefix);
        System.out.println(Postfix);
        }

        public static int precedence(char c){
            if(c=='+' || c=='-'){
                return 1;
            }
            else if(c=='*' || c=='/'){
                return 2;
            }
            else{
                return 0;
            }
        } 
    }