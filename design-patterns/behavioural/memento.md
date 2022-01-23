![](https://sourcemaking.com/files/v2/content/patterns/Memento_example.png?id=91a87e6d9ccde8241829)


![](https://www.tutorialspoint.com/design_pattern/images/memento_pattern_uml_diagram.jpg)



# Memento

Used when you want to roll back an object to its original state `undo` or `rollback.`.

## Implementation
- This uses three actor classes:
  - Originator: this creates and store the state
  - Caretaker: this is responsible to restore the object
  - Memento: this contains the current state to be restored.




<details open>
<summary>Mediator Design Pattern</summary>

```java
//The memento
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return this.state;
    }
}


````
```java
//The originator: creates the states 
public class Originator {
    private String state;

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveStateToMemento() {
        return new Memento(this.state);
    }

    public void getStateFromMemento(Memento memento) {
        this.state = memento.getState();
    }
}


````
```java
//Thge Caretaker

public class CareTaker {
    private List<Memento> mementoList = new ArrayList<Memento>();

    public void add(Memento state) {
        mementoList.add(state);
    }

    public Memento get(int index) {
        return this.mementoList.get(index);
    }
}


````

```java
public class MementoPatternDemo {

    public static void main() {

        //Originator 
        Originator originate = new Originator();
        CareTaker careTaker = new CareTaker();

        originator.setState("State 1");
        originator.setState("State 2");
        careTaker.add(originate.saveStateToMemento());

        //
        originate.setState("State 3");
        careTaker.add(originator.saveStateToMemento())


        //Get the first save state
        originator.getStateFromMemento(careTaker.get(0));
                
    }
}

```


</details>