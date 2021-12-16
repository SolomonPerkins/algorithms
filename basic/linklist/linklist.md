

![Linked List](https://www.tutorialspoint.com/data_structures_algorithms/images/linked_list.jpg "Linked List")

_source: tutorialspoint.com_


# Description
This is the second most popular datastructure apart from arrays.

This is a sequence of elements connected together in a list, with each link having a link/connect to the next element. A linked list is comprised of:

- `Link` the data stored in each element 
- `Next` a reference to the next element in the list
- `LinkedList` A reference to the first element **head** in the list.


## Types
- `Single Linked List` - You can navigate in only one direction (forward)
- `Double Linked List` - Each link/node has a reference to the next and previous (allow to navigate in both direction)
- `Circular Linked List` - There is no end in the list. 

# Use Cases

## Scenarios:

+ `Image Slider, Music Playlist`:
  > User selecting the previous and next buttons to navigate through various images

+ `Determining The Max, Min of large numbers`:
  > Using a double linked list can help you keep track of minimum (head) and also the maximum (tail). This would allow the algorithm to run in order of O(1).

+ `Bitcoin`:
  > The fundamental concept used in Bitcoin ledger is an immutable linked-list. You are able to add transactions to the list but not pull from it.

+ `Circular Linked List: Good for repeatable tasks`:
  > For items where you're constantly going around a particular order, this tasks can help to be similar to a queue.\
  **Fibonacci Heap** is one of the implementation of a Double Circular LinkedList. 

+ `Train mapping stations and other step navigations`: 
  > Each stations having the information needed and also a link to the next station.


# Disadvantages

+ `Memory usage`
+ `List Traversal` : This is more time consuming than an array
+ `Random no access`: You're not able to access elements randomly
+ `Reverse Traversal`: You can't traverse in the opposite direction of a Single LinkedList.



# Pseudocode

## Adding A Node

- Step 1: Create the note

![create link](https://www.tutorialspoint.com/data_structures_algorithms/images/linked_list_insertion_0.jpg)

- Step 2: Connect new node to the next element

![Add to next](https://www.tutorialspoint.com/data_structures_algorithms/images/linked_list_insertion_1.jpg)


- Step 3: Update preceeding node reference and set it to the new node

![update previous reference](https://www.tutorialspoint.com/data_structures_algorithms/images/linked_list_insertion_2.jpg)


## Deletion is the sampe process as adding.



# Code Snippets

<details>
<summary>LinkedList</summary>

<p>

```go

type Node struct {
  data string
  next *Node
}

type LinkedList struct {
  head *Node
}

func (l LinkedList) insert(n *Node) {}

func (l LinkedList) delete(value string) {}

func (l LinkedList) display() {}

func (l LinkedList) search(value string) *Node {}

```
</p>
</details>


----

## Linked List Algorithms

### `Floyd's Tortoise and hare` Algorithm

[Medium.com](https://medium.com/@edgar-loves-python/the-tortoise-the-hare-and-the-cyclical-linked-list-1b51acab5b "Medium.com")

This algorithm is used to determine if a linked list is cyclical. There are instances when a linked list can be cyclical and as a result impact system performance. The solution is to use an hare and a tortise. An hare being a fast runner, while a tortoise being a slow running can help to determine if a linked list is cyclical. If the hare catches up to the tortise, that means the list is cyclic. **The Floyd's algorithm is space efficient when compared to other options**

![cyclical example](https://miro.medium.com/max/700/1*q4kOhLvTsrhlrbpbgILMnw.png "Cyclical")
<small>An example of medium.com</small>


While there are alternative options such as:

+ Using a `set` to keep track of previously traversed locations. Once an existing node was found, then it is safe to assume that the linked list is cyclical. **This can be memory intensive and not good as it is `space inefficient` challenge.**


<details>
<summary>LinkedList</summary>

<p>

```go

func tortoiseAndHare(head *node) bool {

  fast := head
  slow := head

  while fast in fast.next_node {
    slow = fast.next_node
    fast = fast.next_node.next_node //Notice the hare is travelling faster than the tortoise
    
    if fast == slow {
      return true
    }
  }

  return false

}



```
</p>
</details>


