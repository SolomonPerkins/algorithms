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


/***
 https://www.hackerrank.com/challenges/sherlock-and-squares
 Sherlock Square: Finding the total squared integers between a range A and B
 using the formula: (n+1)^2 - n^2 = 2n+1
 
 O(n)
 
 *||*||*||* THIS CODE RUNS OVER 2seconds. NEED TO LET IT RUN LOWER THAN THAT *||*||*||*
*/
int countSquares(long long int currentNumber, long long int endNumber, int count ){
    
    if(currentNumber > endNumber)
        return count;
    //Determine if the number has a square root.
    long double sqareRoot = sqrtl(currentNumber);
    //count if number is a perfect square
    if(sqareRoot != 0){
        //remove decimals(Case to int then cast back to double)
        count += (long double)(sqareRoot / ((long long int) sqareRoot)) > 1 ? 0 : 1;
    }
    return countSquares(currentNumber+1, endNumber, count);
}

void sherlockSquare(){
    int testCases;
    scanf("%d", &testCases);
    long long int A[testCases];
    long long int B[testCases];
    for(int currentCase = 0; currentCase < testCases; currentCase++){
        scanf("%lld %lld", &A[currentCase], &B[currentCase]);
    }
    
    for(int currentCase = 0; currentCase < testCases; currentCase++){
        printf("%d\n", countSquares(A[currentCase], B[currentCase], 0));
    }
}

/***
  Improved version of sherlockSquare
 * Calculate the square of upper and lower bound, and find the difference between the two.
 * Ensure to handle the case where: 1) both are equal or 2) lower bound is perfect square
 
 O(n)
**/

bool isPerfectSquare(long a){

    long sqareA = (long)sqrt(a * 1.0);
    if(sqareA * sqareA  == a){
        return true;
    }
    return false;
}

/*
 Count square between a range by taking the root of each number and subtract it.
 */
int squareCount(long A, long B){
    long rootA, rootB;
    
    rootA = (long)sqrt(A * 1.0);
    rootB = (long)sqrt(B * 1.0);
    
    if(A == B && isPerfectSquare(A)){
        return 1;
    }
    else if(isPerfectSquare(A)){
        return (int)(rootB - rootA + 1);
    }
    else {
        return (int)(rootB - rootA);
    }
};

void sherlockSquare_IMPROVED(){
    int testCases;
    scanf("%d", &testCases);
    long A[testCases];
    long B[testCases];
    for(int currentCase = 0; currentCase < testCases; currentCase++){
        scanf("%ld %ld", &A[currentCase], &B[currentCase]);
    }
    for(int currentCase = 0; currentCase < testCases; currentCase++){
        printf("%d\n", squareCount(A[currentCase], B[currentCase]));
    }
};


/****
 *  https://www.hackerrank.com/challenges/service-lane
 *  Service lane
    Find the min. vehicle which can passthrough different segmented service lanes: 1= bike, 2=car 3=truck
 */

int passThrough(int current, int exit, int vehicleType, int *segment, int segmentLength){
    if(current == exit + 1){
        return vehicleType;
    }
    //Exit if found a bike exit as this is the smalles vehicle
    if(vehicleType == 1){
        return vehicleType;
    }
    //Search through and find the element with the smalles unit
    if(segment[current] < vehicleType){
        vehicleType = segment[current];
    }
    return passThrough(current+1, exit, vehicleType, segment, segmentLength);
};

void serviceLane(){
    int testCases, freewayLength;
    
    scanf("%d %d",&freewayLength, &testCases);
    int segments[freewayLength]; //the witdh for each segment of the freeway
    int vehicleSegment[testCases];  //Array holding the min. vechile per segment.
    int start, exit;
    
    //Run the length of the freeway
    for(int freewayIndex = 0; freewayIndex < freewayLength; freewayIndex++){
        scanf("%d", &segments[freewayIndex]);
    }
    
    //Run for each test case
    for( int currentCase = 0; currentCase < testCases; currentCase++){
        scanf("%d %d", &start, &exit);
        vehicleSegment[currentCase] = passThrough(start, exit, segments[start-1], segments, freewayLength);
    }
    
    for( int currentCase = 0; currentCase < testCases; currentCase++){
        printf("%d\n", vehicleSegment[currentCase]);
    }
};







#endif /* Implementation_h */
