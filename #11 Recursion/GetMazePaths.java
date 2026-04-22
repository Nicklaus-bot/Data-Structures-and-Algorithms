import java.util.*;
public class GetMazePaths{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        ArrayList<String> paths = getMazePaths(1 , 1 , n , m);
        System.out.println(paths);
    }

    public static ArrayList<String> getMazePaths(int sr , int sc , int dr , int dc){
        if(sr==dr && sc==dc){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        ArrayList<String>paths = new ArrayList<>();

        if(sr<dr){
            ArrayList<String> vpath = getMazePaths(sr+1 , sc , dr , dc);
            for(String path : vpath){
                paths.add("v" + path);
            }
        }
        if(sc<dc){
            ArrayList<String> hpath = getMazePaths(sr , sc+1 , dr , dc);
            for(String path : hpath){
                paths.add("h" + path);
            }
        }

        return paths;

    }
}