
![Adapter Pattern](https://www.tutorialspoint.com/design_pattern/images/adapter_pattern_uml_diagram.jpg)

# Adapter Pattern
Allows object with incompatible interfaces to interact/collaborate with each other. This is done using a single `adapter` class, used to communicate between independent or incompatible interfaces.

## The Pattern Is Comprised Of:
- Client: A class that wants to consume an incompatible third-party app.
- Target: An interface that needs to be implemented by the adapter and use by the client.
- Adapter: Implements the target interface and has a reference to the adaptee
- Adaptee: Contains the functionality required by the client but is not compatible with client code.



## Benefits
- Encourages Single REsponsibility Principle (because each conversion code is separate)
- Increate transparency and reusability
- Follow the open-close principle.

## Disadvantage:
- Too many adapters can make system messy and difficult to maintain.

<details open>
<summary>Adapter Pattern</summary>

```java
//The interface
public interface MediaPlayer {
    public void play(String audioType, String fileName);
}


```

```java
public interface AdancedMediaPlayer {
    public void playVlc(String fileName);
    public void playMp4(String fileName);
}
```


```java
public class VlcPlayer implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fname) {

    }

    @Override
    public void playMp4(String fname) {
        //do nothing
    }
}
```

```java
public class Mp4Player implements AdvanceMediaPlayer {
    @Override
    public void playVlc(String fname) {
        //Do nothing
    }
    @Override
    public void playMp4(String fname) {
        
    }
}

```

```java
public class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancePlayer;

    public MediaAdapter(String audioType) {

        if(audioType.equalIgnoreCase("vlc")) {
            advancePlayer = new VlcPlaer();
        } else if(audioType.equalIgnoreCase("mp4")) {
            advancePlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        //Play the music
        if(audioType.equalIgnoreCase("vlc")) {
            advancePlayer.playVlc(fileName);
        } else if (audioType.equalIgnoreCase("vlc")) {
            advancePlayer.playMp4(fileName);
        }
    }

}

```


```java
//The player adapter which will be exposed to others
public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {

        if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType)
            mediaAdapter.play(audioType, fileName);

        } else {
            //Exception around this.
        }
    }
}
```


```java
public class AdapterPatterDemo {
    public static void main(String[] args) {
        AudioPlayer player = new AudioPlayer();

        player.play("mp4", "beyond the horizon.mp4")
        player.play("vlc", "alone.mp4");
    }
}

```
</details>
