import java.util.*;
public class Inverse{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int inv = 0;
        int pv = 1;
        while(n>0){
            int r = n%10;
            inv += pv*(int)Math.pow(10 , r - 1);
            n = n/10;
            pv++;
        }
        System.out.println(inv);
    }
}