import java.util.*;
public class HollowDiamond{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int sp = n/2 + 1;
        int st = 1;
        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<sp ; j++){
                System.out.print("\t");
            }
            for(int j=0 ; j<st ; j++){
                if(j==0 || j==st-1){
                    System.out.print("*\t");
                }
                else{
                System.out.print("\t");
                }
            }

            if(i<n/2){
                sp--;
                st+=2;
            }
            else{
                sp++;
                st-=2;
            }
            System.out.println();
        }
    }
}