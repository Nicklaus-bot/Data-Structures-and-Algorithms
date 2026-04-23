import java.io.*;
public class UnboundedKnapsack{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int [] wts = new int [n];
        int [] vals = new int [n];

        String [] wt = br.readLine().split(" ");
        for(int i=0 ; i<wts.length ; i++){
            wts[i] = Integer.parseInt(wt[i]);
        }

        String [] val = br.readLine().split(" ");
        for(int i=0 ; i<vals.length ; i++){
            vals[i] = Integer.parseInt(val[i]);
        }

        int cap = Integer.parseInt(br.readLine());

        int [] dp = new int [cap + 1];
        dp[0] = 0;

        for(int i=1 ; i<dp.length ; i++){
            int max = 0;
            for(int j=0 ; j<wts.length ; j++){
                if(i>=wts[j]){
                    int v = dp[i - wts[j]] + vals[j];
                    if(v > max){
                        max = v;
                    }
                }
            }
            dp[i] = max;
        }

        System.out.println(dp[cap]);

    }
}