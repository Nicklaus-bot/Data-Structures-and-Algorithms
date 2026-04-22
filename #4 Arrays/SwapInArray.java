import java.util.*;
public class SwapInArray{
    public static void main(String[]args){
        int [] array = new int [5];
        array[0] = 25;
        array[1] = 56;
        array[2] = 92;
        array[3] = 75 ;
        array[4] = 65;
        
        swap (array , 2 , 4);

        for(int i=0 ; i<array.length ; i++){
            System.out.println(array[i]);
        }
        
    }
  
public static void swap (int array[] , int i , int j){
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;

    
}    
}