![Abstract Factory](https://www.tutorialspoint.com/design_pattern/images/abstractfactory_pattern_uml_diagram.jpg)


# Abstract Factory


This pattern is similar to the [factory method pattern](./factory-method.md), but there is a super-factory method (a factory which creates other factory). This is one of the best ways to create an object

## Implementation
  
  - Create a shape interface
  - Create all the concrete class implementation of the shape class.
  - Create an abstract factory and extend that factory with other factory.

## When To Use
- When you want to make the code extensible but you don't know all the implementatio beforehand or you want it to be exensible.


<details open>
<summary>Abstract Build Pattern</summary>

```java
//The basic interface
public interface Shape {
    void draw()
}

```

```java
//Implementation
public class RoundedRectangle implements Shape {
    @Override
    public void draw() {
        //Draw the object
    }
}

```


```java
public class Rectangle implements Shape {
    @Override
    public void draw() {
        //Do the drawing.
    }
}
```

```java
public abstract class AbstractFactory {
    abstract Shape getShape(String type);
}

```

```java
//The shape factory method
public class ShapeFactory extends AbstractFactory {
    @Override 
    public Shape getShape(String type) {
        if(type.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle()
        } 
        else type.equalsIgnoreCase("Square")) {
            return new Square();
        } 
    }
}


```


```java
//The factory producer
public class FactoryProducer {
    public static AbstractFactory getFactory(boolean rounded) {
        if(rounded) {
            return new RoundedShapeFactory();
        } else {
            return new ShapeFactory()
        }
    }
}
```
</details>