import java.util.*;
public class GCDLCM{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int x = n1;
        int y = n2;

        while(n2 != 0){
            int r = n1%n2;
            n1 = n2;
            n2 = r;
        }

        int GCD = n1;
        int LCM = (x*y)/GCD;
        System.out.println("Greates Common Divisor is " +  GCD);
        System.out.println("Lowest Common Factor is " +  LCM);
    }
}