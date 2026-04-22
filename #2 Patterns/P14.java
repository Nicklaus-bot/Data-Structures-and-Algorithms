import java.util.*;
public class P14{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int x = 1;

        for(int i=1; i<=10; i++){
            System.out.println(n  + " * " + x + " = " + n*x);
            x++;
        }

    }
}