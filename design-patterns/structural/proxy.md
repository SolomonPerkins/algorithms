
![Proxy Design Pattern](https://www.tutorialspoint.com/design_pattern/images/proxy_pattern_uml_diagram.jpg)

# Proxy Design Pattern

As the name suggest, this is used to represent functionality of another class.

## Implementation

- Create an interface
- Create a proxy class from that interface
- Then create the real class from that interface.





<details open>
<summary>Abstract Build Pattern</summary>

```java
//The interface
public interface Image {
    void display()
}


```


```java
//The real class
public class ReadImage implements Image {

    private String filename

    public ReadIamge(String filename) {
        this.filename = filename;
    }
    
    @Override
    public void display() {
        //This displays the image
    }

    public loadFromDisk() {
        //Load filename from disk
    }
}

```


```java
//This is the proxy class
public class ProxyImage implements Image {
    private String filename
    private RealImage image;

    public ProxyImage(String filename) {
        this.filename;
    }

    @Override
    public void display() {
        //The image will only load once.
        if(image == null) {
            image = new RealImage(this.filename);
        }

        image.display();
    }
}

```
</details>