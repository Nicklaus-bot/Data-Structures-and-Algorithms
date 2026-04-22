import java.util.*;
public class BaseToDecimal{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int btd = basetodecimal( n , b );
        System.out.print(btd);
    }

    public static int basetodecimal( int n , int b){
        int rv = 0;
        int x = 1;
        while(n!=0){
            int r = n%10;
            n = n/10;
            rv = rv + r*x;
            x = x*b;
        }

        return rv;
    }
}