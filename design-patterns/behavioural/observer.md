
![](https://sourcemaking.com/files/v2/content/patterns/Observer_example1.png?id=1e2910c6c124d3532af3)

![](https://www.tutorialspoint.com/design_pattern/images/observer_pattern_uml_diagram.jpg)

# Observer Design Pattern

The observer design pattern is a one-to-many relationships, where many objects are depending on a state change. It is similar to the subscription model, where multiple objects subscribe to one object. Once the state changes all are notified: eg: rss feeds.


## Implementation
- Comprises of: 
  - Subject
  - Observer
  - Client
- Create a Subject will be the object which attaches (subscribe) and detaches (unsubsribe) observers.



<details open>
<summary>Observer Design Pattern</summary>

```java
//The class which handles all the subscriptions
public class Subject {
    private List<Observer> observers = new ArrayList<Observer>();

    private int state;

    public int getState() {
        return state;
    } 

    //Update the state and then notify all of the change.
    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer ob) {
        observers.add(ob);
    }

    public void notifyAllObservers() {
        for(Observer ob : observers) {
            ob.update();
        }
    }
}

```

```java
//The observer abstract class
public abstract class Observer {
    protected Subject subject;

    //The state
    public abstract void update(); 
}

```

```java
//An observer/implementation.
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
    }

    public void update() {
        //Pull the subject details
        this.subject.getState();
    }

}

```


```java
//Another observer
public class HexaObserver extends Observer {

    public HexaObserver(Subject sub) {
        this.subject = sub;
    }

    public void update() {
        this.subject.getState();
    }
}

```

```java
//The implementation
public class ObserverPattern {
    //Create subject
    Subject abcNews = new Subject();
    
    //Create the observer
    HexaObserver ob1 = new HexaObserver(abcNews);
    BinaryObserver ob2 = new BinaryObserver(abcNews);


    abcNews.setState(10);

    abcNews.setState(1232);

}

```
</details>
