public class StringBuilderBasics{
    public static void main(String [] args) throws Exception{

        StringBuilder sb = new StringBuilder("hello");

        char c = sb.charAt(0);
        System.out.println(c);

        sb.insert(2 , 'u');
        System.out.println(sb);

        sb.deleteCharAt(2);
        System.out.println(sb);

        sb.append('g');
        System.out.println(sb);

        System.out.println(sb.length());
        
        





    }
}