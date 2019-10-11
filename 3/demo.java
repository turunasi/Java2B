import java.util.Scanner;

class demo {

  static int l;

  public static void main(String args[]) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("The number of elements : ");

    l = scanner.nextInt();
    int X[] = new int[l];

    for (int i = 0; i < l; i++) {
      System.out.println("X[] :");
      X[i] = scanner.nextInt();
    }

    System.out.println("Reverse !");
    
    reverse(X);

    for (int i = 0; i < l; i++) {
      System.out.println(X[i]);
    }
    
  }

  static void swap (int[] X,int a,int b) {
    int c = X[a];
    X[a] = X[b];
    X[b] = c;
  }
  
  static void reverse (int[] X) {
    for (int i=0;i <= Math.floor(l/2); i++) {
      swap(X,l-1-i,i);
    }
  }
}
