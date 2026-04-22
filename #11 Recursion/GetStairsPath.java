import java.util.*;
public class GetStairsPath{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ArrayList<String> paths = getStairs(n);
        System.out.println(paths);
    }

    public static ArrayList<String> getStairs(int n){
        if(n==0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }
        else if(n < 0){
            ArrayList<String> bres = new ArrayList<>();
            return bres;
        }


        ArrayList<String> paths1 = getStairs(n - 1);
        ArrayList<String> paths2 = getStairs(n - 2);
        ArrayList<String> paths3 = getStairs(n - 3);

        ArrayList<String> paths = new ArrayList<>();
        for(String path : paths1){
            paths.add(1 + path);
        }
        for(String path : paths2){
            paths.add(2 + path);
        }
        for(String path : paths3){
            paths.add(3 + path);
        }

        return paths;
    }
}