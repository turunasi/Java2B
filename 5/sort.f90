program sort

  implicit none
  integer :: i,m
  integer :: A(6) = (/ 8,9,5,7,2,1 /)

  write(*,*) "Input Mode"
  write(*,*) "1:BUBBLE sort in asc"
  write(*,*) "other:QUICK sort in asc"
  read(*,*) m

  if (m.eq.1) then
    call bubbleSort(A)
  else
    call quickSort(A,1,size(A))
  end if

  do i=1,size(A)
    write(*,*) A(i)
  end do

  stop
  
  contains
  
  subroutine swap(X,a,b)
    
    implicit none
    integer,intent(in) :: a,b
    integer,intent(inout) :: X(6)
    integer :: c 
    
    c = X(a)
    X(a) = X(b)
    X(b) = c
  
  end subroutine swap

  subroutine bubbleSort(A)
    
    implicit none
    integer,intent(inout) :: A(6)
    integer :: i,j,tmp
    
    do i=size(A),2,-1
      do j=1,i-1
        if (A(j).gt.A(j+1)) then
          call swap(A,j,j+1) 
        end if
      end do
    end do
  
  end subroutine bubbleSort
  
  recursive subroutine quickSort(A,b,c)
    implicit none
    integer,intent(inout) :: A(6)
    integer,intent(in) :: b,c
    integer :: l,r,p
    l = b
    r = c
    p = A(int((b+c)/2))
    
    do while (.not.(l.gt.r))
      do while (A(l).lt.p)
        l = l + 1
      end do
      do while (A(r).gt.p)
        r = r - 1
      end do
      if (l.gt.r) then 
        exit
      end if
      if (l.lt.r) then
        call swap(A,l,r)
      end if
      l = l + 1
      r = r - 1
    end do

    if (b.lt.r) then
      call quickSort(A,b,r)
    end if
    if (l.lt.c) then
      call quickSort(A,l,c)
    end if
  end subroutine quickSort

end program sort
