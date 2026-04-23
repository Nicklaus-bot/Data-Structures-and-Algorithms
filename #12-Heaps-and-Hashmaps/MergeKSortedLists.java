import java.io.*;
import java.util.*;
public class MergeKSortedLists{
    public static class Pair implements Comparable<Pair>{
        int listindex;
        int dataindex;
        int value;

        public Pair(int listindex , int dataindex , int value){
            this.listindex = listindex;
            this.dataindex = dataindex;
            this.value = value;
        }

        public int compareTo(Pair o){
            return this.value - o.value;
        }
    }
        

    public static ArrayList<Integer> merge(ArrayList<ArrayList<Integer>> lists){
            ArrayList<Integer> res = new ArrayList<>();

            PriorityQueue<Pair> pq = new PriorityQueue<>();

            for(int i=0 ; i<lists.size() ; i++){
                Pair p = new Pair(i , 0 , lists.get(i).get(0));
                pq.add(p);
            }

            while(pq.size() > 0){
                Pair p = pq.remove();
                res.add(p.value);
                p.dataindex++;

                if(p.dataindex < lists.get(p.listindex).size()){
                    p.value = lists.get(p.listindex).get(p.dataindex);
                    pq.add(p);
                }
            }
            return res;
        }
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int k = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();

        for(int i=0 ; i<k ; i++){
            ArrayList<Integer> list = new ArrayList<>();
            int n = Integer.parseInt(br.readLine());
            String [] vals = br.readLine().split(" ");
            for(int j=0 ; j<n ; j++){
                list.add(Integer.parseInt(vals[j]));
            }
            lists.add(list);
        }

        ArrayList<Integer> sorted = merge(lists);
        System.out.println(sorted);
    }
}