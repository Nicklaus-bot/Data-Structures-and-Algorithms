import java.io.*;
public class PartitionIntoSubsets{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if(n==0 || k==0 || n<k){
            System.out.println("0");
            return;
        }

        int [] [] dp = new int [k+1][n+1];

        for(int i=1 ; i<dp.length ; i++){
            for(int j=1 ; j<dp[0].length ; j++){
                if(j<i){
                    dp[i][j] = 0;
                }
                else if(j == i){
                    dp[i][j] = 1;
                }
                else{
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1]*i;
                }
            }
        }

        System.out.println(dp[k][n]);

    }
}