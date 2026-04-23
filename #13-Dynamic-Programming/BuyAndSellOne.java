import java.io.*;
public class BuyAndSellOne{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] prices = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<prices.length ; i++){
            prices[i] = Integer.parseInt(vals[i]);
        }

        int least = Integer.MAX_VALUE;
        int profit = 0;
        int pist = 0;

        for(int i=0 ; i<prices.length ; i++){
            if(prices[i] < least){
                least = prices[i];
            }

            pist = prices[i] - least;

            if(pist > profit){
                profit = pist;
            }
        }

        System.out.println(profit);
        
    }
}