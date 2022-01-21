# Prototype

![The Pattern](https://www.tutorialspoint.com/design_pattern/images/prototype_pattern_uml_diagram.jpg)

This refers to creating duplicate object while keeping performance in mind. `This is one of the best ways to create an object especially when the creation of objects are costly`. `This uses both shallow (default) and deep copy techniques to manage references.` 

## Implementation
- Implement a prototype interface which tells to create a clone of the current object.
- Create a cache repository which is used to generate the classes as needed

<details open> 
<summary>Prototype Pattern</summary>

```java
public abstract class Shape implements Cloneable {
    private String id;
    protected String type;

    public String getType() {
        return type
    }
    public void setId(String id) {
        this.id =id;
    }

    //The method which handles cloning of object.
    public Object clone() {
        Object clone = null;
    
        try {
            
            clone = super.clone();

        } catch(CloneNotSupportedException e) {
            e.printStackTrace()
        }

        return clone;
    }
    
    //The abstract to override
    abstract void draw();
}

```

```java
//Implementation of shape
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Rectangle";
    }

    @Override
    public void draw() {

    }
}

```


```java
//How they're integrated
public class ShapeCace {
    private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId) {
        Shape cachedShape = shapeMap.get(shapeId);
        return (Shape) cachedShape.clone();
    }


    //Load cache
    public static void loadCache() {
        Rectangle circle = new Rectangle();
        circle.setId("something")

        shapeMap.put(circle.getId(), circle);
    }
}

```
</details>