import java.util.*;
public class PrintZigZag{
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        pzz(n);
    }

    public static void pzz(int n){
        if(n==0){
            return;
        }

        System.out.println("Pre " + n);
        pzz(n-1);
        System.out.println("In " + n);
        pzz(n-1);
        System.out.println("Post " + n);
    }
}
