import java.util.*;
public class PrimeFactorization {
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

            for(int div=2 ; div*div<=n ; div++){
                while(n%div == 0){
                    System.out.println(div);
                    n = n/div;
                }
            }
            if(n!=1){
                    System.out.println(n);
                }
        }
    }    