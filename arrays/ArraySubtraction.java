import java.util.*;
public class ArraySubtraction {
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        
        int n1 = scn.nextInt();
        int [] arr1 = new int [n1];
        for(int i=0 ; i<arr1.length ; i++){
            arr1[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int [] arr2 = new int [n2];
        for(int i=0 ; i<arr2.length ; i++){
            arr2[i] = scn.nextInt();
        }

        int [] diff = new int [Math.max(arr1.length , arr2.length)];

        int i = arr1.length-1;
        int j = arr2.length-1;
        int k = diff.length-1;

        int c = 0;
        while(k>=0){
            int d1 = i>=0? arr1[i] : 0;
            int d2 = j>=0? arr2[j] : 0;

            d1 = d1 + c;

            int d = d1 - d2;
            if(d<0){                    // handles last case so diff array becomes positive if larger is subtracted from smaller
                c = -1;
                d = d + 10;
            }
            else{
                c = 0;
            }

            diff[k] = d;

            i--;
            j--;
            k--;
        }

        int idx = 0;
        while(idx<diff.length  && diff[idx] == 0){
            idx++;
        }

        for(int a=idx ; a<diff.length ; a++){
            System.out.println(diff[a]);
        }

    }    
}
