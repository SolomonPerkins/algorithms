

![alt text](https://imgs.developpaper.com/imgs/3644773978-5c7757d29f745_articlex.png "Algorithms Are Here")


# Description

Performs sorting using a heap data structure and utilizes the special tree base strucutre. A head has the following properties:

+ It is a complete tree
+ Root has the largest value.

Think of this as an improved `selection sort`. As a result it categorize a list into sorted and unsorted list.


A heap is a binary tree and there are two types of heapsorts:

1. minHeap:
   > The value of the parent node is less than or equal to the value of its left & right children.
2. maxHeap:
    > The value of the parent is greater than or equal to the value of its left and right children.

3. 



# Use Cases

1. Good for large datasets. 

## Scenarios:

+ `Use to perform sorting on large dataset`:
  + > Useful if that data can fit in memory.


# Disadvantages
1. Not as effecient as a well organized quick sort.
2. This is not stable sorting algoritm: `It will perform swaps for elements even if they are the same value`.


# Pseudocode

1. Form the heap using the data
   > This build a `buildMaxHeap()` using O(n) 
2. Remove the largest element on the heap.
3. Reform the heap and find the next largest data.
   > The `shiftDown()` using O(n log n)
4. Repeat step 2 & 3 until the list is empty.




# Code Snippet


<details>
<summary>Heapsort</summary>

<p>

```go

type minheap struct {
    arr []int
}

func (m *minheap) leftchildIndex(index int) int {
    return 2*index + 1
}

func (m *minheap) rightchildIndex(index int) int {
    return 2*index + 2
}

func (m *minheap) swap(first, second int) {
    temp := m.arr[first]
    m.arr[first] = m.arr[second]
    m.arr[second] = temp
}

func (m *minheap) leaf(index int, size int) bool {
    if index >= (size/2) && index <= size {
        return true
    }
    return false
}

func (m *minheap) downHeapify(current int, size int) {
    if m.leaf(current, size) {
        return
    }
    smallest := current
    leftChildIndex := m.leftchildIndex(current)
    rightRightIndex := m.rightchildIndex(current)
    if leftChildIndex < size && m.arr[leftChildIndex] < m.arr[smallest] {
        smallest = leftChildIndex
    }
    if rightRightIndex < size && m.arr[rightRightIndex] < m.arr[smallest] {
        smallest = rightRightIndex
    }
    if smallest != current {
        m.swap(current, smallest)
        m.downHeapify(smallest, size)
    }
    return
}

func (m *minheap) buildMinHeap(size int) {
    for index := ((size / 2) - 1); index >= 0; index-- {
        m.downHeapify(index, size)
    }
}

func (m *minheap) sort(size int) {
    m.buildMinHeap(size)
    for i := size - 1; i > 0; i-- {
        // Move current root to end
        m.swap(0, i)
        m.downHeapify(0, i)
    }
}

//Output the values.
func (m *minheap) print() {
    for _, val := range m.arr {
        fmt.Println(val)
    }
}

```
</p>
</details>
