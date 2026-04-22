import java.util.*;
public class GetSubsequence{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        ArrayList<String> res = getSub(str);
        System.out.println(res);
    }

    public static ArrayList<String> getSub(String str){
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String res = str.substring(1);
        ArrayList<String> rres = getSub(res);

        ArrayList<String> mres = new ArrayList<>();
        for(String rstr : rres){
            mres.add("" + rstr);
            mres.add(ch + rstr);
        }

        return mres;

    }
}