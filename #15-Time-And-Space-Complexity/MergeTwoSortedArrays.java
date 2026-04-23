import java.io.*;
public class MergeTwoSortedArrays{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n1 = Integer.parseInt(br.readLine());
        int [] arr1 = new int [n1];
        String [] vals1 = br.readLine().split(" ");
        for(int i=0 ; i<arr1.length ; i++){
            arr1[i] = Integer.parseInt(vals1[i]);
        }

        int n2 = Integer.parseInt(br.readLine());
        int [] arr2 = new int [n2];
        String [] vals2 = br.readLine().split(" ");
        for(int i=0 ; i<arr2.length ; i++){
            arr2[i] = Integer.parseInt(vals2[i]);
        }

        int [] res = mergeTwoSorted(arr1 , arr2);
        for(int val : res){
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static int [] mergeTwoSorted(int [] arr1 , int [] arr2){
        int [] res = new int [arr1.length + arr2.length];

        int i=0;
        int j=0;
        int k=0;

        while(i<arr1.length && j<arr2.length){
            if(arr1[i] < arr2[j]){
                res[k] = arr1[i];
                i++;
                k++;
            }
            else{
                res[k] = arr2[j];
                j++;
                k++;
            }
        }

        while(i<arr1.length){
            res[k] = arr1[i];
            i++;
            k++;
        }

        while(j<arr2.length){
            res[k] = arr2[j];
            j++;
            k++;
        }

        return res;
    }

}