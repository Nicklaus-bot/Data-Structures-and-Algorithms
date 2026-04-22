import java.io.*;
public class BuyAndSellFees{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] price = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<price.length ; i++){
            price[i] = Integer.parseInt(vals[i]);
        }

        int k = Integer.parseInt(br.readLine());

        int obuy = -price[0];
        int osell = 0;

        for(int i=1 ; i<price.length ; i++){
            int nbuy = 0;
            int nsell = 0;

            if(osell - price[i] > obuy){
                nbuy = osell - price[i];
            }
            else{
                nbuy = obuy;
            }

            if(obuy + price[i] - k > osell ){
                nsell = obuy + price[i] - k;
            }
            else{
                nsell = osell;
            }

            obuy = nbuy;
            osell = nsell;      
        }

        System.out.println(osell);

    }
}