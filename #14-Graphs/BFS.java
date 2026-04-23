import java.io.*;
import java.util.*;
public class BFS{
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
    public static class Pair{
        int n;
        String psf;

        public Pair(int n , String psf){
            this.n = n;
            this.psf = psf;
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

        int src = Integer.parseInt(br.readLine());

        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(src , src + " "));
        boolean [] visited = new boolean [v];

        while(!que.isEmpty()){
            Pair p = que.remove();                    //remove
            
            if(visited[p.n]){
                continue;
            }
            visited[p.n] = true;                      //mark true

            System.out.println(p.n + " @ " + p.psf);  //work

            for(Edge e : graph[p.n]){                 // add
                if(visited[e.n] == false){
                    que.add(new Pair(e.n , p.psf + e.n + " "));
                }
            }
        }
    }
}