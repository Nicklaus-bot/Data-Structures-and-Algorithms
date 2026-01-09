import java.util.*;
public class CountDigits{
    public static void main(String[]args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nod = 0;
        if(n==0){
            System.out.println("1");
            return;
        }
        while(n != 0){
            n = n/10;
            nod++;
        }

        System.out.println(nod);
    }
}