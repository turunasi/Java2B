#include<stdio.h>

void quickSort (int *A, int L, int R);
void bubbleSort (int *A);

void main(void) {

  int m,i;
  int A[] = {8, 9, 5, 7, 2, 1};

  printf("Input Mode\n");
  printf("1:BUBBLE sort in asc\n");
  printf("other:QUICK sort in asc\n");
  scanf("%d",&m);
  if (m == 1) bubbleSort(A);
  else quickSort(A,0,sizeof(A)/sizeof(int)-1);
  for (i=0;i<sizeof(A)/sizeof(int);i++) {
    printf("%d",A[i]);
  }

}

void swap (int *a,int *b) {
  int c = *a;
  *a = *b;
  *b = c;
}

void bubbleSort (int *A) {
  int i,j;
  for (i=6;i>=2;i--) {
    for (j=0;j<i-1;j++) {
      if (A[j]>A[j+1]) swap(&A[j],&A[j+1]);
    }
  }
}

void quickSort (int *A,int L,int R) {

  int l = L;
  int r = R;
  int p = A[(L+R)/2];
  
  while (!(l>r)) {
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
