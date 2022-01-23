

![](https://sourcemaking.com/files/v2/content/patterns/State_example1.png?id=8baa1be293a1de79a6a7)



![](https://www.tutorialspoint.com/design_pattern/images/state_pattern_uml_diagram.jpg)

# State Design Patterns

This allows an object to alter its behaviour based on internal state changes. This is similar to an object-oriented state machine which is useful in performing certain actions based on run-time changes.


## Implementation

- Create a state interface and a concrete classes which implements the interface and are use to determine the various states.


<details open>
<summary>State Design Pattern</summary>

```java
public interface State {
    public void doAction(Context context)
}


```

```java
public class StartState implements State {


    @Override
    public void doAction(Context context) {
        //Do action based on the state
        context.setState(this);
    }

    @Override
    public String toString() {
        return "Start state";
    }
} 

```


```java
public class EndState implements State {


    @Override
    public void doAction(Context context) {
        //Do action based on the state
        context.setState(this);
    }

    @Override
    public String toString() {
        return "End state";
    }
} 


```


```java
public class Context {
    private  State state;

    public Context() {
        this.state = null;
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return this.state;
    }

}

```

```java
public class StateDemo {

    Context context = new Context();

    StartState start = new StartState();
    start.doAction(context);


    EndState end = new EndState();
    end.doAction(context);

    //Context
    //context.getStsate()
}

```
</details>