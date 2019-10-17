import java.util.Scanner;

class recursive {

  public static void main(String args[]) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Input Mode");
    System.out.println("1:f1=2.0 & not recursive");
    System.out.println("2:f1=2.0 & recursive");
    System.out.println("other:Input f1 & recursive");
    int m = scanner.nextInt();
    
    if (m==1) notRecursiveFunc(2.0);
    if (m==2) recursiveFunc(2.0,0);

    System.out.println("Input f1");
    double n = scanner.nextDouble();
    recursiveFunc(n,0);

  }

  static void notRecursiveFunc (double n) {
    
    for (int i=1; i<=50;i++) {
      if (i==1){continue;}
      else if( 0<=n && n<=5){n *= 2;}
      else if( 5<n && n<=10){n = 2*n - 10;}
      else {System.out.println("n is out of range!");}
      System.out.println(n);
    }
    System.exit(0);
  }

  static void recursiveFunc (double n,int cnt) {
    int cntInFunc = (cnt == 0)? 1 : cnt+1;
    if (cntInFunc > 50) System.exit(0);
    if (0<=n && n<=5) {
      System.out.println(n);
      recursiveFunc(2*n,cntInFunc);
    } else if(5<n && n<=10) {
      System.out.println(n);
      recursiveFunc(2*n-10,cntInFunc);
    } else {
      System.out.println("n is out of range!");
    }
  }
}
