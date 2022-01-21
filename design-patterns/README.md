# Design Patterns

There are three main classification of design patterns:

1. ## Creational Patterns
    > These patterns are designed for class instantiation. They can be either class-creation patterns or object-creational patterns.
    
    + [Singleton](./creational/singleton.md) : `Only one instance of an object.`
    + [Builder](./creational/builder.md) : `To build complex objects.`
    + [Prototype](./creational/prototype.md): `Effeciently clone objects (useful db intensive type apps).`
    + [Factory Method](./creational/factory-method.md) : `Encapsulate the creation process`
    + [Abstract Factory](./creational/abstract-factory.md): `Best way to do factory method. Creates a factory (producer) for the factory`

2. ## Structural Patterns
    > These patters are design with regard to class structure and composition. The main gola of these patterns is to increate functionality of the class(es) invovled without changing most of its composition.

    + [Decorator](./structural/decorator.md)
    + [Adapter]()
    + [Bridge]()
    + [Composite]()
    + [Facade]()
    + [Flyweight]()
    + [Proxy]()

3. ## Behavioural Patterns
   > These patters are designed depending on how classes communicate with each other.

   + [Command](./behavioural/command.md)
   + [Chain of Responsibility]()
   + [Observer]()
   + [Interpreter]()
   + [Interator]()
   + [Mediator]()
   + [Memento]()
   + [State]()
   + [Template]()
   + [Strategy]()
   + [Visitor]() 






<br/>


# Design Principles


1. ## Single-Responsibility
    > One class should do one thing and do it well.

2. ## Open-Close 
   > Open for extension, close for modification

3. ## Liskov Substitution
   > Sub type must be substitute for supertype


4. ## DRY (Don't Repeat Yourself)
   > Avoid duplication of code


5. ## KISS (Keep it Simple, Stupid)
    > Keep your code simple, small and understandable.

6. ## Programe to Interface NOT Implementation 
   > 