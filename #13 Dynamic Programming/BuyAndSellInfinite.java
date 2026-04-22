import java.io.*;
public class BuyAndSellInfinite{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] prices = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<prices.length ; i++){
            prices[i] = Integer.parseInt(vals[i]);
        }

        int buyidx = 0;
        int sellidx = 0;
        int profit = 0;

        for(int i=1 ; i<prices.length ; i++){
            if(prices[i] >= prices[i-1]){
                sellidx++;
            }
            else{
                profit += prices[sellidx] - prices[buyidx];
                buyidx = sellidx = i;
            }
        }

        profit += prices[sellidx] - prices[buyidx];
        System.out.println(profit);
    }
}