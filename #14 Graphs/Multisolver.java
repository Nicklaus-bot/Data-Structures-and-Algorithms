import java.io.*;
import java.util.*;
public class Multisolver{
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
        int wsf;
        String psf;

        Pair(int wsf , String psf){
            this.wsf = wsf;
            this.psf = psf;
        }

        public int compareTo(Pair o){
            return this.wsf - o.wsf;
        }
    }
    @SuppressWarnings("unchecked")
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(br.readLine());
        ArrayList<Edge> [] graph = new ArrayList [v]; 
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
        int criteria = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        boolean [] visited = new boolean [v];

        multisolver(graph , source , destination , visited , criteria , source + " " , 0 , k);

        System.out.println("Smallest Path - " + spath + " @ " + spathw);
        System.out.println("Largest Path - " + lpath + " @ " + lpathw);
        System.out.println("Ceil Path - " + cpath + " @ " + cpathw);
        System.out.println("Floor Path - " + fpath + " @ " + fpathw);
        System.out.println(k+"th largest - " + pq.peek().psf + " @ " + pq.peek().wsf);

    }

    static int spathw = Integer.MAX_VALUE;
    static String spath;
    static int lpathw = Integer.MIN_VALUE;
    static String lpath;
    static int cpathw = Integer.MAX_VALUE;
    static String cpath;
    static int fpathw = Integer.MIN_VALUE;
    static String fpath;

    static PriorityQueue<Pair> pq = new PriorityQueue<>();

    public static void multisolver(ArrayList<Edge> [] graph , int source , int destination , boolean [] visited , int criteria , String psf , int wsf , int k){
        if(source == destination){

            if(wsf < spathw){
                spathw = wsf;
                spath = psf;
            }

            if(wsf > lpathw){
                lpathw = wsf;
                lpath = psf;
            }

            if(wsf > criteria && wsf < cpathw){
                cpathw = wsf;
                cpath = psf;
            }

            if(wsf < criteria && wsf > fpathw){
                fpathw = wsf;
                fpath = psf;
            }

            if(pq.size() < k){
                pq.add(new Pair(wsf , psf));
            }
            else{
                if(pq.peek().wsf < wsf){
                    pq.remove();
                    pq.add(new Pair(wsf , psf));
                }
            }

            return;
        }

        visited[source] = true;
        for(Edge e : graph[source]){
            if(visited[e.n] == false){
                multisolver(graph , e.n , destination , visited , criteria , psf + e.n + " " , wsf + e.w  , k);
            }
        }
        visited[source] = false;
    }
}