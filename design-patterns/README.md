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

    + [Decorator](./structural/decorator.md): `Handle ever changing objects buy adding different flavors/decorators.`
    + [Adapter](./structural/adapter.md): `Integrate incompatible interfaces to communicate`
    + [Bridge](./structural/bridge.md): `For platform independent features. Useful for run-time binding implementations.`
    + [Composite](./structural/composite.md): `An class/interface with a nested version of itself and they are treated as one object.`
    + [Facade](./structural/facade.md): ` Hide the complexities of class behind an interface. Thus providing one simple class for services/client to use.`
    + [Flyweight](./structural/flyweight.md): `Help save memory or performance by storing objects in hashmaps`
    + [Proxy](./structural/proxy.md): `Create an intermdiate object to interface and do action as a proxy.`

3. ## Behavioural Patterns
   > These patters are designed depending on how classes communicate with each other.

   + [Command](./behavioural/command.md): `A request as a command without knowing anything about the operation being requested.`
   + [Chain of Responsibility](./behavioural/chain-of-responsibility.md): `A linked list type of handles which pass on the operation until it is complete. The requester don't know which implementation will handle the request.`
   + [Observer](): `One-to-many relationship of multiple subscriber/observer on a subject.`
   + [Interpreter](./behavioural/interpreter.md): `Resolving a problem "language" by using an expression within a well defined domain`
   + [Interator](./behavioural/iterator.md): `Used to iterator over a list of objects in a sequential manner.`
   + [Mediator](./behavioural/mediator.md): `A middleman/mediator used in many-to-many relationships to decouple the classes during communication.`
   + [Memento](./behavioural/memento.md): `Used to keep track of the various states of an object.`
   + [State](./behavioural/state.md): `Similar to a state machine, this will keep track of various states.`
   + [Template](./behavioural/template.md)
   + [Strategy](./behavioural/strategy.md)
   + [Visitor](./behavioural/visitor.md) 






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