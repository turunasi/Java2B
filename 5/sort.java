import java.util.Scanner;

class sort {

  public static void main(String args[]) {

    int[] A = {8,9,5,7,2,1};
    Scanner scanner = new Scanner(System.in);

    System.out.println("Input Mode");
    System.out.println("1:BUBBLE sort in asc");
    System.out.println("other:QUICK sort in asc");
    int m = scanner.nextInt();

    A = (m == 1)? bubbleSort(A):quickSort(A,0,A.length-1);

    for (int i=0;i<A.length;i++) {
      System.out.print(A[i]);
    }

  }

  static void swap (int[] X,int a,int b) {
    int c = X[a];
    X[a] = X[b];
    X[b] = c;
  }

  static int[] bubbleSort (int[] A) {
    int i,j,tmp;
    for (i=A.length;i>=2;i--) {
      for (j=0;j<i-1;j++) {
        if (A[j]>A[j+1]) swap(A,j,j+1);
      }
    }
    return A;
  }

  static int[] quickSort (int[] A,int L,int R) {

    int l = L;
    int r = R;
    int p = A[(int)((L+R)/2)];
    
    while (!(l>r)) {
      while (A[l]<p) l++;
      while (A[r]>p) r--;
      if (l>r) break;
      if (l<r) swap(A,l,r);
      l++;
      r--;
    }

    if (L<r) quickSort(A,L,r);
    if (l<R) quickSort(A,l,R);

    return A;
  }
}
