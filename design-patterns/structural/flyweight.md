

![Flyweight ](https://www.tutorialspoint.com/design_pattern/images/flyweight_pattern_uml_diagram.jpg)

# FlyWeight

Used to reduce the number of objects created and to decrease memory footprint or increase performance.
It accomplish this by attempting to reuse existing similar objects by storing them and creating new object only when needed. `Eg. Drawing 20 circles but there are only 5 different colors, so you end up only draing 5 circles.`



## Implementation

- Create a shape interface and a concrete class.
- Create a ShapeFactory hashMap of all the Shapes and use the color as key.





<details open>
<summary>Abstract Build Pattern</summary>

```java
//The interface
public interface Shape{

    void draw();
}

public class Circle implements Shape {
    private String color;
    private int x;
    private int y;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        //Do some drawing
    }
}

```


```java
//The shape factory
public class ShapeFactory {
    private static final Map<String, Shape> shapes = new HashMap<String, Shape>();

    public ShapeFactory() {

    }

    public static Shape getCircle(String color) {

        Circle circle = (Circle) shapes.get(color);

        if (circle == null) {
            circle = new Circle(color)
            shapes.put(color, circle)
        }

        return circle;
    }
} 
```

</details>