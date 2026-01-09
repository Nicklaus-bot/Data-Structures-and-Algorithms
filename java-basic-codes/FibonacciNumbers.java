import java.util.*;
public class FibonacciNumbers{
  public static void main(String[]args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int x = 0;
    int y = 1;
    for(int i=0 ; i<n ; i++){
      System.out.println(x);
      int z = x+y;
      x=y;
      y=z;
    }
  }
}
