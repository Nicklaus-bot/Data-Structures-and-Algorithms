import java.io.*;
public class PaintHouseTwo{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int [] [] arr = new int [h][c];
        for(int i=0 ; i<arr.length ; i++){
            String [] vals = br.readLine().split(" ");
            for(int j=0 ; j<arr[0].length ; j++){
                arr[i][j] = Integer.parseInt(vals[j]);
            }
        }

        int [] [] dp = new int [arr.length] [arr[0].length];
        int least = Integer.MAX_VALUE;
        int sleast = Integer.MAX_VALUE;
        for(int j=0 ; j<arr[0].length ; j++){
            dp[0][j] = arr[0][j];

            if(arr[0][j] < least){
                sleast = least;
                least = arr[0][j];
            }
            else if(arr[0][j] < sleast){
                sleast = arr[0][j];
            }
        }

        for(int i=1 ; i<dp.length ; i++){

            int nleast = Integer.MAX_VALUE;
            int nsleast = Integer.MAX_VALUE;

            for(int j=0 ; j<dp[0].length ; j++){
                if(arr[i][j] != least){
                    dp[i][j] = arr[i][j] + least;
                }
                else{
                    dp[i][j] = arr[i][j] + sleast;
                }

                if(dp[i][j] < nleast){
                    nsleast = nleast;
                    nleast = dp[i][j];
                }
                else if(dp[i][j] < nsleast){
                    nsleast = dp[i][j];
                }
            }

            least = nleast;
            sleast = nsleast;
        }

        System.out.println(least);

    }
}