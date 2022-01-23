
![](https://sourcemaking.com/files/v2/content/patterns/Template_method_example.png?id=d5f4969ed9a502093a81)

---

![](https://www.tutorialspoint.com/design_pattern/images/template_pattern_uml_diagram.jpg)

# Template Design Pattern

This defines a skeleton of an algorithm each objects should be based from. 

## Implementation

- Create an abstract class which defining operations with a template method.
- Create concerete class that extends and override the methods.



<details open>
<summary>Template Design Pattern</summary>

```java
//The abstract class
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();

    //Tepmlate method
    public final void play() {

        initialize()

        startPlay();

        endPlay();
    }
}

```

```java
public class Cricket extends Game {
    @Override 
    public void endPlay() {
        //Print finish
    }

    @Override
    public void initialize() {
        //
    }

    @Override
    public void startPlay() {

    }


}

```

```java
public class TemplatePatternDemo {

    public static void main() {
        Game game = new Cricket();
        game.play();

        game = new Football();
        game.play();
    }
}

```
</details>
