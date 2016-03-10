//
//  Implementation.h
//  Algorithms
//
//  Created by Muser on 3/4/16.
//  Copyright © 2016 Muser. All rights reserved.
//

#ifndef Implementation_h
#define Implementation_h

/**
 https://www.hackerrank.com/challenges/angry-professor
 Angry Professor: Dismissing class if the number of students coming to class late is below a threshold
 O(n)
 */

//Determine if a student is late
char* late(int stud, int threshold){
    int eligible = 0;
    int studentTime;
    //Late is determined if they came in before a set time: ie. negative or zero
    for(int count = 0; count < stud; count++){
        scanf("%d", &studentTime);
        if(studentTime <= 0){
            eligible +=1;
        }
    }
    return eligible >= threshold ? "NO\n" : "YES\n";
};

void angryProfessor(){
    int testCases;
    scanf("%d", &testCases);
    //For each student determine if they are late.
    for(int curr =0; curr < testCases; curr++){
        int students, threshold;
        scanf("%d  %d", &students, &threshold);
        
        printf("%s", late(students, threshold));
    }
};


/***
 https://www.hackerrank.com/challenges/sherlock-and-the-beast
 Sherlock and the beast.
 Trying to find the largest number, where the number of 5s or 3s is divisible by their opposite
 eg. 3 = 555 (three 5's and 3 is divisible by 3)
 eg. 11 = 555 555 33333 ( six 5's ( 6 is divisible by 3) and five 3's (and 5 is divisible by 5): 6 + 5 = 11 digits)
 O(n)
 */

//Print the number of required digits
void print5s3sCombination(int amount, int setsofThree){
    
    //Checking for 3s
    for(int i =0; i < setsofThree; i++){
        printf("%d", 5);
    }
    //Checking for the 5s
    for(int i =0; i < (amount - setsofThree ); i++){
        printf("%d", 3);
    }
    printf("\n");
};

//Find the largest of each digit to be used
void printDigits(int digitCount){
    int count = digitCount;
    //validation
    if(digitCount < 3){
        printf("%d\n",-1);
        return;
    }
    
    //1.check if when divide by 3 if is a whole number
    if(digitCount % 3 == 0){
        for(int i =0; i < count; i++){
            printf("%d",5);
        }
        printf("\n");
        return;
    }
    
    //Check what proportion of 3s & 5s are factors
    for(count; count > 0; count--){
        if(count % 3 == 0 && (digitCount - count) % 5 == 0){
            return print5s3sCombination(digitCount, count);
        }
    }
    
    //4. Check if 5 is divisible factor
    if(digitCount % 5 == 0){
        for(int i =0; i < digitCount; i++){
            printf("%d",3);
        }
        printf("\n");
        return;
    }
    
    printf("%d\n",-1);
};

void sherlockAndTheBeast(){
    int testCases;
    scanf("%d", &testCases);
    int results[testCases];
    
    //Take in user input
    for(int currentCase = 0; currentCase < testCases; currentCase++){
        scanf("%d", &results[currentCase]);
    }
    //print out results
    for(int currentCase = 0; currentCase < testCases; currentCase++) {
        printDigits(results[currentCase]);
    }
    
};

/**
 https://www.hackerrank.com/challenges/utopian-tree
 Utopian tree: finding the height of a tree after X growth cycles.
            - Defualt height: 1m
            - Spring height doubles
            - Summer height increase by 1
 
 O(n)
 */
int calculate(int height, int cycle,int count){
    if(count > cycle){
        return height;
    }
    //For summer height +1
    if(count % 2 == 0){
        height +=1;
    }
    //For spring height X2
    else {
        height *= 2;
    }
    return calculate(height, cycle, count+1);
};

void utopianTree(){
    int initialHeight = 1;
    int cycles;
    int testCases;
    scanf("%d", &testCases);
    int heights[testCases];
    
    for(int currentCase = 0; currentCase < testCases; currentCase++){
        scanf("%d", &cycles);
        heights[currentCase] = calculate(initialHeight, cycles, 1);
    }
    
    for(int currentCase = 0; currentCase < testCases; currentCase++){
        printf("%d\n", heights[currentCase]);
    }
};

/***
 https://www.hackerrank.com/challenges/find-digits
 Find Digits: Count the number of digits N can be divided by without leaving a remainder
 
 */
//Recursive call, count divisible digits per test case
int digitCount(long long int number, long long int holdNum, int count){
    int lastDigit;
    if(number == 0){
        return count;
    }
    lastDigit = number%10;
    if(lastDigit != 0)
        count += holdNum % lastDigit == 0 ? 1 : 0;
    //printf("<<<<< count:%d last:%d divi:%lld num:%lld\n", count, lastDigit, holdNum % lastDigit, number);
   return digitCount((long long int)number/10, holdNum, count);
};

void findDigit(){
    int testCases;
    scanf("%d", &testCases);
    long long int number[testCases];
    for(int currentCase = 0; currentCase < testCases; currentCase++){
        scanf("%lld", &number[currentCase]);
    }
    for(int currentCase = 0; currentCase < testCases; currentCase++){
        printf("%d\n", digitCount(number[currentCase],number[currentCase], 0));
    }
}

#endif /* Implementation_h */
