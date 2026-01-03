import java.util.*;
public class PrimeNumbersInRange{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();

        for(int i=a ; i<=b ; i++){
            if(i<=1){
                continue;
            }
            int count = 0;
            for(int div=2 ; div*div<=i ; div++){
                if(i%div==0){
                    count++;
                    break;
                }
            }
            if(count==0){
                System.out.println(i);
            }
        }
    }
}