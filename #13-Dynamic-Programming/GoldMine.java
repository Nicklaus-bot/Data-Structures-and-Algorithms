import java.io.*;
public class GoldMine{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int [][] arr = new int [n][m];

        for(int i=0 ; i<arr.length ; i++){
            String [] vals = br.readLine().split(" ");
            for(int j=0 ; j<arr[0].length ; j++){
                arr[i][j] = Integer.parseInt(vals[j]);
            }
        }

        int [] [] dp = new int [arr.length][arr[0].length];

        for(int j = arr[0].length - 1 ; j>=0 ; j--){
            for(int i=arr.length - 1 ; i>=0 ; i--){
                if(j == arr[0].length - 1){
                    dp[i][j] = arr[i][j];
                }
                else if(i == 0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1] , dp[i+1][j+1]);
                }
                else if(i == arr.length - 1){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1] , dp[i-1][j+1]);
                }
                else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i-1][j+1] , Math.max(dp[i][j+1] , dp[i+1][j+1]));
                }
            }
        }

        int max = dp[0][0];
        for(int i=1 ; i<arr.length ; i++){
            if(dp[i][0] > max){
                max = dp[i][0];
            }
        }

        System.out.println(max);

    }
}