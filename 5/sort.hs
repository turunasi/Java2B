swap [x] = [x]
swap (x:xs)
  | x < y     = y:x:ys
  | otherwise = x:y:ys
  where
    (y:ys) = swap xs

bubbleSort [] = []
bubbleSort xs = y : bubbleSort ys
  where
    (y:ys) = swap xs

quickSort [] = []
quickSort (p:xs) = quickSort smaller ++ [p] ++ quickSort larger
  where smaller = [x | x <- xs, x < p]
        larger = [x | x <- xs, x >= p]

main = do
  putStrLn("Input Mode")
  putStrLn("1:BUBBLE sort in asc")
  putStrLn("other:QUICK sort in asc")
  m <- readLn

  if m == 1
    then
      print $ reverse $ bubbleSort [8,9,5,7,2,1]
    else
      print $ quickSort [8,9,5,7,2,1]
