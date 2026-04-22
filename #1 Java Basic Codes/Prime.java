import java.util.*;
public class Prime {
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int count = 0;
        for(int div = 2 ; div*div <= n ; div++){
            int r = n%div;
            if(r==0){
                count++;
            }
        }
            if(count == 0 ){
                System.out.println(n + " is Prime");
            }
            else {
                System.out.println(n + " is not Prime");
            }
    }
}
