

![Composite Design Pattern](https://www.tutorialspoint.com/design_pattern/images/composite_pattern_uml_diagram.jpg)

# Composite Design Pattern

Used when a class contains group of its own objects. This is done when you need to treat a group of ojects in a similar way as you do with a single object.

## Implementation
- Create an interface or abstract class
- Create a concrete class which has a list of the abstract class/interface.



<details open>
<summary>Abstract Build Pattern</summary>

```java
//The Interface
public abstract class Employee {
    private String name;
    private String dep;
    private List<Employee> subordinates;


    public Employee(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    public void add(Employee e) {
        subordinates.add(e)
    }
    public void remove(Employee e) {
        subordinates.remove(e.name)
    }

    public getSubOrdinates() {
        return subordinates;
    }
    
}

```


```java
//The Composite pattern
public class CompositePatternDemo {

    public static void main() {
        Employee ceo = new Employee("John Doe", "CE");
        Employee headSale = new Employee("Mike Tomphson", "Marketing");
        Employee salesExec = new Employee("Matthew Palmer", "Sales Exec");

        ceo.add(headSale);
        headSale.add(salesExec);
    }
}
```
</details>