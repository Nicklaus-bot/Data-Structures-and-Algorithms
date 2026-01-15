import java.util.*;
public class DigitFrequency{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d= scn.nextInt();

        int f = frequency(n , d);
        System.out.println("Digit Frequency is " + f);
    }

    public static int frequency(int n , int d){
        int count = 0;
        while(n>0){
            int r = n%10;
            if(d==r){
                count++;
            }
            n = n/10;
        }
        return count;
    }
}