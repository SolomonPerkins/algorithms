

![Merge Sort](https://cdn.programiz.com/cdn/farfuture/PRTu8e23Uz212XPrrzN_uqXkVZVY_E0Ta8GZp61-zvw/mtime:1586425911/sites/tutorial2program/files/merge-sort-example_0.png "Merge Sort")

![Another Example](https://qvault.io/wp-content/uploads/2021/06/merge_sort_gif.gif "Merge Sort Another Example")

# Description
Uses the divide and rule concept to effeciently compare two elements in a list.


**This is useful for both small and large datasets and it runs on O(n log n)**.

There are other algoritms which uses this strategy including: Binary Search, Merge Sort and Quick Sort.


# Use Cases
1. Use to sort large datasets.
2. 

## Scenarios:

+ `Scenario 1`:
  + > Example details


# Disadvantages
1. Requires extra **memory** to perform operation. Not ideal if you're scarce on memory.
2. Recursion have significan resource overhead. 



# Pseudocode

1. Divide the list recursively into two or more sub-problems, until it cannot be done
2. Solve the sub problems until is is reached to the base case
3. Merge the smaller list into the new list






# Code Snippet


<details>
<summary>Merge Sort</summary>

<p>

```go

func mergeSort(arr []int) []int {
  //The base case
  if len(arr) < 2 {
      return arr
  }

  //seperator
  middle := len(arr) / 2
  //Divide the first half
  first := mergeSort(arr[:middle])
  //Divide the second half
  second := mergeSort(arr[middle:])

  //Merge the arrays
  return merge(first, second)

}

func merge(first []int, second []int) []int {
    final := []int{}

    i := 0 
    j := 0

    //
    for i < len(first) && j < len(second) {

        if first[i] < second[i] {
            final = append(final, first[i])
            i++
        } else {
            final = append(final, second[i])
            j++
        }
    }

    //Adding the remaining elements to the list.
    for ; i < len(first); i++ {
        final = append(final, first[i])
    }

    //Adding the remaining second elements to the list.
    for ; j < len(second); j++ {
        final = append(final, second[j])
    }

    return final
}

```
</p>
</details>
