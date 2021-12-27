

![Quick Sort](https://upload.wikimedia.org/wikipedia/commons/9/9c/Quicksort-example.gif "Quick Sort.")

# Description
This is a sorting algorithm which uses recursion (divide and conqurer) to sort data. It is similar to merge sort, however quick sort performs the ordering as part of the division stage.


# Pseudocode

1. Divide the list by a particular element and call it the pivot element. 
    > Rearrange all the elements on the left to be ordered and all on the right to be unordered. \
    > This step is called `partitioning`.

2. Recursivley order the subarrays
3. Return the data, the smallest elements are on the left side of the pivot and the larger are on the right side.

# Use Cases:
1. Use to sort large dataset especially if they are unable to fit in memory.
2. It is 2/3 or 3x faster than heapsort.

# Disadvantages

1. The absolute worst case is O(n<sup>2</sup>). This is if you randomly choose the pivot points. 







# Code Snippet


<details>
<summary>Quick Sort</summary>

<p>

```go

func main() {
  var arr =[]int{ 15, 3, 4, 5, 6, 19, 30 }

  quickSort(arr, 0, len(arr) - 1)
}

func quickSort(arr []int, low, high int) []int {
  //If the current element is less than the high
  if low < high {
    //Find the next pivot
    var pivot = partition(arr, low, high)

    //Perform quick sort on the left side (low -> pivot)
    arr = quickSort(arr, low, pivot -1)
    //Perform quick sor on the right side (pivot + 1  -> high)
    arr = quickSort(arr, pivot + 1, high)
  }

  return arr
}

//Partition does the dividing and the swapping in the same step.
func partition(arr []int, low, high) int {
  pivot := arr[high]
  i := low
  j = high

  for i < j {
    //If element is less than pivot (acceptable), move up to the next element
    for arr[i] <= pivot && i < high {
      i++
    } 

    //If element is more than pivot (acceptable), move down to the next element.
    for arr[j] > pivot && j > low {
      j--
    }

    //If there were elements found to be on the wrong side of the pivot, switch them
    if i < j {
      arr[i], arr[j] = arr[j], arr[i]
    }
  }
  
  //Update low to be the latest value
  arr[low] = arr[i]
  //Update high to be the pivot.
  arr[j] = pivot 

  //Return the last high element not in the list.
  return j
}

```
</p>
</details>
