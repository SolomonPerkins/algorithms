package main

import (
	"fmt"
)

type node struct {
	data string
	next *node
}

type LinkedList struct {
	head *node
	tail *node
	length int
}

func (l LinkedList) PushBack(n *node) {

	if l.head == nil {
		fmt.Printf("NEW: %s\n", n.data)
		l.head = n
		l.tail = n
		l.length++
	} else {
		fmt.Printf("ADDING: %s\n", n.data)

		l.tail.next = n
		l.tail = n
		l.length++
	}
	fmt.Printf("\nData: %s\n", l.head.data)
}

func (l *LinkedList) Delete(key string) {

	if l.head.data == key {
		l.head = l.head.next
		l.length--
		return
	}
	var prev *node = nil
	curr := l.head
	
	for curr != nil && curr.data != key {
		prev = curr
		curr = curr.next
	}
	
	if curr == nil {
		fmt.Println("Key Not found")
		return
	}
	prev.next = curr.next
	l.length--
	
	fmt.Println("Node Deleted")
}

func (l LinkedList) Display() {
	
	n := l.head
	
	for n != nil {
		fmt.Printf("( %s ) -->", n.data);
		n = n.next
	}

}


func main() {

	n1 := node{
		data: "T",
	}
	n2 := node{
		data: "O",
	}

	llist := LinkedList{}

	llist.PushBack(&n1)
	llist.PushBack(&n2)

	llist.Display()

}