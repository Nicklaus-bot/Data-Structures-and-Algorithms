import java.util.*;
public class BasicArray{
    public static void main(String[]args){
        int [] array;
        array = new int [5];
        array[0] = 45;
        array[1] = 54;
        array[2] = 67;
        array[3] = 78;
        array[4] = 95;

        System.out.println(array.length);
        for(int i = 0 ; i < array.length; i++){
            System.out.println(array[i]);
        }
    }
}