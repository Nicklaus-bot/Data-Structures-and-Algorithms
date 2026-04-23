import java.io.*;
import java.util.*;
public class RemovePrimes{
    public static void main(String [] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        int n = Integer.parseInt(br.readLine());
        for(int i=0 ; i<n ; i++){
            int val = Integer.parseInt(br.readLine());
            list.add(val);
        }

        removePrimes(list);
        System.out.println(list);
    }

    public static void removePrimes(ArrayList<Integer> list){
        for(int i=list.size() - 1 ; i>=0 ; i--){
            if(isPrime(list.get(i)) == true){
                list.remove(i);
            }
        }
    }

    public static boolean isPrime(int n){
        for(int div=2 ; div*div<=n ; div++){
            if(n%div == 0){
                return false;
            }
        }
        return true;
    }
}