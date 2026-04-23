import java.util.*;
public class Inverse{
    public static void main(String[]args){

        Scanner scn = new Scanner(System.in);
        int n =scn.nextInt();
        int rn = 0;
        int c = 1;
        while(n!=0){
            int r = n%10;
            rn = rn + c*(int)Math.pow(10, r-1);
            c++;
            n=n/10;
        }

        System.out.println(rn);



    }
}
