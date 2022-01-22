
![](https://www.tutorialspoint.com/design_pattern/images/facade_pattern_uml_diagram.jpg)

# Facade

This hides the complexities of the system and provides an interface to clients for them to communicate through.

This is done with the aid of a simple class providing simple methods on how to interact with the class.



<details open>
<summary>Abstract Build Pattern</summary>

```java
//The interface
public interface Shape {
    public void draw();
}

```

```java
public class Rectangle implements Shape {

    @Override
    public void draw() {
        //Do some drawing
    }
}

```


```java
public class Circle implements Shape {
    @Override
    public void draw() {
        //Do some drawing.
    }
}
```

```java
public class ShapeMaker {
    Shape circle;
    Shape rectangle;

    public void drawCircle() {
        circle = new Circle()
        circle.draw();
    }

    public void drawRectangle() {
        rect = new Rectangle()
        rect.draw();
    }

}

```


```java
public class ShapeMaker {
    public static vboid main() {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawRectangle();
        shapeMaker.drawCircle();
    }
}

```       
</details>