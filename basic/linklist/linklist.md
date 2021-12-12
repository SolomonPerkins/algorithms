

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

+ `Scenario 1`:
  + > Example details


# Disadvantages




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
