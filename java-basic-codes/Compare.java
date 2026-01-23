import java.util.*;
public class Compare{
  public static void main(String[]args) {
    Scanner scn = new Scanner(System.in);
    int x = scn.nextInt();
    int y = scn.nextInt();
    if(x>y){
      System.out.println(x + " is greater than " + y);
    }
    else if(x<y){
      System.out.println(x + " is less than "  + y);
    }
    else{
      System.out.println(x + " is equal to "  + y);
    }
  }
}
