# Decorator Pattern

!["The Design"](https://www.freecodecamp.org/news/content/images/2019/07/decorator-class-diagram.png)

<hr>

![Shapes](https://www.tutorialspoint.com/design_pattern/images/decorator_pattern_uml_diagram.jpg)

!["Coffee Shop Selling Coffee"](https://www.freecodecamp.org/news/content/images/2019/07/decorator-class-diagram.png)

<hr />

Allows us to add new functionality to an existing object without altering its structure. Effectively honoring the **Open-Close Principle**.

This pattern creates a decorator pattern which wraps the original class and provides additional functionality which keeps the class intact.

- Once the object is open to change, this approach is useful in keeping the structure in tact.
- Useful to help keep up with changes to the structure and other modifications AKA Decorator.


<br/>
<details>
    <summary>Coffee Shop | Multiple Additives</summary>

```java
//The abstract class
public abstract class Beverage  {
    private String description;

    public Beverage(String description) {
        super()
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public abstract double cost();
}
```


```java
//Different decorator/versions/modifications
public class HouseBlend extends Beverage {
    public HouseBlend() {
        super("House Blend")

    }

    @Override
    public double cost() {
        return 250;
    }

}

```

```java
//Another decorator/versions/modifications.
public class DarkRoast extends Beverage {
    public DarkRoast() {
        super("Dark roast")

    }

    @Override
    public double cost() {
        return 300;
    }
}
```

```java
//The abstract class which is an addOn will be used for modification.
public abstract class AddOn extends Beverage {
    protected Beverage beverage;


    public AddOn(String desc, Beverage beverage) {
        super(desc)
        this.beverage = beverage;
    }

    public abstract String getDescription();
}

```

```java
//Setting up a flavor/decorator without modifying the existing class.
public class SugarAddOn extends AddOn {
    public SugarAddOn(Beverage bev) {
        super("Sugar", bev)

    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with sugar"
    }

    @Override
    public Double cost() {
        return beverage.cost() + 10;
    }
}

```


```java
public class MilkAddOn extends AddOn {
    
    public MilkAddOn(Beverage bev) {
        super("Milk", bev)
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + " with milk"
    }

    @Override
    public Double cost() {
        return beverage.cost() + 35;
    }
}

```


```java
public class CoffeeShop {

    
    public void main() {
        HouseBlend houseBlend = new HouseBlend();
        System.out.println(houseBlend.getDescription() + " cost " + houseBlend.cost())

        MilkAddOn milk = new MilkAdd(houseBlend);
        SugarAddOn sugar = new SugarAddOn(houseBlend);
    }
}

```
</details>



<br/>
<details>
    <summary>Shapes | Multiple Additivess</summary>

```java

public abstract class Shape {
    protected String name;

    public Shape(String name) {
        this.name = name;
    }

    public abstract draw();
}

```

```java 
public class Rectangle extends Shape {
    public Rectangle() {
        super("Rectangle")
    }

    @Override
    public void draw() {
        //Printing 
    }
}

```


```java
public abstract class ShapeDecorator extends Shape {
    protected Shape shape;

    public ShapeDecorator(String name, Shape shape) {
        super(name)

        this.shape = shape;
    }

    public void draw() {
        shape.draw();
    }
}
```

```java
public class CustomShape extends ShapeDecorator {
    public CustomShape(Shape shape) {
        super("Custom Shape", shape)
    }

    public void setDecorator() {
        //Do something.
        shape.draw()
    }
}

```
</details>