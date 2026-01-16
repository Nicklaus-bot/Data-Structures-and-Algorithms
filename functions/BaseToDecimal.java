import java.util.*;
public class BaseToDecimal {
    public static void main(String [] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();

        int btd = basetodecimal(n , b);
        System.out.println("Base to decimal is " + btd);
    }    

    public static int basetodecimal(int n , int b){
        int rv = 0;
        int p = 1;
        while(n!=0){
            int r = n%10;
            rv += r*p;
            p *= b;
            n = n/10;
        }
        return rv;
    }
}
