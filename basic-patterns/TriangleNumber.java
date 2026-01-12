import java.util.*;
public class TriangleNumber{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for(int i=0 ; i<n ; i++){
            int cij = 1;
            for(int j=0 ; j<=i ; j++){
                System.out.print(cij + "\t");
                int cijpo = cij*(i-j)/(j+1);
                cij = cijpo;
            }
            System.out.println();
        }
    }
}