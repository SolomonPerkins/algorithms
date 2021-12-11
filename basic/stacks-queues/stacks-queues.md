

![alt text](https://media.geeksforgeeks.org/wp-content/uploads/geek-queue-1.png "queue")

![alt text](https://media.geeksforgeeks.org/wp-content/uploads/geek-stack-1.png "Stack")



# Description
Stacks and queue are simple data structures that holds multiple elements, but allow you to only use one element at any given time.

Primary difference between stacks and queues is the oder you can access the elements in.

+ Stack is `Last In First Out (LIFO)`.

+ Queue is `First In First Out (FIFO)`.
+ 

# Use Cases  

## Scenario: Stacks and queues are useful when:

+ Organizing a partial list is on-going.
+ `Exmample 1: Cheapest flights` 
  > Ahead of time, you don't have a list of all flights to search through. Possible process. Think of the possible airlines and put them in a queue. Take first item off the queue. 
  </br>
  </br>
  > if "airline", find all flights from Sea-Tac to Cleveland 12/23 or 12/24 and add each to queue.
  </br>
  </br>
  > if "flight", examine price, time, day, etc. and decide if it's good enough to stop
Keep going until queue is empty, or until you decide to stop.

+ `Example 2: Tracking possibilities.`

    > Searching for a path in a maze. If you have an algorithm that search and find all the possible move in a maze, you can try and find a sequence that works. </br>
    > You can use a stack to keep track of all the possibilities Popping from the stack to get a possibilitiy. </br>
    > This can be used to have the same effect as recursion.

    </br>

+ `Example 3: Palindrome`
  
    > The reverse of a word is the inverse of the actual word. Normally spaces and capitalization are ignored. </br>
    > "Madam, I'm Adam".</br>
    > "A man, a plan, a canal – Panama!" 

</br>

 + [References Of Documents (PDF)](https://courses.cs.washington.edu/courses/cse143/02au/slides/18b-SAndQ-applications.pdf).

</br>


# Disadvantages

## Queue:

This can be implemented in two ways, `Arrays` or `LinkedList`. Arrays have a constant space while LinkedList are slow.


# Pseudocode & Concepts

## Stack

+ Loop at the first element `top()`
+ remove the first element `pop()`
+ push elements on to the data structure `push()`


## Queue

+ remove element from the end `dequeue()`
+ look at the element at the first element `front()`






