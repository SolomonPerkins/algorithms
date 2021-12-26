

![Insertion Sort](https://upload.wikimedia.org/wikipedia/commons/0/0f/Insertion-sort-example-300px.gif "Insertion Sort")

# Description
Insertion sort is a simple type of algorithm, which is useful for small amount of data but not large dataset.

__For large dataset it is better to use Shell sort (a form of intertion sort)__

__Big O of 0(n<sup>2</sup>) as in the worst case it will traverse the entire lists twice_



# Use Cases:

1. Useful for small dataset (eg. datasize up to 20).
2. It is efficient 

## Scenarios:

+ `Faster than Bubblesort`:
  + > For small dataset insertion sort is faster than bubblesort.

+ `Faster for partially sorted data sets`
+ `Stable: don't change order if both elements are equal`
+ `Requires a constant amount of memory.`
+ 

# Disadvantages

1. Not useful with large datasets.
2. Slower than selection sort.


# Pseudocode

1. Assume the first element in the list is sorted
2. Get the next element (unsorted) and place it into the sorted
3. Repeat until all the elements in the unsorted lists are moved.



# Code Snippet

<details>
<summary>Insertion Sort</summary>

<p>

```go

func insertionSort(arr []int) []int {
  
  //Assing first element
  for i := 0; i < len(arr); i++ {

      //For each element greater than current, swap the elements
      for j := i; j > 0 && arr[j-1] > arr[j]; j-- { 
          arr[j], arr[j-1] = arr[j-1], arr[j]
      }
  }

  return arr
}

```
</p>
</details>
