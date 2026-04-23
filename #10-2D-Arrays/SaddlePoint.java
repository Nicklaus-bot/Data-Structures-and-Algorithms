import java.util.*;
public class SaddlePoint {
    public static void main(String[]args) throws Exception{
        Scanner scn = new  Scanner(System.in);
        int n = scn.nextInt();
        int [][] arr = new int [n][n];
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                arr[i][j] = scn.nextInt();
            }
        }

        for(int i=0 ; i<arr.length ; i++){
            int minj = 0;
            for(int j=0 ; j<arr[0].length ; j++){
                if(arr[i][j] < arr[i][minj]){
                    minj = j;
                }
            }

            boolean flag = true;
            for(int k=0 ; k<arr.length ; k++){
                if(arr[k][minj] > arr[i][minj]){
                    flag = false;
                    break;
                }
            }
            if(flag == true){
                    System.out.println(arr[i][minj]);
                    return;
                }
        }
        System.out.println("No Saddle Point");

        


    }
}