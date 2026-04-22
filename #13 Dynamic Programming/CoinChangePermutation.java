import java.io.*;
public class CoinChangePermutation{
    public static void main(String[] args) throws Exception{
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

        for(int i=1 ; i<dp.length ; i++){
            for(int j=0 ; j<arr.length ; j++){
                if(i >= arr[j]){
                    dp[i] += dp[i - arr[j]];
                }
            }
        }
        
        System.out.println(dp[amt]);
    }
}