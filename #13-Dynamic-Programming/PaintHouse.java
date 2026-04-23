import java.io.*;
public class PaintHouse{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());

        int [] [] arr = new int [h][3];
        for(int i=0 ; i<arr.length ; i++){
            String [] vals = br.readLine().split(" ");
            for(int j=0 ; j<arr[0].length ; j++){
                arr[i][j] = Integer.parseInt(vals[j]);
            }
        }

        // array 
        int [] [] dp = new int [arr.length][arr[0].length];
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for(int i=1 ; i<dp.length ; i++){
            dp[i][0] = arr[i][0] + Math.min(dp[i-1][1] , dp[i-1][2]);
            dp[i][1] = arr[i][1] + Math.min(dp[i-1][0] , dp[i-1][2]);
            dp[i][2] = arr[i][2] + Math.min(dp[i-1][0] , dp[i-1][1]);
        }

        int min = Math.min(dp[arr.length - 1][0] , Math.min(dp[arr.length - 1][1] , dp[arr.length - 1][2]));
        System.out.println(min);


        //variables
        int or = arr[0][0];
        int og = arr[0][1];
        int ob = arr[0][2];

        for(int i=1 ; i<arr.length ; i++){
            int nr = arr[i][0] + Math.min(og , ob);
            int ng = arr[i][1] + Math.min(or , ob);
            int nb = arr[i][2] + Math.min(or , ob);

            or = nr;
            og = ng;
            ob = nb;
        }

        int min2 = Math.min(or , Math.min(og , ob));
        System.out.println(min2);

    }
}