import java.io.*;
public class AdjacentSum{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int [n];
        String [] vals = br.readLine().split(" ");
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = Integer.parseInt(vals[i]);
        }

        int oinc = arr[0];
        int oexc = 0;

        for(int i=1 ; i<arr.length ; i++){
            int ninc = arr[i] + oexc;
            int nexc = Math.max(oinc , oexc);

            oinc = ninc;
            oexc = nexc;
        }

        System.out.println(Math.max(oinc , oexc));
        
    }
}