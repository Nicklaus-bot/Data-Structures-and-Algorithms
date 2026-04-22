import java.util.*;
public class NQueens{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int [][] chess = new int [n][n];

        nQueens(chess , "" , 0);
    }

    public static void nQueens(int [][] chess , String qsf , int row){
        if(row == chess.length){
            System.out.println(qsf + ".");
            return;
        }

        for(int col=0 ; col<chess[0].length ; col++){
            if(safety(chess , row , col) == true){
            chess[row][col] = 1;
            nQueens(chess , qsf + row + "-" + col + "," , row + 1);
            chess[row][col] = 0;
            }
        }
    }

    public static boolean safety(int [] [] chess , int row , int col){
        for(int i=row-1 , j=col ; i>=0 ; i-- ){
            if(chess[i][j] == 1){
                return false;
            }
        }
        for(int i=row-1 , j=col-1 ; i>=0 && j>=0 ; i-- , j--){
            if(chess[i][j] == 1){
                return false;
            }
        }
        for(int i=row-1 , j=col+1 ; i>=0 && j<chess[0].length ; i--, j++){
            if(chess[i][j] == 1){
                return false;
            }
        }
        return true;
    }
}
