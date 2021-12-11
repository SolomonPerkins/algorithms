package main


import (
	"fmt"
	"container/list"
)


type customQueue struct {
	queue *list.List
}


func (c customQueue) Enqueue(value string) {
	c.queue.PushBack(value)
}

func (c customQueue) DeQueue() (string, error) {

	if c.queue.Len() < 1 {
		return "", fmt.Errorf("Queue is empty")
	}

	if val, ok := c.queue.Front().Value.(string); ok {
		return val, nil
	}
	
	return "",nil
}

func (c customQueue) Size() int {
	return c.queue.Len()
}

func (c customQueue) Empty() bool {
	return c.queue.Len() == 0
}


func main() {
	el := []string{"1","3", "6", "10"}

	q := &customQueue{
		queue: list.New(),
	}

	for _, val := range el {
		q.Enqueue(val)
	}

	fmt.Printf("The size of the queue is: %d", q.Size())
	
}