import java.io.*;
import java.util.*;
public class PrintPaths{
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
        ArrayList<Edge> [] graph = (ArrayList<Edge> []) new ArrayList [v];
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

        int source = Integer.parseInt(br.readLine());
        int destination = Integer.parseInt(br.readLine());

        boolean [] visited = new boolean [v];
        printPaths(graph , source , destination , visited , source + " ");
    }   

    public static void printPaths(ArrayList<Edge> [] graph , int source , int destination , boolean [] visited , String str){
        if(source == destination){
            System.out.println(str);
            return;
        }

        visited[source] = true;
        for(Edge edge : graph[source]){
            if(visited[edge.n] == false){
                printPaths(graph , edge.n , destination , visited , str + edge.n + " ");
            }
        }
        visited[source] = false;
    }

}