import java.util.*;
public class DecimalToBase{
    public static void main(String[]aegs){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dtb = decimaltobase( n , b);
        System.out.print(dtb);

    }

    public static int decimaltobase( int n , int b){
        int rv = 0;
        int x = 1;
        while(n!=0){
            int r = n%b;
            n = n/b;
            rv = rv + r*x;
            x*=10;
                }

        return rv;
    }
}