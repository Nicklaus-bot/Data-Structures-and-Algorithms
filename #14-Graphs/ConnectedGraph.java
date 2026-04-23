import java.io.*;
import java.util.*;
public class ConnectedGraph{
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
        for(int i=0 ; i<v ; i++){
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
                findTrees(graph , i , visited , comp);
                comps.add(comp);
            }
        }

        if(comps.size() == 1){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }

    public static void findTrees(ArrayList<Edge> [] graph , int i , boolean [] visited , ArrayList<Integer> comp){
        visited[i] = true;
        comp.add(i);
        for(Edge e : graph[i]){
            if(visited[e.n] == false){
                findTrees(graph , e.n , visited , comp);
            }
        }
    }
}
