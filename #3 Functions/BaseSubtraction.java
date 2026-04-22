import java.util.*;
public class BaseSubtraction{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int sub = subtraction( b , n1 , n2);
        System.out.println(sub);


    }

    public static int subtraction(int b , int n1 , int n2){
        int rv = 0;
        int c = 0;
        int p = 1;
        while(n1!=0){
            int r1 = n1%10;
            int r2 = n2%10;
            n1 = n1/10;
            n2 = n2/10;
            r1 = r1 - c;
            if(r1<r2){
            r1 = r1 + b  ;
            c = 1;
            }
            else {
                c = 0;
            }
            int r = r1 - r2;
            rv = rv + r*p;
            p*=10;
        }

        return rv;
    }
}