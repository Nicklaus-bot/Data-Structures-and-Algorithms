public class Arithmatic {
    public static void main(String[]args){
        int x = 15;
        int y =12;
        int sum = x+y;
        int diff = x-y;
        int prd = x*y;
        int r = x%y;
        int q = x/y;

        int exp = (x*y)/(x+y);

        System.out.println("Sum of " + x + " and " + y + " is " + sum);
        System.out.println("Difference  of " + x + " and " + y + " is " + diff);
        System.out.println("Product  of " + x + " and " + y + " is " + prd);
        System.out.println("Remainder when " + x + " is divided by  " + y + " is " + r);
        System.out.println("Quotient when  " + x + " is divided by  " + y + " is " + q);
        System.out.println("Solution of Expression is " + exp);
    }
    
}
