import java.io.*;
import java.util.*;
public class SpreadInfection{
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
        int v;
        String psf;
        int time;

        public Pair(int v , String psf , int time){
            this.v = v;
            this.psf = psf;
            this.time = time;
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
        int time = Integer.parseInt(br.readLine());

        int [] visited = new int [v];
        
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(src , src + " " , 1));

        int count = 0;
        while(!que.isEmpty()){
            Pair p = que.remove();

            if(visited[p.v] != 0){
                continue;
            }
            if(p.time > time){
                break;
            }

            visited[p.v] = p.time;
            count ++;

            for(Edge e : graph[p.v]){
                if(visited[e.n] == 0){
                    que.add(new Pair(e.n , p.psf + e.n + " " , p.time + 1));
                }
            }
        }

        System.out.println(count);
    }
}