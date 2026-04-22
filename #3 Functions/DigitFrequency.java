import java.util.*;
public class DigitFrequency{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int df = digitfrequency(n , d);
        System.out.print(df);
    }

    public static int digitfrequency(int n , int d){
       int rv = 0;
        while(n!=0){
            int r=n%10;
            n = n/10;
            if(r==d){
                rv++;
            }
        }
        return rv;
    }
}