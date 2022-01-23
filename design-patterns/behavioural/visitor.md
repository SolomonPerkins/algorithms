

![](https://www.tutorialspoint.com/design_pattern/images/visitor_pattern_uml_diagram.jpg)

# Visitor
This lets you define a new operation without changing the classes of the elements which it operates. 


## Implementation





<details open>
<summary>Visitor Design Pattern</summary>
```java
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVisitor);
}


```

```java
public class Keyboard implements ComputerPart {

    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this)
    }
}

```


```java
public class Monitor implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        computerPartVisitor.visit(this);
    }
}

```

```java
public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mosue mosue);
    public void visit(Keyboard keyboard);
    
}
```


```java
public class VisitorPatternDEmo {
    public static void main() {

        ComputerPart computer = new Computer();
        computer.accept(new ComputerPartDisplayVisitor())
    }
}

```
</details>
