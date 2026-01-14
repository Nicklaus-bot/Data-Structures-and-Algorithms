import java.util.*;
public class NumberPattern2 {
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int st = 1;
        int sp = 2*n/2 + 1;

        int x = 1;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<st ; j++){
                System.out.print(x + "\t");
                x++;
            }
            for(int j=0 ; j<sp ; j++){
                System.out.print("\t");
            }
            if(i==n-1){
                st--;
                x--;
            }
            for(int j=0 ; j<st ; j++){
                x--;
                System.out.print( x + "\t");
            }

            sp-=2;
            st++;
            System.out.println();
        }
    }    
}
