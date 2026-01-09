public class GradingSystem{
  public static void main(String[]args){
    int x = 56;
    if(x>90){
      System.out.println("Excellent");
    }
    else if(x>80){
      System.out.println("Good");
    }
    else if(x>70){
      System.out.println("Fair");
    }
    else if(x>60){
      System.out.println("Meets Expectations");
    }
    else if(x<60){
     System.out.println("Below Par"); 
    }
  }
}
