import java.util.*;
public class DecimalToBase {
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();

        int dtb = decimaltobase(n , b);
        System.out.println("Decimal to Base is " + dtb);
    }  

    public static int decimaltobase(int n ,int b){
        int rv = 0;
        int p=1;
        while(n>0){
            int r = n%b;
            rv += r*p;
            p *= 10;

            n = n/b;
        }
        return rv;
    }
}
