

![](https://sourcemaking.com/files/v2/content/patterns/Chain_of_responsibility_1.png?id=9f8237404da365ba3044)


![](https://www.tutorialspoint.com/design_pattern/images/chain_pattern_uml_diagram.jpg)

# Chain Of Responsibilities

This is used to handle commands/requests when the requester doesn't know how or who will be the handler. As a result, the requester doesn't know who handles the request. `A linked list of requests/objects`

    This is a type of Launch-and-leave apporach, similar to an ATM machine (where you punch in the card and ask for $. The machine will pass commands until you get the correct amount as you've requested.)


## Implementation
- Create an abstract class eg: `Logger`
- Create create conceret classs to handle the various scenarios


<details open>
<summary>Chain Of Responsibility</summary>

```java
//The Abstract log class
public abstract class AbstractLogger {
    protected static int INFO = 1
    protected static int DEBUG = 2
    protected static int ERROR = 3

    protected int level;


    //The next logger (LinkedList type)
    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger logger) {
        this.nextLogger = logger;
    }

    public void logMessage(String message, int level) {
        if(level <= level) {
            write(message)
        }
        //The logger pass the details to the next chain of command 
        if (nextLogger != nill) {
            nextLogger.logMessage(message, level)
        }
    }

    abstract protected void write(String message); 
}


````

```java
//A Concerent implementation and a chain in the command

public class ConsoleLogger extends AbstractLogger {

    public ConsoleLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        //Write a message
    }
}

```

```java 
//A concerete Implementation and a chain in the command
public class FileLogger extends AbstractLogger {
    protected static String filename = "";

    public FileLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        //Write to file.
    }
}

```


```java 
//A concerete Implementation and a chain in the command
public class DebugLogger extends AbstractLogger {
    
    public DebugLogger(int level) {
        this.level = level;
    }

    @Override
    public void write(String message) {
        //Write to file.
    }
}

```

```java
//The combination of the pattern

public class ChainPattern {

    //Create the class
    public static AbstractLogger getChainOfLoggers(){
        AbstractLogger infoLogger = new ConsoleLogger(AbstractLogger.INFO);
        AbstractLogger debugLogger = new ConsoleLogger(AbstractLogger.DEBUG);
        AbstractLogger fileLogger = new ConsoleLogger(AbstractLogger.ERROR);

        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(fileLogger);

        return infoLogger;
    }

    public static void main() {
        AbstractLogger chains = ChainPatter.getChainOfLoggers();
        
        //Will handle the info
        chains.logMessage("This is an info", AbstractLogger.INFO);

        //Will pass on or delegate to the next element in the chain
        chains.logMessage("This is an error log" , AbstractLogger.ERROR);

        //Will pass on to the debug chain in the command
        chains.logMessage("This is a debug message", AbstractLogger.DEBUG);


    }
}

```
</details>

 