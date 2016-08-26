//
//  BigO-Basic.h
//  Algorithms
//
//
// Used to solve basic BigO problems
/***
 BASIC OPERATIONS AND THEIR BIG-O EFFECIEINCY
 
 LIST                          BIG-O
 ----------------------------------------
 index[]                       O(1)
 index assignment              O(1)
 append                        O(1)
 pop()//end                    O(1)
 pop(i)//not at index          O(n)
 insert(i, item)//insert at i  O(n)
 delete                        O(n)
 iteration                     O(n)
 contains/indexOf(n)           O(n)
 slice(x,y)                    O(k) //k = size of the list being extracted
 reverse                       O(n)
 concatenate                   O(k) //k = size of the list being concatenated
 sort                          O(n log n) //For python, their sorting function
 multiply                      O(nk)
 
 
 DICTIONARY                    BIG-O
 ----------------------------------------
 copy                           O(n)
 get item                       O(1)
 set item                       O(1)
 delete item                    O(1)
 contains                       O(1)
 iteration                      O(n)
 */
 


#ifndef BigO_Basic_h
#define BigO_Basic_h

#import <Foundation/Foundation.h>

/**
 * O(n^2): 1assignment + n^2(nested loop) + + 1 assignment
 * desc: Searching for smallest element in the list by looping through twice
 */
void findSmallestNumber (int * array, int count){
    int smallestNumber = nil;
    for(int index = 0; index < count; index++){
       
        for(int smallerIndex = index; smallerIndex < count; smallerIndex++) {
             //NSLog(@"Running: index %i. value: %i", smallerIndex , array[smallerIndex] );
            if(array[smallerIndex] < array[index]){
                smallestNumber = array[smallerIndex];
                
            }
        }
    }
    
    NSLog(@"findSmallestNumber: Smalles number is: %i", smallestNumber);
}


/**
 * O(n): 2assignment + n(1 for loop) + 1 another assignment
 * @description: Writing the function of finding the smallest element to solve the BigO
 */
void findSmallesNumberPart2 (int * array, int count){

    int index =0;
    int smallestNumber = array[index];
    for(++index; index < count; index++){
        if(array[index] < smallestNumber){
            smallestNumber = array[index];
        }
    }
    NSLog(@"findSmallestNumberPart2: Smallest number is: %i", smallestNumber);
}

/**
 * Check if a number is prime
 * Using the primality test method: If it is a prime from: m to √n (where n is value & m is range between 2<-> √n)
 * https://www.hackerrank.com/challenges/30-running-time-and-complexity
 */

char * isPrime(long num) {
    char *notPrime = "Not prime";
    char *prime = "Prime";
    
    if(num <= 1 ){
        return notPrime;
    }
    else if(num <= 3) {
        return prime;
    }
    else if(num % 2 == 0 || num % 3 == 0){
        return notPrime;
    }
    int count = 5;
    while ((count*count) < num) {
        
        if( num % count == 0 || num % (count + 2) == 0){
            return notPrime;
        }
        count+= 6;
    }
    
    return prime;
}


/**
 * Calculate the cost for a book returned to the library late.
 * https://www.hackerrank.com/challenges/30-nested-logic
 */


NSInteger calculateFine(NSInteger *returnTime) {
    int dailyRate = 15;
    int monthlyRate = 500;
    int yearlyRate = 10000;
    NSInteger rates[3] = {dailyRate, monthlyRate, yearlyRate};


    for (int i = 2; (i >= 0 && returnTime[2] > -1); i--) {
        if( returnTime[i] > 0 ) {
            if(i == 2) {
                return rates[i];
            } else {
                return rates[i] * returnTime[i];
            }
        }
    }
    //No charge if return before due date
    return 0;
}

void returnBook() {
    NSInteger actual[3] = {};
    NSInteger expected[3] = {};
    
    //Handle input for expected and actual return date
    scanf("%ld %ld %ld", &actual[0], &actual[1], &actual[2]);
    scanf("%ld %ld %ld", &expected[0], &expected[1], &expected[2]);
    NSInteger timeDiff[3] = {
        actual[0] - expected[0],
        actual[1] - expected[1],
        actual[2] - expected[2]
    };
    
    printf("%d", (int)calculateFine(timeDiff));
};


#endif /* BigO_Basic_h */
