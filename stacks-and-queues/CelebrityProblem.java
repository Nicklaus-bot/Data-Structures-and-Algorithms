import java.io.*;
import java.util.*;
public class CelebrityProblem{
    public static void main(String[]args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] [] arr = new int [n] [n];
        for(int i=0 ; i<arr.length ; i++){
            for(int j=0 ; j<arr[0].length ; j++){
                arr[i][j] = Integer.parseInt(br.readLine());
            }
        }

        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<arr.length ; i++){
            st.push(arr[i][0]);
        }

        while(st.size()>1){
            int a = st.pop();
            int b = st.pop();
            if(arr[a][b] == 1){
                st.push(b);
            }
            else{
                st.push(a);
            }
        }

        int pos = st.pop();

        for(int i=0 ; i<arr.length ; i++){
            if(i != pos){
                if(arr[i][pos] == 0 || arr[pos][i] == 1){
                    System.out.println("None");
                    return;
                } 
            }
        }
        System.out.println(pos);




    }
}