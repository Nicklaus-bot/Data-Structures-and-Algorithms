import java.io.*;
public class ArrangeBuildings{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int oz = 1;
        int oo = 1;

        for(int i=2 ; i<=n ; i++){
            int nz = oo;
            int no = oz + oo;

            oz = nz;
            oo = no;
        }

        int total = oz + oo;
        total *= total;

        System.out.println(total);
    }
}