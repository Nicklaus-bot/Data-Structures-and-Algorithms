import java.io.*;
public class CoinChangeCombination{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        int amt = Integer.parseInt(br.readLine());

        int [] dp = new int [amt + 1];
        dp[0] = 1;

        for(int i=0 ; i<arr.length ; i++){
            for(int j=arr[i] ; j<dp.length ; j++){
                dp[j] += dp[j - arr[i]];
            }
        }

        System.out.println(dp[amt]);

    }
}