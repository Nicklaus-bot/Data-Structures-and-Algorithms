import java.io.*;
public class ClimbingStairsWithJumps{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] jumps = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<n ; i++){
            jumps[i] = Integer.parseInt(vals[i]);
        }

        int [] dp = new int [n + 1];
        dp[n] = 1; 

        for(int i=n-1 ; i>=0 ; i--){
            for(int j=1 ; j<=jumps[i] && i+j < dp.length ; j++){
                dp[i] += dp[i + j];
            }
        }

        System.out.println(dp[0]);
    }
}