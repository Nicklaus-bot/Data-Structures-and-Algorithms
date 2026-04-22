import java.io.*;
public class TilingM{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int [] dp = new int [n + 1];
        
        for(int i=1 ; i<=n ; i++){
            if(i<m){
                dp[i] = 1;
            }
            else if(i==m){
                dp[i] = 2;
            }
            else{
                dp[i] = dp[i-1] + dp[i-m];
            }
        }

        System.out.println(dp[n]);

    }
}