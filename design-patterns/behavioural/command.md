# Command

![Command Pattern](https://www.tutorialspoint.com/design_pattern/images/command_pattern_uml_diagram.jpg)

<hr/>

![Chef and Order](https://www.freecodecamp.org/news/content/images/2019/07/command-class-diagram.PNG)

A data driven design pattern where request is wrapped into an object (**command**) and passed to the invoker object.

## Implementation
For a scenario where someone is buying stocks

    - Create a command interface: order
    - Create a stock class which acts as the request/command payload: Stock
    - Create a concrete classs for each request type: BuyStock and SellStock implementing the Order interface.
    - Then create the invoker class: Broker 


<br/>
<details>
    <summary>Command Pattern | Buying Stocks</summary>

```java
public interface Order {
    void execute()
}

```

```java 
public class Stock {
    private String name = ""
    private int quantity = 10;

    public void buy() {
        //print buy stocks
        this.quantity +=1;
    }

    public void sell() {
        this.quantity -=1;
    }
}

```


```java
public class BuyStock implements Order{
    private Stock stock;

    public BuyStock(Stock s) {
        this.stock = s;
    }

    @Override
    public void execute() {
        this.stock.buy()
    }
}

```

```java
public class SellStock implements Order {
    private Stock stock;

    public SellStock(Stock s) {
        this.stock = s;
    }

    @Override
    public void execute() {
        this.stock.sell()
    }
}

```

```java
public class Broker {
  <br/>
<details>
    <summary>Command Pattern | Buying Stocks</summary>

```java
    public void takeOrder(Order order) {
        this.orderList.add(order);
    }

    public void placeOrders() {
        for(Order order : orderList) {
            order.execute()
        }

        orderList.clear();
    }
}
```


```java
public class StockMarketApp{

    public class main() {
        Stock abcStock = new Stock();
        Stock jmxStock = new Stock();

        BuyStock buyOrder = new BuyStock(abcStock);
        SellStock sellOrder = new SellStock(jmxStock)

        //Broker 
        Broker broker = new Broker();
        broker.takeOrder(buyOrder)
        broker.takeOrder(sellOrder);

        broker.placeOrders();
    }
}

```
</details>


<br/>
<details>
    <summary>Command Pattern | Chef Order</summary>

```java
//The oder interface
public interface Order {
    void execute()
}

```

```java
//the meal
public class Meal {
    private String name = "";
    private List<String> additionalDetails = new ArrayList<String>;
    private int cost = 0;
    private String state;
    
    public void order() {
        //Consuming the meal
        this.state = "ordered";
        this.cost = 240 ; //Could be a calculation based on the other details
    }

    public consume() {
        this.state = "consume";
    }
       
}

```

```java
//The types of requests/actions | takeOrder & deliverOrder & place order
public class OrderRequest implements Order {
    private Meal meal;

    public OrderRequest(Meal meal) {
        this.meal = meal;
    }

    @Override
    public void execute() {
        this.meal.order();
    }
}

```


```java 
//The delivery DeliveryRequest
public class DeliveryRequest implements Order {
    private Meal meal;

    public DeliveryRequest(Meal meal) {
        this.meals = meal;
    }

    @Override
    public void execute() {
        this.meal.consume();
    }
}

```

```java
public class Waiter {

    private List<Order> orderList = new ArrayList<Order>();

    public void recieveOrder(Order order) {
        this.orderList.add(order);
    }

    public void deliverMeal() {
        for(Order o : this.orderList) {
            o.execute();
        }

        this.orderList.clear();
    }

}

```


```java
//The resturant class
public class Resturant {

    public void main() {
        
        Meal soup  = new Meal();
        Meal rice = new Meal();

        //Waiters
        OrderRequest orderRequest = new OrderRequest(soup);
        DeliveryRequest deliveryRequest = new DeliveryRequest(rice);
        
        Waiter waiter = new Waiter();
        waiter.takeOrder(orderRequest);
        waiter.deliverOrder(deliveryRequest);

    }
}

```