import java.util.*;
public class StringPermutations{
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        permutations(str);
    }
    public static void permutations(String str){
        int f = factorial(str.length());
        int n = str.length();

        for(int i=0 ; i<f ; i++){
            StringBuilder sb = new StringBuilder(str);
            int temp = i;

            for(int div=n ; div>=1 ; div--){
                int q = temp / div;
                int r = temp % div;

                System.out.print(sb.charAt(r));
                sb.deleteCharAt(r);
            }
            System.out.println();
        }
    }

    public static int factorial(int n){
        int val = 1;
        for(int i=2 ; i<=n ; i++){
            val *= i;
        }
        return val;
    }
}