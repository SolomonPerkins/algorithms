package main

import(
    "container/list"
    "fmt"
)
    
type customStack struct {
    stack *list.List
}

func (c customStack) Push(value string) {
    c.stack.PushFront(value)
}

func (c customStack) Pop() (string, error) {
    if c.stack.Len() < 1 {
        return "", fmt.Errorf("Stack is empty")
    }

    ele := c.stack.Front()
    c.stack.Remove(ele)

    return ele.Value.(string), nil
}

func (c customStack) Front() (string, error) {

    if c.stack.Len() < 1 {
        return "", fmt.Errorf("Stack is empty")
    }

    if val, ok := c.stack.Front().Value.(string); ok {
        return val, nil
    }

    return "", fmt.Errorf("Invalid value returned")
}

func (c customStack) Size() int {
    return c.stack.Len()
}

func (c customStack) Empty() bool {
    return c.stack.Len() == 0
}


// Palidrome
func main() {
	s := &customStack{
		stack: list.New(),
	}

	elements := []string{"1","2","4","6","7","8"}

    for _, element := range elements {
        s.Push(element);
    }

    fmt.Printf("Size of stack: %d", s.Size())
}
