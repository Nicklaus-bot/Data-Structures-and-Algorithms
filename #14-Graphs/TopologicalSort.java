import java.io.*;
import java.util.*;
public class TopologicalSort{
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
        }

        Stack<Integer> st = new Stack<>();
        boolean [] visited = new boolean [v];
        for(int i=0 ; i<v ; i++){
            if(visited[i] == false){
                topologicalSort(graph , i , visited , st);
            }
        }

        while(st.size() > 0){
            System.out.println(st.pop());
        }
    }

    public static void topologicalSort(ArrayList<Edge>[] graph , int src , boolean [] visited , Stack <Integer> st){
        visited[src] = true;

        for(Edge e : graph[src]){
            if(visited[e.n] == false){
                topologicalSort(graph , e.n , visited , st);
            }
        }

        st.push(src);
    }
}