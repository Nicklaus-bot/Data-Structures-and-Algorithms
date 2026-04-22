import java.util.*;
public class FloodFill{
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

        boolean [][] visited = new boolean[n][m];
        floodFill(arr , 0 , 0 , "" , visited);
    }

    public static void floodFill(int [][] arr , int row , int col , String path , boolean [] [] visited){
        if(row<0 || col<0 || row==arr.length || col==arr[0].length || arr[row][col] == 1 || visited[row][col] == true){
            return;
        }

        if(row == arr.length-1 && col == arr[0].length-1){
            System.out.println(path);
            return;
        }

        visited[row][col] = true;
        floodFill(arr , row + 1 , col , path + " d " , visited);
        floodFill(arr , row , col + 1 , path + " r " , visited);
        floodFill(arr , row - 1 , col , path + " u " , visited);
        floodFill(arr , row , col - 1 , path + " l " , visited);
        visited[row][col] = false;
    }
}