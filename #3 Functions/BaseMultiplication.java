 import java.util.*;
 public class BaseMultiplication{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int prd = product(b , n1 , n2);
        System.out.print(prd);
             }

    public static int product( int b , int n1 , int n2){
        int rv = 0;
        int p = 1;
        while(n2>0){
            int d = n2%10;
            n2 = n2/10;
            int sprd = prdone( b , n1 , d);
            rv = sum(b , rv , sprd*p );
            p = p*10;

        }
        return rv;
    }

    public static int prdone( int b , int n1 , int d){
        int rv = 0;
        int c = 0;
        int p = 1;
        while( n1>0 || c > 0 ){
            int d1 = n1%10;
            n1 = n1/10;
            int x = d*d1 + c;
            c = x/b;
            int  nd = x%b;
            rv = rv + nd*p;
            p*=10;

        }
        return rv;

    }

    public static int sum( int b , int n1 , int n2){
        int rv = 0 ;
        int c = 0;
        int p = 1;
        while(n1>0 || n2>0 || c>0){
            int d1 = n1%10;
            int d2 = n2%10;
            n1 = n1/10;
            n2 = n2/10;
            int d = d1 + d2 + c;
                c= d/b;
                d = d%b;
            
            rv = rv + d*p;
            p = p*10;
        }
        return rv;
    }

 }