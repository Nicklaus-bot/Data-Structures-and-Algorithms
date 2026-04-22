import java.util.*;
public class HeapsBasic{
    public static void main(String[] args) throws Exception{
        int [] arr = {11 , 2 , 18 , 75 , 33 , 88 , 1 , 99 , 64};

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int val : arr){
            pq.add(val);
        }

        while(!pq.isEmpty()){
            System.out.println(pq.peek());
            pq.remove();
        }

    }
}