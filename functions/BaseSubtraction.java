import java.util.*;
public class BaseSubtraction{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int b = scn.nextInt();

        int diff = basesubtraction(n1 , n2 , b);
        System.out.println(diff);
    }

    public static int basesubtraction(int n1 , int n2 , int b){
        int rv = 0;
        int c = 0;
        int p = 1;

        while(n2>0){
            int r2 = n2%10;
            int r1 = n1%10;

            int r = r2 - r1 + c;
            if(r < 0){
                r = r+b;
                c = -1;
            }
            else{
                c = 0;
            }

            n2 = n2/10;
            n1 = n1/10;

            rv += r*p;
            p*=10;

        }

        return rv;
    }
}