package book.dsauj.chapter8.sorting;

public class QuickSort
{ public static void quickSort(int [] items, int leftIndex, int rightIndex)
  { int i, j, temp, pivotValue, partitionSize;
    partitionSize = rightIndex - leftIndex +1;
    if(partitionSize <= 1) // base case, one item to be sorted
      return;

    pivotValue = items[(leftIndex + rightIndex) / 2];
    i = leftIndex; // initialize the two partition indices
    j = rightIndex;

    do
    {  while (items[i] < pivotValue) // left partition item is in the correct partition
          i++;
       while (items[j] > pivotValue) // right partition item is in the correct partition
          j--;
       if (i<=j) // pointers have not crossed, switch items in wrong partition
       {  temp = items[i];    items[i] = items[j];    items[j]=temp;
          i++; j--;
       }
    }  while (i <= j); // the pointers have not crossed

    quickSort(items, leftIndex, j); //reduced problems: sort left partition,
    quickSort(items, i, rightIndex);                 // sort right partition
  }// end of quickSort
}
