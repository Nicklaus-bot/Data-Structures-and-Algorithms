import java.io.*;
public class BinaryStrings{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int oz = 1;
        int oo = 1;

        for(int i=2 ; i<=n ; i++){
            int nz = oo;
            int no = oo + oz;

            oz = nz;
            oo = no;
        }

        System.out.println(oz + oo);
    }
}