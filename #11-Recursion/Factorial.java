import java.util.*;
public class Factorial{
    public static void main(String[] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int nf = factorial(n);
        System.out.println(nf);
    }

    public static int factorial(int n){
        if(n==1){
            return 1;
        }
        
        int nfm1 = factorial(n-1);
        int nf = n * nfm1;
        return nf;
    } 
}
