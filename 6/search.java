import java.util.Scanner;

class search {

  public static void main(String args[]) {

    int[] A = {8,9,5,7,2,1};
    Scanner scanner = new Scanner(System.in);

    System.out.println("Input num");
    int n = scanner.nextInt();
    System.out.println("Input Mode");
    System.out.println("1:Search num by sequential search");
    System.out.println("other:Search num by binary search");
    int m = scanner.nextInt();

    int index = (m == 1)? seqentialSearch(A,n):binarySearch(bubbleSort(A),n);

    if (index == -1) {
      System.out.println("404 not found");
    } else {
      System.out.println("the num is found in "+index);
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

  static int seqentialSearch (int[] A,int n) {

    int i,length = A.length;

    for (i = 0; i < length; i++) {
      if (A[i] == n) break;
    }
    if (i < length) return i;
    return -1;
  }

  static int binarySearch (int[] A,int n) {

    int m;
    int l = 0;
    int r = A.length -1;

    while (!(l<r)) {
      m = (int)(l + r)/2;
      if (A[m]<n) l = m +1;
      else r = m;
    }

    if (A[l]==n) return l;
    return -1;
  }
    
