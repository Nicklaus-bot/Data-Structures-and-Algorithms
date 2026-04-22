import java.io.*;
public class PaintFence{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int ii = 0;
        int ij = 3;
        int total = ii + ij;

        for(int i=1 ; i<n ; i++){
            ii = ij;
            ij = total * (c - 1);
            total = ii + ij;
        }

        System.out.println(total);

    }
}