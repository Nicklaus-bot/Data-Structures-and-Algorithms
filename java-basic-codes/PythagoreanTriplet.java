import java.util.*;
public class PythagoreanTriplet{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        int b = scn.nextInt();
        int c = scn.nextInt();

        int max = a;
        if(b >= max){
            max = b;
        }
        if(c >= max){
            max = c;
        }

        if(max == a){
            boolean val  = ((b*b)+(c*c)==(a*a));
            System.out.println(val);
        }
        else if(max == b){
            boolean val = ((a*a)+(c*c)==(b*b));
            System.out.println(val);
        }
        else if(max == c){
            boolean val = ((a*a)+(b*b)==(c*c));
            System.out.println(val);
        }
    }
}