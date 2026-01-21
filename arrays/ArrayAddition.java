import java.util.*;
public class ArrayAddition{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);

        int n1 = scn.nextInt();
        int [] arr1 = new int [n1];
        for(int i=0 ; i<arr1.length ; i++){
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int [] arr2 = new int [n2];
        for(int i=0 ; i<arr2.length ; i++){
            arr2[i] = scn.nextInt();
        }

        int [] sum = new int [Math.max(arr1.length , arr2.length)];

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = sum.length - 1;

        int c = 0;
        while(i>=0  || j>=0){
            int d1 = i>=0? arr1[i] : 0;
            int d2 = j>=0? arr2[j] : 0;
            int s = d1 + d2 + c;
            c = s/10;
            s = s%10;

            sum[k] = s;

            i--;
            j--;
            k--;
        }

        if(c>0){
            System.out.println(c);
        }

        for(int val : sum){
            System.out.println(val);
        }
        
    }
}