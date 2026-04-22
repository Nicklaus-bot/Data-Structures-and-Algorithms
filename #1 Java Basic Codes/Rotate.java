import java.util.*;
public class Rotate{
    public static void main(String[]args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int x = n;
        int nod = 0;
        while(x!=0){
             x = x/10;
             nod++;
        }
        r = r%nod;
        if(r<0){
            r = r + nod;
         }       
         int div = 1;
         int mul = 1;
      for(int i =1 ; i<= nod ; i++){
        if(i<=r){
            div = div*10;
        }
        else{
            mul = mul*10;
        }

    }
        int w = n%div;
        int q = n/div;
        int rot = w*mul + q;
        System.out.println(rot);  
    }
}