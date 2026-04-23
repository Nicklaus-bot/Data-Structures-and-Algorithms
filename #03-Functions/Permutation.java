import java.util.*;
public class Permutation{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int nfac = factorial (n);
        int nmrfac = factorial (n-r);
        int npr = nfac/nmrfac;
        System.out.println(n + " P " + r + " = " + npr);
    }


    public static int factorial ( int n){
        int rv = 1;
        for(int i = 1 ; i<=n ; i++){
            rv = rv*i;
        }
        return rv;
    }
}