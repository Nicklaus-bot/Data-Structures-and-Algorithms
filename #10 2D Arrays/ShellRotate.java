import java.util.*;
public class ShellRotate{
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int [] [] arr = new int [n][m];
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int s = scn.nextInt();
        int k = scn.nextInt();

        shellrotate(arr , s , k);
        display(arr);
    }

    public static void shellrotate (int [][] arr , int s , int k){
        int [] a = shellto1D(arr , s);
        rotate(a , k);
        oneDtoshell(a , arr , s);
    }

    public static int [] shellto1D(int [] [] arr , int s){
        int minr = s-1;
        int minc = s-1;
        int maxr = arr.length - s;
        int maxc = arr[0].length - s;

        int sz = 2*(maxr - minr + maxc - minc);
        int [] a = new int [sz];
        
        int idx = 0;

        for(int i=minr , j = minc ; i<=maxr ; i++){
            a[idx] = arr[i][j];
            idx ++;
        }

        for(int i=maxr , j = minc+1 ; j<=maxc ; j++){
            a[idx] = arr[i][j];
            idx ++;
        }

        for(int i=maxr-1 , j = maxc ; i>=minr ; i--){
            a[idx] = arr[i][j];
            idx++;
        }

        for(int i=minr , j=maxc-1 ; j>=minc+1 ; j--){
            a[idx] = arr[i][j];
            idx++;
        }

        return a;

    }

    public static void rotate(int [] arr , int k){
        k = k%arr.length;
        if(k<0){
            k += arr.length;
        }

        reverse(arr , 0 , arr.length - k - 1);
        reverse(arr , arr.length - k , arr.length - 1);
        reverse(arr , 0 , arr.length - 1);


    }

    public static void reverse(int [] arr , int le , int ri){ 
        while(le<=ri){
            int temp = arr[ri];
            arr[ri] = arr[le];
            arr[le] = temp;

            le++;
            ri--;
        }
    }
    
    public static void oneDtoshell(int [] arr, int [][] shell , int s){
        int minr = s - 1;
        int minc = s - 1;
        int maxr = shell.length - s;
        int maxc = shell[0].length - s;

        int sz = arr.length;

        int idx = 0;

        for(int i=minr , j=minc ; i<=maxr ; i++){
            shell[i][j] = arr[idx];
            idx++;
        }

        for(int i=maxr , j=minc+1 ; j<=maxc ; j++){
            shell[i][j] = arr[idx];
            idx++;
        }

        for(int i=maxr-1 , j=maxc ; i>=minr ; i--){
            shell[i][j] = arr[idx];
            idx ++;
        }

        for(int i=minr , j=maxc-1 ; j>=minc+1 ; j--){
            shell[i][j] = arr[idx];
            idx++;
        }

    }

    public static void display(int [] [] arr){
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }   
}