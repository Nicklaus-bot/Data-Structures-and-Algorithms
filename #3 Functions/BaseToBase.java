import java.util.*;
public class BaseToBase{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();
        int btd = basetodecimal( n , b1);
        int dtb = decimaltobase( btd , b2);
        int btb = dtb;
        System.out.print(btb);
    }
   
    public static int basetodecimal( int n , int b1){
        int rv = 0;
        int x = 1;
        while(n!=0){
            int r = n%10;
            n = n/10;
            rv = rv + r*x;
            x = x*b1;
        }
        return rv;
    }
    public static int decimaltobase( int n , int b2){
        int rv = 0;
        int x = 1;
        while(n!=0){
            int r = n%b2;
            n = n/b2;
            rv = rv + r*x;
            x = x*10;
        }
        return rv;
    }

}