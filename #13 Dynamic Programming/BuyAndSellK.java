import java.io.*;
public class BuyAndSellK{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] price = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<price.length ; i++){
            price[i] = Integer.parseInt(vals[i]);
        }

        int k = Integer.parseInt(br.readLine());

        int [] [] dp = new int [k + 1][price.length];

        for(int i=1 ; i<dp.length ; i++){
            int max = - price[0];

            for(int j=1 ; j<dp[0].length ; j++){
                dp[i][j] = dp[i][j - 1];

                if(dp[i-1][j-1] - price[j - 1] > max){
                    max = dp[i-1][j-1] - price[j-1];
                }

                if(max + price[j] > dp[i][j]){
                    dp[i][j] = max + price[j];
                }
            }
        }

        System.out.println(dp[k][n-1]);

    }
}