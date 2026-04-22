import java.util.*;
public class Subsets {
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        }

        int lim = (int)Math.pow(2 , arr.length);

        for(int i=0 ; i<lim ; i++){
            int temp = i;
            String sets = "";

            for(int j=arr.length-1 ; j>=0 ; j--){
                int r = temp%2;
                temp = temp/2;

                if(r==0){
                    sets = "_" + "\t" + sets;
                }
                else{
                    sets = arr[j] + "\t" + sets;
                }
            }
            System.out.println(sets);
        }

    }
}
