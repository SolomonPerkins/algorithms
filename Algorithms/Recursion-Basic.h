//
//  Recursion.h
//  Algorithms
//
//  Created by Muser on 2/24/16.
//  Copyright © 2016 Muser. All rights reserved.
//

#ifndef Recursion_h
#define Recursion_h

/**
 * Adding multiple numbers
 */
int sumNumbers (int * array, int count){
    if(count ==0){
        return array[count];
    }
    else {
        //NSLog(@"%d + ", array[count]);
        return array[count] + sumNumbers(array, count - 1);
    }
}

/**
 * Reverse a string.
 */

NSString* reverseString(NSString* string, count){
    if(count == 0){
        NSLog(@"%c ", [string characterAtIndex:count]);
        return [NSString stringWithFormat:@"%c",[string characterAtIndex:count]];
    }
    else{
        return  [reverseString(string, count -1)
                    stringByAppendingString:[NSString stringWithFormat:@"%c",[string characterAtIndex:count]]];
    }
};

/***
Testing Recursive functions 
*/

void recursiveSubtract(int number){
    int first = 20,
        second = 40;
    
    if(number > 1 ) {
        NSLog(@"First: Subtracking %d from %d ", second, number);
        recursiveSubtract(number - second);
        NSLog(@"Second: Subtracking %d from %d ", second, number);
        recursiveSubtract(number - second);
    }
    return;
}

#endif /* Recursion_h */
