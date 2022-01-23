![](https://www.tutorialspoint.com/design_pattern/images/mediator_pattern_uml_diagram.jpg)

![](https://sourcemaking.com/files/v2/content/patterns/Mediator__1.png?id=24df208d27b3f5598673)


![](https://sourcemaking.com/files/v2/content/patterns/Mediator_example.png?id=c5d98a93020aedaab9fb)

# Mediator 
This is used to decouple tighly coupled module by implementing a mediator between each. It is also used to promote many-to-many relationships. Thereby reducing communication complexities between multiple objects.

## Implementation

- A simple implementation of this is a chatroom. Where many users can communicate within a chat room.



<details open>
<summary>Mediator Design Pattern</summary>

```java
public class ChatRoom {
    public static void showMessage(User user, String message){
         //Print the message
         user.getName() + message
    }
}

```


```java
//This method using the static method as the mediator to send message between all users.
public class User {
    private String name;

    public String getName() {
        return this.name;
    }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}


```java

public class MediatorDemo {
    public static void main() {
        User robert = new User("Robert");
        User john = new User("John")

        robert.sendMessage("Something interesting");
        john.sendMessage("What?" );
    }
}
```

</details>