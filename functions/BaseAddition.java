import java.util.*;
public class BaseAddition{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int b = scn.nextInt();

        int sum =  baseaddition(n1 , n2 , b);
        System.out.println(sum);
    } 

    public static int baseaddition(int n1 , int n2 , int b){
        int rv = 0;
        int c = 0;
        int p = 1;
        
        while(n1 != 0  || n2 != 0  || c != 0){
            int r1 = n1%10;
            int r2 = n2%10;

            int r = r1 + r2 + c;
            c = r/b;
            r = r%b;

            rv += r*p;
            p*=10;

            n1 = n1/10;
            n2 = n2/10;
        }
        return rv;
    }
}