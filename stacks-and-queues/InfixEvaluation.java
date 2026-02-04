import java.io.*;
import java.util.*;
public class InfixEvaluation{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String exp = br.readLine();

        Stack<Integer> operand = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for(int i=0 ; i<exp.length() ; i++){
            char c = exp.charAt(i);

            if(c == '('){
                operator.push(c);
            }
            else if(c == ')'){
                while(operator.peek() != '('){
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    char op = operator.pop();
                    int val = ops(v1 , v2 , op);
                    operand.push(val);
                }
                operator.pop();
            }
            else if(c=='/' || c=='*' || c=='-' || c=='+'){
                while(!operator.isEmpty() && precedence(c)<=precedence(operator.peek()) && operator.peek() != '('){
                    int v2 = operand.pop();
                    int v1 = operand.pop();
                    char op = operator.pop();
                    int val = ops(v1 , v2 , op);
                    operand.push(val);
                }
                operator.push(c);
            }
            else if(Character.isDigit(c)){
                operand.push(c - '0');
            }
        }

        while(!operator.isEmpty()){
            int v2 = operand.pop();
            int v1 = operand.pop();
            char op = operator.pop();
            int val = ops(v1 , v2 , op);
            operand.push(val);
        }

        System.out.println(operand.pop());
    }

    public static int precedence(char c){
        if(c=='/' || c=='*'){
            return 2;
        }
        else if(c=='-' || c=='+'){
            return 1;
        }
        else{
            return 0;
        }
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