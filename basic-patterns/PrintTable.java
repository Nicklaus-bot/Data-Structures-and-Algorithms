import java.util.*;
public class PrintTable{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int i=1 ; i<=10 ; i++){
            System.out.println(n + " * " + i + " = " + n*i);
        }
    }
}
