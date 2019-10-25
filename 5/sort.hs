import Control.Monad
import data.IORef

main = do
  let A = [8,9,5,7,2,1]
  putStrLn("Input Mode")
  putStrLn("1:BUBBLE sort in asc")
  putStrLn("other:QUICK sort in asc")
  m <- readLn

  A = (m == 1)? bubbleSort(A):quickSort(A,0,A.length-1);
  if m == 1
    then
      A = bubbleSort(A)
    else
      A = quickSort(A)

  forM_ A $ \i -> do
      putStrLn(show i)

swap 0 j xs'@(x:xs) = xs' !! j : take (j-1) xs ++ x :drop j xs
swap i j ()
swap X a b = Y
  Y = X
  Y[a] = X[b]
  Y[b] = X[a]
  where
    Y :: [int]


bubbleSort (int[] A)
  int i,j,tmp;
  for (i=A.length;i>=2;i--) {
    for (j=0;j<i-1;j++) {
      if (A[j]>A[j+1]) swap(A,j,j+1);
    }
  }
  return A;

quickSort (int[] A,int L,int R)

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
