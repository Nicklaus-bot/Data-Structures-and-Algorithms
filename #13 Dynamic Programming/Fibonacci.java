import java.io.*;
public class Fibonacci{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int fib = fib(n);
        System.out.println(fib);

         int fibm = fibmemo(n , new int [n + 1]);
         System.out.println(fibm);
    }

    public static int fib(int n){
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }

        int fibm1 = fib(n - 1);
        int fibm2 = fib(n - 2);

        int fib = fibm1 + fibm2;
        return fib;
    }

    public static int fibmemo(int n , int [] qb){
        if(n==0){
            return 0;
        }
        else if(n==1){
            return 1;
        }
        else if(qb[n] != 0){
            return qb[n];
        }

        int fibm1 = fibmemo(n - 1 , qb);
        int fibm2 = fibmemo(n - 2 , qb);

        int fib = fibm1 + fibm2;
        qb[n] = fib;

        return fib;
    }
}