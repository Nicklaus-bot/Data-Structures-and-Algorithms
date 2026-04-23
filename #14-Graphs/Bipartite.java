import java.io.*;
import java.util.*;
public class Bipartite{
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
        int level;

        public Pair(int v , String psf , int level){
            this.v = v;
            this.psf = psf;
            this.level = level;
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int v = Integer.parseInt(br.readLine());
        ArrayList<Edge> [] graph = new ArrayList [v] ;
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

        int [] visited = new int [v];
        Arrays.fill(visited , -1);

        for(int i=0 ; i<v ; i++){
            if(visited[i] == -1){
                boolean val = checkBipartite(graph , i , visited);
                if(val == false){
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(true);
    }

    public static boolean checkBipartite(ArrayList<Edge> [] graph , int i , int [] visited){
        ArrayDeque<Pair>que = new ArrayDeque<>();
        que.add(new Pair(i , i + " " , 0));

        while(!que.isEmpty()){
            Pair p = que.remove();

            if(visited[p.v] != -1){
                if(visited[p.v] != p.level){
                    return false;
                }
            }
            visited[p.v] = p.level;

            for(Edge e : graph[p.v]){
                if(visited[e.n] == -1){
                    que.add(new Pair(e.n , p.psf + e.n + " " , p.level + 1));
                }
            }
        }
        return true;
    }
}