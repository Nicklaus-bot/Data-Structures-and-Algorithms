import java.io.*;
import java.util.*;
public class IsGraphCyclic{
    public static class Pair{
        int x;
        String psf;

        public Pair(int x , String psf){
            this.x = x;
            this.psf = psf;
        }
    }
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

        boolean [] visited = new boolean [v];
        for(int i=0 ; i<v ; i++){
            if(visited[i] == false){
                boolean val = isCyclic(graph , i , visited);
                if(val){
                    System.out.println(true);
                    return;
                }
            }
        }

        System.out.println(false);
    }

    public static boolean isCyclic(ArrayList<Edge> [] graph , int i , boolean [] visited){
        ArrayDeque<Pair> que = new ArrayDeque<>();
        que.add(new Pair(i , i + " "));

        while(!que.isEmpty()){
            Pair p = que.remove();

            if(visited[p.x] == true){
                return true;
            }

            visited[p.x] = true;

            for(Edge e : graph[p.x]){
                if(visited[e.n] == false){
                    que.add(new Pair(e.n , p.psf + e.n + " "));
                }
            }
        }
        return false;
    }
}