import java.util.*;
public class Digits{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int x = n;
        int nod = 0;
        while(x!=0){
            x=x/10;
            nod++;
        }
        int pow = (int)Math.pow(10, nod-1);
        while(pow!=0){
            int q = n/pow;
            System.out.println(q);
            n = n%pow;
            pow = pow/10;

        }
    }
}