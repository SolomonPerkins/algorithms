//
//  main.m
//  Algorithms
//
//  Created by Muser on 2/22/16.
//  Copyright © 2016 Muser. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "BigO-Basic.h"
#import "Recursion-Basic.h"
#import "Warmup.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        int count = 5;
        int array[5] = {4,23, 3, 34, 1};
        findSmallestNumber(array, count);
        findSmallesNumberPart2(array, count);
        
        NSLog(@"Recursive total: %d", sumNumbers(array, count -1));
       // NSLog(@"Recurvice reverse string: %@", [NSString stringWithFormat:@"%c",reverseString(@"Welcome", 6)]);
        
//        sumLargNumbers();
//        sumofNxNMatrix();
//        fractionOfPrecision();
        stairCase(6, 0, '#');
    }
    return 0;
}
