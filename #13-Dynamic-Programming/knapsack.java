import java.io.*;
public class knapsack{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] wts = new int [n];
        int [] vals = new int [n];

        String [] wt = br.readLine().split(" ");
        for(int i=0 ; i<wts.length ; i++){
            wts[i] = Integer.parseInt(wt[i]);
        }

        String [] val = br.readLine().split(" ");
        for(int i=0 ; i<vals.length ; i++){
            vals[i] = Integer.parseInt(val[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        int [][] dp = new int [wts.length + 1] [cap + 1];

        for(int i=1 ; i<dp.length ; i++){
            for(int j=1 ; j<dp[0].length ; j++){
                if(j >= wts[i - 1]){
                    if(dp[i-1][j] < dp[i-1][j - wts[i-1]] + vals[i-1]){
                        dp[i][j] = dp[i-1][j-wts[i-1]] + vals[i-1];
                    }
                    else{
                        dp[i][j] = dp[i-1][j];
                    }
                }
                else{
                    dp[i][j] = dp[i - 1][j];

                    if(j >= wts[i - 1]){
                        if(dp[i-1][j] < dp[i-1][j - wts[i-1]] + vals[i-1]){
                            dp[i][j] = dp[i-1][j - wts[i-1]] + vals[i-1];
                        }
                    }
                }   
            }
        }
        System.out.println(dp[dp.length][dp[0].length]);
    }
}