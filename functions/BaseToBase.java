import java.io.*;
import java.util.*;
public class BaseToBase{
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b1 = scn.nextInt();
        int b2 = scn.nextInt();

        int btd = basetodecimal(n , b1);
        int dtb = decimaltobase(btd , b2);
        int btb = dtb;
        System.out.println(btb);
    }

    public static int basetodecimal(int n , int b){

    }

    public static int decimaltobase(int n , int b){

    }
    
}