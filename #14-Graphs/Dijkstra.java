import java.io.*;
import java.util.*;
public class Dijkstra{
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
    public static class Pair implements Comparable<Pair>{
        int v;
        String psf;
        int w;

        Pair(int v , String psf , int w){
            this.v = v;
            this.psf = psf;
            this.w = w;
        }

        public int compareTo(Pair o){
            return this.w - o.w;
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

        boolean [] visited = new boolean[v];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0 , 0 + " " , 0));

        while(!pq.isEmpty()){
            Pair p = pq.remove();

            if(visited[p.v] == true){
                continue;
            }
            visited[p.v] = true;

            System.out.println(p.v + " @ " + p.psf + " @ " + p.w);

            for(Edge e : graph[p.v]){
                pq.add(new Pair(e.n , p.psf + e.n + " " , p.w + e.w));
            }
        }
    }
}