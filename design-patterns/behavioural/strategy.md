
![](https://sourcemaking.com/files/v2/content/patterns/Strategy_-2x.png?id=793445e7cdc0004586f3)

---

![](https://www.tutorialspoint.com/design_pattern/images/strategy_pattern_uml_diagram.jpg)


# Strategy Design Pattern

This keeps a family of abstraction encapsulated and are interchage based on the run-time need. This is done by also hiding the implementation details in derived classes.

## Implementation

- Create stategy interface and concrete stategy class.



<details open>
<summary>Template Design Pattern</summary>

```java
public interface Strategy {
    public init doOperation(int num1, int num2)
}

```

```java
public class OperationAdd implements Strategy {
    @Override
    public init doOperation(int num1, int num2) {
        return num1 + num2
    }
}

```

```java
public class OperationSubtract implements Strategy {
    @Override
    public init doOperation(int num2, int num2) {
        return num1 - num2
    }
}

```
```java
public class OperationMultiply implements Strategy {
    @Override
    public init doOperation(int num2, int num2) {
        return num1 * num2
    }
}

```

```java
public class StrategyPattern {
    public static void main() {
        Context context = new Context(new OperationAdd());
        context.executeStrategy(10, 5);

        context = new Context(new OperationSubtract());
        context.executeStrategy(10, 5)

        context = new Context(new OperationMultiply());
        context.executeStrategy(10, 5);
    }
}

```

</details>