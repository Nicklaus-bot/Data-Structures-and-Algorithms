import java.util.*;
public class CountingTriangle{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int x = 1;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<=i ; j++){
                System.out.print(x + "\t");
                x++;
            }
            System.out.println();
        }
    }
}