import java.util.*;
public class SpiralTraversal {
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int [] [] arr = new int [n][m];

        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        int minr = 0;
        int maxr = arr.length-1;
        int minc = 0;
        int maxc = arr[0].length-1;

        int val = m*n;
        int count = 0;


        while(count < val){
            for(int i=minr , j=minc ; i<=maxr && count<val ; i++){
                System.out.print(arr[i][j] + " ");
                count ++;
            }
            minc++;

            for(int i=maxr , j=minc ; j<=maxc && count<val ; j++){   
                System.out.print(arr[i][j] + " ");
                count++;
            }
            maxr--;

            for(int i=maxr, j=maxc ; i>=minr  && count<val; i--){
                System.out.print(arr[i][j] + " ");
                count++;
            }
            maxc--;

            for(int i=minr, j=maxc; j>=minc && count<val ; j--){
                System.out.print(arr[i][j] + " ");
                count++;
            }
            minr++;

        }

    }    
}
