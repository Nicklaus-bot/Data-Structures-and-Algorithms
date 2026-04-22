import java.io.*;
public class BuyAndSellTwo{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] price = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<price.length ; i++){
            price[i] = Integer.parseInt(vals[i]);
        }

        int [] dpleft = new int [n];
        dpleft[0] = 0;
        int min = 0;
        int lp = 0;
        for(int i=1 ; i<dpleft.length ; i++){
            int p = price[i] - price[min];
            if(p > lp){
                dpleft[i] = p;
            }
            else{
                dpleft[i] = lp;
            }
            lp = Math.max(p , lp);

            if(price[i] < price[min]){
                min = i;
            }
        }


        int [] dpright = new int [n];
        int max = price.length - 1;
        dpright[dpright.length - 1] = 0;
        int rp = 0;
        for(int i=dpright.length - 2 ; i>=0 ; i--){
            int p = price[max] - price[i];
            if(p > rp){
                dpright[i] = p;
            }
            else{
                dpright[i] = rp;
            }
            rp = Math.max(p , rp);

            if(price[i] > price[max]){
                max = i;
            }

        }

        int op = 0;
        for(int i=0 ; i<price.length ; i++){
            if(dpleft[i] + dpright[i] > op){
                op = dpleft[i] + dpright[i];
            }
        }

        System.out.println(op);
    }
}