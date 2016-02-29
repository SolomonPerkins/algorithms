//
//  Warmup.h
//  Algorithms
//
//  Created by Muser on 2/28/16.
//  Copyright © 2016 Muser. All rights reserved.
//

#ifndef Warmup_h
#define Warmup_h

/**
 https://www.hackerrank.com/challenges/a-very-big-sum
 Calculating sum of large numbers using long
 
 */

void sumLargNumbers(){
    long total = 0;
    int count;
    scanf("%d", &count);
    long array[count];
    
    for(int index = 0; index < count; index++){
        scanf("%li", array[index]);
        //total = total + array[index];
    }
    printf("%li", total);
}

/**
 * https://www.hackerrank.com/challenges/diagonal-difference
 * Calculate the sum of a dialog matrix NxN
 * 11 2 4
 *  4 5 6
 * 10 8 -12
 * Sum = (11+5+ (-12)) - (4+5+10)
 */

void sumofNxNMatrix(){
    int n,
    total =0,
    primary_dialog_sum = 0,
    secondary_dialog_sum = 0;
    scanf("%d", &n);
    int matrix[n][n];
    for(int row =0; row < n; row++){
        for(int column =0; column < n; column++) {
            scanf("%d", &matrix[row][column]);
            //Adding the primary dialog
            if(row == column) {
                primary_dialog_sum += matrix[row][column];
            }
        }
    }
    
    //Adding the secondary dialog
    for(int row = 0, column = n - 1; row < n; row++, column--){
        secondary_dialog_sum = secondary_dialog_sum + matrix[row][column];
    }
    printf("%d", abs(primary_dialog_sum - secondary_dialog_sum));
}

#endif /* Warmup_h */
