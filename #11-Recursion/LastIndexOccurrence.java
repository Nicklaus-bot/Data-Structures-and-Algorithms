import java.util.*;
public class LastIndexOccurrence {
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int [] arr = new int [n];
        for(int i=0 ; i<arr.length ; i++){
            arr[i] = scn.nextInt();
        }
        int data = scn.nextInt();

        int li = lastIndex(arr , 0 , data);
        System.out.println(li);
    } 
    
    public static int lastIndex(int [] arr , int idx , int data){
        if(idx == arr.length){
            return - 1;
        }
        
        int lis = lastIndex(arr , idx + 1, data);
        
        if(lis == -1){
            if(arr[idx] == data){
                return idx;
            }
            else{
                return -1;
            }
        }
        else{
            return lis;
        }
    }
}
