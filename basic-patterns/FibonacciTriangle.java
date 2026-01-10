import java.util.*;
public class FibonacciTriangle{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int x=0; 
        int y=1;

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<=i ; j++){
                System.out.print(x + "\t");
                int z = x+y;
                x=y;
                y=z;
            }
            System.out.println();
        }
    }
}
