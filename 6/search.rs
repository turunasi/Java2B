use std::io;

void quickSort (int *A, int L, int R);
void bubbleSort (int *A);

fn main() {

  let mut A = [8, 9, 5, 7, 2, 1];

  println!("Input Mode");
  println!("1:BUBBLE sort in asc");
  println!("other:QUICK sort in asc");
  let m = Int::new();

  if m == 1 {
    A = bubbleSort(A);
  } else {
    A = quickSort(A,0,sizeof(A)/sizeof(int)-1);
  }
  println!(A);
}

fn swap (int *a,int *b) {
  int c = *a;
  *a = *b;
  *b = c;
}

fn bubbleSort (A: i32) -> i32{
  int i,j;
  for (i=6;i>=2;i--) {
    for (j=0;j<i-1;j++) {
      if (A[j]>A[j+1]) swap(&A[j],&A[j+1]);
    }
  }
}

fn quickSort (A: i32,L: i32,R: i32) -> i32{

  int l = L;
  int r = R;
  int p = A[(L+R)/2];
  
  while !l>r {
    while (A[l]<p) l++;
    while (A[r]>p) r--;
    if (l>r) break;
    if (l<r) swap(&A[l],&A[r]);
    l++;
    r--;
  }

  if (L<r) quickSort(A,L,r);
  if (l<R) quickSort(A,l,R);
}
