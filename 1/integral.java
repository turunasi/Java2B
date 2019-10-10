import java.util.Scanner;

class integral {
  public static void main(String args[]) {
    
    double sum = 0;
    Scanner scanner = new Scanner(System.in);

    System.out.println("Input real number");
    System.out.println("a =");
    double a = scanner.nextDouble();
    System.out.println("b =");
    double b = scanner.nextDouble();

    System.out.println("Input integer number");
    int n = scanner.nextInt();

    double h = (b - a)/n;

    for (int i=0;i<=n;i++){
      sum += h*Math.sin(a+i*h);
    }

    System.out.println("answer is "+sum);
  }
}
