import java.io.*;
import java.util.*;
public class PrimeOrNot{
  public static void main(String[]args){
    Scanner scn = new Scanner(System.in);
    int t = scn.nextInt();
    for(int i=0 ; i<t ; i++){
      int n = scn.nextInt();

      if(n<=1){
        System.out.println("Not Prime");
        continue;
      }
      
      int count = 0;
      for(int div=2 ; div*div<=n ; div++){
        if(n%div==0){
          count++; 
          break;
        }
      }
      if(count == 0){
        System.out.println("Prime");
      }
      else{
        System.out.println("Not Prime");
      }
    }
  }
}
