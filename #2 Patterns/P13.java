import java.util.*;
public class P13{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
       
        for(int i =0 ; i<n; i++){
             int icj = 1;
            for(int j=0; j<=i ; j++){
                System.out.print(icj + "\t");
                int icjpo = icj*(i-j)/(j+1);
                icj = icjpo;
            }
            System.out.println();
        }
    }
}