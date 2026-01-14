import java.util.*;
public class Permutation{
    public static void display(int n , int r , int npr){
        System.out.println(n + " P " + r + " = " + npr);
    }
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();

        int npr = permutation(n , r);
        display(n , r , npr);
    }

    public static int permutation(int n , int r){
        if(r>n) return 0;
        
        else{
        int nfact = factorial(n);
        int s = n-r;
        int sfact = factorial(s);
        int p = nfact/sfact;
        return p;
        }
    }

    public static int factorial(int n){
        int x = 1;
        for(int i=2 ; i<=n ; i++){
            x = x*i;
        }
        return x;
    }
}