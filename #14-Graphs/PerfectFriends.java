import java.io.*;
import java.util.*;
public class PerfectFriends{
    public static class Edge{
        int s;
        int n;
        int w;

        public Edge(int s , int n , int w){
            this.s = s;
            this.n = n;
            this.w = w;
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        ArrayList<Edge> [] graph = new ArrayList [v];
        for(int i=0 ; i<graph.length ; i++){
            graph[i] = new ArrayList<>();
        }

        int edges = Integer.parseInt(br.readLine());
        for(int i=0 ; i<edges ; i++){
            String [] vals = br.readLine().split(" ");
            int s = Integer.parseInt(vals[0]);
            int n = Integer.parseInt(vals[1]);
            int w = Integer.parseInt(vals[2]);

            graph[s].add(new Edge(s , n , w));
            graph[n].add(new Edge(n , s , w));
        }

        ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
        boolean [] visited = new boolean [v];
        for(int i=0 ; i<v ; i++){
            ArrayList<Integer> comp = new ArrayList<>();
            if(visited[i] == false){
                findTree(graph , i , visited , comp);
                comps.add(comp);
            }
        }

        int pair = 0;
        for(int i=0 ; i<comps.size() ; i++){
            for(int j=i+1 ; j<comps.size() ; j++){
                int count = comps.get(i).size() * comps.get(j).size();

                pair += count;
            }
        }
        System.out.println(pair);
    }

    public static void findTree(ArrayList<Edge> [] graph , int i , boolean [] visited , ArrayList<Integer> comp){
        visited[i] = true;
        comp.add(i);
        for(Edge e : graph[i]){
            if(visited[e.n] == false){
                findTree(graph , e.n , visited , comp);
            }
        }
    }
}