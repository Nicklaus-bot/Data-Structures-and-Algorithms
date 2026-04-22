import java.io.*;
public class Islands{
    public static class Edge{
        int s;
        int n;
        int w;

        public Edge(int s , int n , int w){
            this.s = s;
            this.n = n;
            this.w = w;
        }
    }
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int [] [] arr = new int [m][n];
        for(int i=0 ; i<arr.length ; i++){
            String [] vals = br.readLine().split(" ");
            for(int j=0 ; j<arr[0].length ; j++){
                arr[i][j] = Integer.parseInt(vals[j]);
            }
        }

        boolean [] [] visited = new boolean [m][n];
        int count = 0;
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                if(visited[i][j] == false  && arr[i][j] == 0){
                    island(arr , i , j , visited);
                    count ++;
                }
            }
        }

        System.out.println(count);
        
    }

    public static void island(int [] [] arr , int i , int j , boolean [] [] visited){
        if (i<0 || j<0 || i>=arr.length || j>=arr[0].length || visited[i][j] == true || arr[i][j] == 1){
            return;
        }

        visited[i][j] = true;
        island(arr , i - 1 , j , visited);
        island(arr , i , j - 1 , visited);
        island(arr , i + 1 , j , visited);
        island(arr , i , j + 1 , visited);
    } 

}