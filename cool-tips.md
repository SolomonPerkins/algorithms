

# Description
A list of tips and tricks you can used when peforming various operations.


# Code Snippet


<details>
<summary>Iterate Over Multi-Dimensional Arrays In One Loop</summary>

<p>

```java
  /**
   * 1. Calculate total = rows * columns and loop through that range
   * 2. row = ith / columns
   * 3.  col = ith % columns
   * */

  //Iterate over array in range [0... rows * columns]
  for(int i = 0; i < rows * columns; i++) {
    //find row and column
    int row = i / columns;
    int col = i % columns;

    arr[row][cols]
  }

```
</p>
</details>

</hr>


<details>
<summary>ASCII Creating Shift Cipher Between A-Za-z and 0-9</summary>

<p>

```java
  /**
   * 1. How to rotate/encrypt the character to only encod within the A-Za-z or 0-9 but don't inlude other character
   * 2. For letter us 
   * 3.  col = ith % columns
   * */

  public int rotateCharacter(char c, int rotationFactor) {
    char startLetter = '0';
    if(Character.isLetter(c)) {
        startLetter = Character.isUpperCase(c) ? 'A' : 'a';
    } 
    int moded = Character.isLetter(c) ? 26 : 10; //If you mod from 26 char or 10 for digits
    return ((c - startLetter + rotationFactor) % moded) + startLetter;
  }

  // Shift cipher for only letters/characters
  String cipher(String msg, int shift){
    String s = "";
    int len = msg.length();
    for(int x = 0; x < len; x++){
        char c = (char)(msg.charAt(x) + shift);
        if (c > 'z')
            s += (char)(msg.charAt(x) - (26-shift));
        else
            s += (char)(msg.charAt(x) + shift);
    }
    return s;
}


```
</p>
</details>
