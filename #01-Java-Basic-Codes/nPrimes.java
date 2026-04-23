import java.util.*;
public class nPrimes{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        for(int i=1; i<=t; i++){
        int n = scn.nextInt(); 
        int c = 0;
        for(int div = 2; div*div <=n ; div++){
            if(n%div==0){
                c++;
                break;
            }
        }
            if(c==0){
                System.out.println("Prime");
            }
            else{
                System.out.println("Not Prime");
            }
        }
    }
}