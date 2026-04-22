import java.io.*;
import java.util.*;
public class FindPath{
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
        ArrayList<Edge> [] graph = new ArrayList [v] ;

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

        int source = Integer.parseInt(br.readLine());
        int destination = Integer.parseInt(br.readLine());

        boolean [] visited = new boolean [v];

        boolean hasPath = hasPaths(graph , source , destination , visited);
        System.out.println(hasPath);
    }

    public static boolean hasPaths(ArrayList<Edge> [] graph , int source , int destination , boolean [] visited){
        if(source == destination){
            return true;
        }

        visited[source] = true;
        for(Edge edge : graph[source]){
            if(visited[edge.n] == false){
                boolean nbrhaspath = hasPaths(graph , edge.n , destination , visited);
                if(nbrhaspath == true){
                    return true;
                }
            }
        }

        return false;
    }
}