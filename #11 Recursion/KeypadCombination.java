import java.util.*;
public class KeypadCombination{
    public static void main(String[]args) throws Exception{
        Scanner scn = new Scanner(System.in);
        String str = scn.next();

        ArrayList<String> list = KPC(str);
        System.out.println(list);
    }

    static String [] codes = {".;" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tu" , "vw" , "xyq"};

    public static ArrayList<String> KPC(String str){
        if(str.length() == 0){
            ArrayList<String> bres = new ArrayList<>();
            bres.add("");
            return bres;
        }

        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rres = KPC(ros);

        ArrayList<String> mres = new ArrayList<>();
        
        String code = codes[ch - '0'];
        for(int i=0 ; i<code.length() ; i++){
            char c = code.charAt(i);

            for(String sres : rres){
                mres.add(c + sres);
            }
        }
        return mres;

    }
}