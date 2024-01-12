

![Flyweight ](https://www.tutorialspoint.com/design_pattern/images/flyweight_pattern_uml_diagram.jpg)

# FlyWeight

Used to reduce the number of objects created and to decrease memory footprint or increase performance.
It accomplish this by attempting to reuse existing similar objects by storing them and creating new object only when needed. `Eg. Drawing 20 circles but there are only 5 different colors, so you end up only draing 5 circles.`



## Implementation

- Create a shape interface and a concrete class.
- Create a ShapeFactory hashMap of all the Shapes and use the color as key.





<details open>
<summary>Flyweight Pattern</summary>

```java
//The interface
public class TreeType{
    private String name;
    private String olor;
    private  String texture;


    public TreeType(name, color, texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }
    
    public draw(canvas, x, y) {

    }
}

public class TreeFactory {
    private TreeType type;
    private int x;
    private int y;

    public static getTreeType(String name, color, texture) {
        type = treeTypes.find(name, color, texture);
        if(type == null) {
            type = new TreeType(name, color, texture);
            treeTypes.add(type);
        }
        return type;
    }

}

public class  Tree {
    private int x,y;
    private TreeType type;

    Tree(x, y, type) {}

    public draw(canvas) {
        tree.draw(canvas, this.x, this.y)
    }
}


public class Forest {
    private List<Tree> trees;

    plantTree(x, y, name, color, texture) {
        type = TreeFactory.getTreeType(name, color, texture);
        tree = new Tree(x,y, type);
        trees.add(tree);
    }

    draw(canvas) {
        foreach(tree in trees) {
            tree.draw(canvas);
        }
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