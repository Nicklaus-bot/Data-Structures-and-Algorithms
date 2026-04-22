import java.util.*;
public class GetMazePathsWithJumps{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<String> paths = getPaths(1, 1 , n , m);
        System.out.println(paths);
    }

    public static ArrayList<String> getPaths(int sr , int sc , int dr , int dc){
        if(sr==dr && sc==dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String> paths = new ArrayList<>();

        for(int ms=1 ; ms<=dr-sr ; ms++){
            ArrayList<String> vpath = getPaths(sr+ms , sc , dr , dc);
            for(String path : vpath){
                paths.add("v" + ms + path);
            }
        }

        for(int ms=1 ; ms<=dc-sc ; ms++){
            ArrayList<String> hpath = getPaths(sr , sc+ms , dr , dc);
            for(String path : hpath){
                paths.add("h" + ms + path);
            }
        }

        for(int ms=1 ; ms<=dc-sc && ms<=dr-sr ; ms++){
            ArrayList<String> dpath = getPaths(sr+ms , sc+ms , dr , dc);
            for(String path : dpath){
                paths.add("d" + ms + path);
            }
        }

        return paths;

    }
}