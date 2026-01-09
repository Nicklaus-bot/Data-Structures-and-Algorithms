import java.util.*;
public class Rotate{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int x = n;

        int nod = 0;
        while(x>0){
            nod++;
            x=x/10;
        }

        while(r > nod){
            r = r%nod;
        }
        if(r<0){
            r = r+nod;
        }

        int div = n%(int)Math.pow(10 , r);
        int mul = n/(int)Math.pow(10 , r);

        int rot = mul + div*(int)Math.pow(10 , nod - r);
        System.out.println(rot);

    }
}