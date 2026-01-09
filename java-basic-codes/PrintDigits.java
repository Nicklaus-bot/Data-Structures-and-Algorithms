import java.util.*;
public class PrintDigits{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int x = n;

        int nod = 0;
        while(x != 0){
            x = x/10;
            nod++;
        }

        int div = (int)Math.pow(10 , nod - 1);
        while(div!=0){
            int a = n/div;
            System.out.println(a);
            n = n%div;
            div = div/10;
        }
    }
}