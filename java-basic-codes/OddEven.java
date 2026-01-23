import java.util.*;
public class OddEven{
  public static void main(String[]args){
    Scanner scn = new Scanner(System.in);
    int x = scn.nextInt();
    if(x%2==0){
      System.out.println(x + " is Even");
    }
    else{
      System.out.println(x + " is Odd");
    }
  }
}
