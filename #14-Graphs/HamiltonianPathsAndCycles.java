import java.io.*;
import java.util.*;
public class HamiltonianPathsAndCycles{
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

        int src = Integer.parseInt(br.readLine());

        HashSet<Integer> visited = new HashSet<>();
        findTrees(graph , src , visited , src + " ", src);
    }

    public static void findTrees(ArrayList<Edge> [] graph , int src , HashSet<Integer> visited , String psf , int osrc){
        if(visited.size() == graph.length - 1){
            System.out.print(psf);

            boolean vnbr = false;
            for(Edge e : graph[src]){
                if(e.n == osrc){
                    vnbr = true;
                }
            }

            if(vnbr == true){
                System.out.print(" * ");
            }
            else{
                System.out.print(" . ");
            }
            System.out.println();
        }

        visited.add(src);
        for(Edge e : graph[src]){
            if(visited.contains(e.n) != true){
                findTrees(graph , e.n , visited , psf + e.n + " " , osrc);
            }
        }
        visited.remove(src);
    }
}