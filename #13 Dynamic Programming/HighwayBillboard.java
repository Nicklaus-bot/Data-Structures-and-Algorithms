import java.io.*;
public class HighwayBillboard{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        String [] mile = br.readLine().split(" ");
        String [] revenue = br.readLine().split(" ");

        int [] miles = new int [n];
        int [] rev = new int [n];

        for(int i=0 ; i<miles.length ; i++){
            miles[i] = Integer.parseInt(mile[i]);
        }

        for(int i=0 ; i<rev.length ; i++){
            rev[i] = Integer.parseInt(revenue[i]);
        }

        int gap = Integer.parseInt(br.readLine());

        int [] dp = new int [n];
        dp[0] = rev[0];
        int amt = dp[0];

        for(int i=1 ; i<miles.length ; i++){

            int max = 0;
            for(int j=0 ; j<i ; j++){
                if(miles[i] - miles[j] > gap){
                    max = Math.max(max , dp[j]);
                }
            }

            dp[i] = max + rev[i];
            amt = Math.max(amt , dp[i]);
        }

        System.out.println(amt);

    }
}