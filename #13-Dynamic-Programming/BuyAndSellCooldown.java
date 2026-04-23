import java.io.*;
public class BuyAndSellCooldown{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int [] price = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<price.length ; i++){
            price[i] = Integer.parseInt(vals[i]);
        }

        int oldbuy = -price[0];
        int oldsell = 0;
        int oldcool = 0;

        for(int i=1 ; i<price.length ; i++){
            int newbuy = 0;
            int newsell = 0;
            int newcool = 0;

            if(oldcool - price[i] > oldbuy){
                newbuy = oldcool - price[i];
            }
            else{
                newbuy = oldbuy;
            }

            if(oldbuy + price[i] > oldsell){
                newsell = oldbuy + price[i];
            }
            else{
                newsell = oldsell;
            }

            if(oldsell > oldcool){
                newcool = oldsell;
            }
            else{
                newcool = oldcool;
            }

            oldbuy = newbuy;
            oldsell = newsell;
            oldcool = newcool;
        }

        System.out.println(oldsell);

    }
}