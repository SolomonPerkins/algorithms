

![Selection Sort](hhttps://en.wikipedia.org/wiki/File:Selection-Sort-Animation.gif "Selection Sort")

# Description
Selection sort is a simple sorting algorithm with less swaps than insertion but requires more time.


__Big O of 0(n<sup>2</sup>) as in the worst case it will traverse the entire lists twice__


# Use Cases

1. Useful for small dataset (eg. datasize up to 10-20 elements).
2. Performs less swap compared to insertion sort.
3. Faster than bubblesort (good for linked list ordering).


## Scenarios:

+ `Userful for data structures such as linkedlist`

  + > This will make the algoritm efficient as it is moving the minimum element.

+ `Should be choosen over bubble sort and gnome sort (as it outperforms them in almost all situations)`

# Disadvantages

1. Not useful with large datasets.
2. Slower than insertion sort (which only scans the minimum number of elements)
3. Not time efficient (quadratic)
4. For large datasets, merge sort is more efficient.

# Pseudocode

1. Find the minimum element in the list arr[0...size]
2. Find the minimum element in the remaining array arr[1...size]
3. Repeat until the end of the lsit.





# Code Snippet


<details>
<summary>Selection Sort</summary>

<p>

```go

func selectionSort(arr []int) []int{
  //For each element find the minimum element
  for i := 0; i < len(arr); i++ {
    min := i

    //Find the smallest element
    for j := i; j < len(arr); j++ {
        //Swap if a smaller element was found
        if arr[j] < min {
            min = j
        }
    }

    //Swap if the index is different.
    if min != i {
        arr[i], arr[min] = arr[min], arr[i]
    }
  }
}

```
</p>
</details>
