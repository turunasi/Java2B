def main():

  n = int(input("Define the number of elements in array:"))

  A = [0] * n
  for index,value in enumerate(A):
    A[index] = int(input("A[{}]:".format(index)))

  print("Select Mode!\n")
  print("1:BUBBLE sort in asc\n")
  print("other:QUICK sort in asc\n")
  m = int(input("mode:"))

  A =  bubbleSort(A) if  m == 1 else quickSort(A,0,len(A)-1)

  for index,value in enumerate(A):
    print(value)

def swap (X,a,b):
  X[a],X[b] = X[b],X[a]
  return X

def bubbleSort (A):
  for i in range(len(A),2,-1):
    for j in range(0,i-1):
      if A[j]>A[j+1]: swap(A,j,j+1)
  return A

def quickSort (A,L,R):
    l = L
    r = R
    p = A[int((L+R)/2)]
    
    while not(l>r):
      while A[l]<p: l += 1
      while A[r]>p: r -= 1
      if l>r: break
      if l<r: swap(A,l,r)
      l += 1
      r -= 1

    if L<r: quickSort(A,L,r)
    if l<R: quickSort(A,l,R)

    return A

if __name__ == '__main__':
  main()
