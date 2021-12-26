

![Bubble Sort](https://upload.wikimedia.org/wikipedia/commons/c/c8/Bubble-sort-example-300px.gif "Bubble Sort")

<source>Wikipedia.com</source>

<br/>

# Description
The slowest form of sorting algorithm in the simple sorting category. 


__Runs on a worst case scenario O(n<sup>2</sup>). It is not a practical sorting algorithm.__

# Use Cases

1. Verify an existing list is already sorted.

## Optimize:
You can optimize bubble sort by putting the largest element in the final place in the list. This avoids the inner loop  from going to the last element.


# Disadvantages

+ The only advantage this has over quicksort, insertion sort is that it quickly determines if the list is sorted. When the algorithm is already sorted **best case** then it runs on O(n).



# Pseudocode

1. Compare each element with the adjacent element
2. Swap each element if it is not in the list of options.
3. Repeat step 1 and 2 until you're at the end of the list.




# Code Snippet


<details>
<summary>Bubble Sort</summary>

<p>

```go

func bubbleSort(arr []int ) []int {
  //For each element loop through it
  for i := 0; i < len(arr); i++ {

      //Loop over the list again and compare each element
      for j := 0; j < len(arr) - 1; j++ {
          
          //Swap element if the current is greater than it's sibling
          if arr[j] > arr[j+1] {
              arr[j], arr[j+1] = arr[j+1], arr[j]
          }
      }
  }
}

```
</p>
</details>
