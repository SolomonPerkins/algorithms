//
//  BigO-Basic.h
//  Algorithms
//
//
// Used to solve basic BigO problems

#ifndef BigO_Basic_h
#define BigO_Basic_h

#import <Foundation/Foundation.h>

/**
 * O(n^2):
 * desc: Searching for smallest element in the list by looping through twice
 */
void findSmallestNumber (int * array, int count){
    int smallestNumber ;
    for(int index = 0; index < count; index++){
       
        for(int smallerIndex = index; smallerIndex < count; smallerIndex++) {
             NSLog(@"Running: index %i. value: %i", smallerIndex , array[smallerIndex] );
            if(array[smallerIndex] < array[index]){
                smallestNumber = array[smallerIndex];
                
            }
        }
    }
    
    NSLog(@"Smalles number is: %i", smallestNumber);
}


/**
 *
 *
 */

#endif /* BigO_Basic_h */
