import java.util.*;
public class Triangle4{
    public static void main(String[]args) throws Exception{
        Scanner scn = new  Scanner(System.in);
        int n = scn.nextInt();
        int sp = n-1;
        int st = 1;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<sp ; j++){
                System.out.print("\t");
            }
            for(int j=0 ; j<st ; j++){
                System.out.print("*\t");
            }

            System.out.println();
            sp--;
            st++;
        }
    }
}