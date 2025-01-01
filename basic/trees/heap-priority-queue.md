

![Min / Max Heap](../../assets/heap-data-structure.png "Algorithms Are Here")

# Description
A priority queue is an abstract data type which allows you to insert or extract data with a priorty. 

Heap trees are always complete (meaning you need at least two left nodes, not one).




# Use Cases
1. `Min heap` - Used to extract the minimum value efficiently.

> This heap has the minimum value at the top. 
> If new items are inserted, the entire set should be checked to ensure it is balance. 

2. `Max heap` -  Used  to extract the maximum value efficiently.


## How To Optimize

### Traverse Using Array

Since the elements are in the correct order (top to bottom, left to right), we can convert it down to an array and ensure the indecies are valid.
> This will help us to make sure we are space efficient.

1. Assign elements starting at index 0 from left to right.
 `arr=[5, 7, 6, 9, 8, 10, 18, 26, 17, 15]`

               (5)
            /      \
        (7)        (6)
      /    \       /   \
    (9)     (8)   (10) (18)
  /   \     /
(26) (17)  (15)

2. To traverse left:
`arr[2i + 1]` = {2=7, 4=9, 8=26}

3. To traverse right:
`arr[2i + 2]` = {3=6, 7=18}


## Scenarios:

+ `Scenario 1`:
  + > Example details


# Disadvantages







# Code Snippet


<details>
<summary>Code Snippet</summary>

<p>

```go

func fn() {
  //Code here
}

```
</p>
</details>
