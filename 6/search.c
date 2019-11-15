#include<stdio.h>

void bubbleSort (int *A);
int sequentialSearch(int A, int n);
int binarySerach(int A, int n)

void main(void) {

    int n,m;
    int A[] = {8, 9, 5, 7, 2, 1};
    int len = sizeof(A)/sizeof(A[0]);

    printf("Input num :");
    scanf("%d",&n);
    printf("Input Mode\n");
    printf("1:Search num by sequential search\n");
    printf("other:Search num by binary search\n");
    scanf("%d",&m);
  
    int index = (m == 1)? sequentialSearch(A,n,len):binarySearch(bubbleSort(A,len),n,len)

    if (index == -1) {
        printf("404 not found");
    } else {
        printf("the num is found in %d",index);
    }
}

void swap (int *a,int *b) {
  int c = *a;
  *a = *b;
  *b = c;
}

void bubbleSort (int *A,int len) {
  int i,j;
  for (i=len;i>=2;i--) {
    for (j=0;j<i-1;j++) {
      if (A[j]>A[j+1]) swap(&A[j],&A[j+1]);
    }
  }
}

int seqentialSearch (int  A,int n,int len) {

    int i;

    for (i = 0; i < len; i++) {
      if (A[i] == n) break;
    }
    if (i < len) return i;
    return -1;
  }

int binarySearch (int[] A,int n,int len) {

    int m;
    int l = 0;
    int r = len -1;

    while (!(l<r)) {
      m = (int)(l + r)/2;
      if (A[m]<n) l = m +1;
      else r = m;
    }

    if (A[l]==n) return l;
    return -1;
}
