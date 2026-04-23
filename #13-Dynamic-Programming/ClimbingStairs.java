import java.io.*;
public class ClimbingStairs{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int paths = paths(n);
        System.out.println(paths);

        int pathsmemo = pathsmemo(n , new int [n + 1]);
        System.out.println(pathsmemo);

        int pathstab = pathstab(n);
        System.out.println(pathstab);
    }

    public static int paths(int n){
        if(n == 0){
            return 1;
        }
        else if(n < 0){
            return 0;
        }

        int paths1 = paths(n - 1);
        int paths2 = paths(n - 2);
        int paths3 = paths(n - 3);

        int tp = paths1 + paths2 + paths3;
        return tp;
    }

    public static int pathsmemo(int n , int [] qb){
        if(n<0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }
        else if(qb[n] != 0){
            return qb[n];
        }

        int paths1 = pathsmemo(n - 1 , qb);
        int paths2 = pathsmemo(n - 2 , qb);
        int paths3 = pathsmemo(n - 3 , qb);

        int tp = paths1 + paths2 + paths3;
        qb[n] = tp;

        return tp;
    }

    public static int pathstab(int n){
        int [] dp = new int [n + 1];
        dp[0] = 1;

        for(int i=1 ; i<=n ; i++){
            if(i==1){
                dp[i] = dp[i - 1];
            }
            else if(i==2){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        return dp[n];
    }
}