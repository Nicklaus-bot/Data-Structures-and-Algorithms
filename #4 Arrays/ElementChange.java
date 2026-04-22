import java.util.*;
public class ElementChange{
    public static void main(String[]args){
        int [] array1;
        array1 = new int [5];
        array1[0] = 56;
        array1[1] = 44;
        array1[2] = 84;
        array1[3] = 94;
        array1[4] = 73;

        int [] array2 = array1;
        array2[3] = 120;

        for(int i = 0 ; i< array1.length ; i++){
            System.out.println(array1[i]);
        }

    }
}