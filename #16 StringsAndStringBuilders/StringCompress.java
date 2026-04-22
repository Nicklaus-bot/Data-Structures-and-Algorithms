import java.util.*;
public class StringCompress{
    public static void main(String [] args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();

        String compress1 = compress1(str);
        String compress2 = compress2(str);

        System.out.println(compress1);
        System.out.println(compress2);
    }

    public static String compress1(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0) + "");

        for(int i=1 ; i<str.length() ; i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i-1);

            if(prev != curr){
                sb.append(curr);
            }
        }
        return sb.toString() ;
    }

    public static String compress2(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0) + "");

        int count = 1;
        for(int i=1 ; i<str.length() ; i++){
            char curr = str.charAt(i);
            char prev = str.charAt(i - 1);

            if(curr == prev){
                count ++;
            }
            else{
                if(count > 1){
                    sb.append(count);
                    count = 1;
                }
                sb.append(curr);
            }
        }

        return sb.toString();
    }
}