
# Introduction

Most programming languages have a particular interface you can use to perform sorting. 

GoLang is no exception. 

Once you implement an interface with the following, you will be able to do sorting on O(n log(n)) without reinventing the wheel. This uses **quick sort algoritm to perform the sorting**


[Link to article](https://qvault.io/golang/sorting-in-go-dont-reinvent-this-wheel/)



```go

type Interface interface {
    //Len is the number of elements in the collection
    Len() int

    //Reports whether the element at index i is less than that of index j
    Less(i, j) bool

    Swap(i, j int) 
}

```


# Code Snippet

<details>
<summary>Example Of GoLang QuickSort Library</summary>

<p>

```go

type mType []int


func (m mType) Len() int {
	return len(m)
}

func (m mType) Less(i, j int) bool {
	return m[i] < m[j]
}

func (m mType) Swap(i, j int) {
	m[i], m[j] = m[j], m[i]
}


```
</p>
</details>