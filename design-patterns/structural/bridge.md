![](https://media.geeksforgeeks.org/wp-content/uploads/Bridge_Design.png)

# Bridge Design

This design pattern allows you to separate the abstraction from the implementation. 

## Implementation
- It contains 2 main parts: `Abstraction` & `implementation`

- Allows for the development of the abstraction and the implementation separately.
- The interface/abstract class and the implementer is also an interface.
- The abstraction contain a reference to the implementer.
- It uses the favor `composition over inheritance` design principle.
- It improves the loose coupling between class abstraction and implementation


## Elements
- `Abstraction`: core of the bridge design pattern, it contains a reference to the implementer
- `Refined Abstraction`: Extends the abstraction and takes care of the finer details
- `Implementer`: the interface for the implementation class.
- `Concrete implementation`: Implents the above implentyer by providing the concrete implementation.

## Usecases
- It decouple the abstraction from its implementation
- Used mainly for implementing platform indepence features
- Useful for run-time binding of the implementation.

<hr/>

### Example Of Impelementation
![](https://media.geeksforgeeks.org/wp-content/uploads/BridgeDesign3.png)

<details open>
<summary>Adapter Pattern</summary>

```java
//The abstract bridge
abstract class Vehicle {
    protected Workshop workshop1;
    protected Workshop workshop2;

    protected Vehicle(Workshop workshop1, Workshop workshop2) {
        this.workshop1  = workshop1;
        this.workshop2 = workshop2;
    }

    abstract public void manufacture();
}

```


```java
//Refine abstraction 1
class Car extends Vehicle {
    public Car(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2)
    }

    @Override
    public void manufacturer() {
        //do manufacturing of car.
        workshop1.work();
        workshop2.work();
    }
}

```

```java
//The refine abstraction
class Bike extends Vehicle {
    public Bike(Workshop workshop1, Workshop workshop2) {
        super(workshop1, workshop2)
    }

    @Override
    public void manufacturer() {
        //do manufacturing of car.
        workshop1.work();
        workshop2.work();
    }
}

```

```java
//Implementor
interface Workshop {
    abstract public void work();
}
```

```java
//The Concrete Implementation
class Produce implements Workshop {
    
    @Override
    public void work() {
        //TODO perform work of a producer
    }
}
```

```java
//Another Concrete Implementation
class Assemble implements Workshop {
    @Override
    public void work() {
        //TODO do some work
    }
}

```

```java
//The Demo

public class BridgePattern {
    
    public void main() {

        Produce produce = new Produce();
        Assemble assemble = new Assemble();

        //Create the car
        Car  car = new Car(produce, assemble);
        Bike bike = new Bike(produce, assemble);

        //Manufacture
        car.manufacture()
        bike.manufacture();
    }
}

```
</details>