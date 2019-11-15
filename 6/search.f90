program search

    implicit none
    integer :: i,n,m,idx
    integer :: A(6) = (/ 8,9,5,7,2,1 /)

    write(*,*) "Input num"
    read(*,*) n
    write(*,*) "Input Mode"
    write(*,*) "1:Search num by sequential search"
    write(*,*) "other:Search num by binary search"
    read(*,*) m

    if (m.eq.1) then
        idx = sequentialSearch(A,n)
    else
        call bubbleSort(A)
        idx = binarySearch(A,n)
    end if

    if (idx.eq.-1) then
        write(*,*) "404 not found"
    else
        write(*,*) "the num is found in ",idx
    end if

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

    function sequentialSearch(A,n)
        
        implicit none
        integer,intent(in) :: A(6),n
        integer,intent(out) :: sequentialSearch
        integer :: i,length
        length = size(A)

        do i=1,length
            if (A(i).eq.n) then
                exit
            end if
        end do

        if (i.lt.length) then
            sequentialSearch = i
        else
            sequentialSearch = -1
        end if

    end function sequentialSearch

    function binarySearch(A,n)

        implicit none
        integer,intent(in) :: A(6),n
        integer,intent(out) :: binarySearch
        integer :: m,l,r

        l = 0
        r = size(A) -1

        do while (.not.(l.lt.r))
            m = int((l + r)/2)
            if (A(m).lt.r) then 
                l = m + 1
            else
                r = m
            end if
        end do
        
        if (A[l].eq.n) then
            binarySearch = l
        else
            binarysearch = -1
        end if
    end function binarySearch

end program search
