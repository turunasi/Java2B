def main():

    A = [8,9,5,7,2,1]

    n = int(input("Input num"))
    print("Input Mode\n")
    print("1:Search num by seqential search\n")
    print("other:serach num by binary search\n")
    m = int(input("mode:"))

    index = seqentialSearch(A) if  m == 1 else binarySearch(bubbleSort(A),n)
    if index == -1 :
        print("404 not found")
    else
        print("the num is found in "+index)

def swap (X,a,b):
  X[a],X[b] = X[b],X[a]
  return X

def bubbleSort (A):
  for i in range(len(A),2,-1):
    for j in range(0,i-1):
      if A[j]>A[j+1]: swap(A,j,j+1)
  return A

def seqentialSearch (A,n):

    for i in range(0,len(A)):
        if A[i]==n: break
    if i < len(A): return i;
    return -1

def binarySearch (A,n):
    l = 0
    r = len(A) -1

    while not(l<r):
        m = int((l+r)/2)
        if A[m]<n: l = m +1
        else r = m

    if A[l]==n: return l
    return -1

if __name__ == '__main__':
  main()
