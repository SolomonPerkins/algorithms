
![](https://sourcemaking.com/files/v2/content/patterns/Interpreter_example1.png?id=6e18c37efd5aa7086a60)


![](https://www.tutorialspoint.com/design_pattern/images/interpreter_pattern_uml_diagram.jpg)

# Interpreter
This is used to evaluate language or grammatical expressions. This invovles an the implementation of an interface which tells of the particular context. This is used in SQL parser or symbol processing engine etc.

`This is useful when a group of problems occurred in a well-defined and well-understood domain. If the domain where characterize as a "language", then the problems could be solved using a defined engine.`

## Implementation
- Create an Expression interface.
- Create an implementation of an Expression





<details open>
<summary>Interpreter Design Pattern</summary>

```java
//Public interface
public interface Expression {
    public boolean interpret(String context)
}

```

```java
//
public class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    @Override
    public boolean interpret(String context) {
        if(context.contains(data)) {
            return true;
        }

        return false;
    }
}

```

```java
//An interpreter in the or logic
public class OrExpression implements Expression {
    private Expression expr1 = null;
    private Expression expr2 = null;

    public OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(expr2)
    }
}

```

```java
//And logic
public class AndExpression implements Expression {
    private Expression expr1 = null;
    private Expression expr2 = null;

    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(expr2)
    }
}
```

```java
//The expression
public class InterpreterDemo {

    public static Expression getMaleExpression() {
        Expression rober = TerminalExpression("Robert");
        Expression john = TerminalExpression("John");

        return OrExpression(rober, john);
    }

    public static void main() {

        boolean isMale = InterpreterDemo.getMaleExpression();
    }
}

```

</details>