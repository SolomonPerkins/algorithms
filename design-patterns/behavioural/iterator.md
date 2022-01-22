
![](https://sourcemaking.com/files/v2/content/patterns/Iterator_example1.png?id=d9ad627a886a78eb0552)

![](https://www.tutorialspoint.com/design_pattern/images/iterator_pattern_uml_diagram.jpg)


# Iterator
This is a way of accessing the collection of objects in a sequential manner.

# Implementation
- Create the Iterator interface.
- Create a container interface  which will be responsible for the interator interface.



<details open>
<summary>Iterator Design Pattern</summary>

```java
//The iterator
public interface Iterator {
    public boolean hasNext();
    public Object next();
}

```


```java
//The container interface
public interface Container {
    public Iterator getIterator()
}

```

```java
//The concerete class for the container
public class NameRepository implements Container {
    

    @Override
    public Iterator getIterator() {
        return new NameIterator();
    }
}

```

```java
//The name iterator
public class NameIterator implements Iterator {
    private int index = 0;



    @Override
    public boolean hasNext() {
        //HAs the next 
        if(index < names.length()) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        if(this.hasNext()) {
            return this.names[index++];

        }
        return null
    }
}

```


```java
public class NameIteratorDemo {

    public static void main() {
        NameRepository nameRepo = new NameRepository();

        for(Iterator iter = nameRepo.getIterator(); iter.hasNext();) {
            String name = (String) iter.next();
        }
    }
}

```
</details>