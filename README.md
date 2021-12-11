
# Algorithms
Every crafts man needs a toolset. Consider this as my toolbox for software engineer. 

This is a list of all algorithms I've come in contact with and their respective use cases.



Yes, these resources are online that can access them instantly. \
But there is nothing more powerful than knowledge - and refreshing that knowledge -. This long term (hobby) project is my toolbox of useful algorithms.

![](https://videos.teamtreehouse.com/stills/TH-Algorithms-SortingSearching-S1V10-stills-4.jpg?token=620d2c49_46b78aa27073f82593ccf44a8474c75c5d182b83 "The Big O Notion")
<small>Attempting to solve for: Big 3s O (Worst), Ω (Medium/Omega), and Θ (Best/Theta)</small> 


This diagram effectively translates into a more readable manner:
![The Notions](https://miro.medium.com/max/731/1*k7E8_6npsyPkaIEyw37yyQ.png "The Possible Notion")



<details>
<summary>Constant: O(1)=Ω(1)=Θ(1)</summary>

```java
function constant(Array a)
    println(a[1])
end

```

</details>

---
<details>
<summary>Linear: O(n)=Ω(n)=Θ(n)</summary>

```java
function linear(Array a)
    for i = 1:length(a) {
        println(a[i])
    }
end

```

</details>

---
<details>
<summary>Polynomial Time (Nested loops): O(1)=Ω(1)=Θ(n<sup>2</sup>) </summary>

```java
//Example to access 2D, 3D, 4D objects.
//This will take a long time. Try avoid if possible.
function access(a[][], size) 
    for i = 1:size
        for l = i:size
            println(a[i][l])
        end
    end 
end

```

</details>

---

**Recursion can provide you with the fastest (logarithm) solution or some of the slowest (exponential). Therefore the use case for this is impmortant.**
<details>
<summary>Exponential Time: Θ (2<sup>n</sup>) </summary>

```java
//Not good as you're calling the recusive function twice.
function exponential(val, n) 

    println(val)
    value += 1
    exponential(val, n-1)
    exponential(val, n-1) 
end

```
</details>


<details>
<summary>Logarithm Time: Θ(log(n)) </summary>

```java
// This is good case of recursion. 
// Each time you're spliting the problem into smaller problems.
function logarithm(Array a, String cutoff) 

    if length(a) < cutoff 
        return a
    end

    logarithm(a[1, length(a)/2], cutoff)
    logarithm(a[length(a)/2+1, length(a)-1], cutoff)
end

```
</details>
