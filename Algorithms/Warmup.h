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
};

/***
 *https://www.hackerrank.com/challenges/plus-minus
 * Fraction of each precision: % of positive, negative and zero
 *
 *
 */
void fractionOfPrecision(){
    int n,
    total[3] = {0};
    //Store number
    scanf("%d", &n);
    float array[n];

    for(int index = 0; index < n ; index++){
        scanf("%f", &array[index]);

        if(array[index] <= 0 ){
            if(array[index] == 0) {
                total[2] += 1;
            }
            else {
                total[1] += 1;
            }
        }
        else {
            total[0] +=1;
        }
    }
    
    for(int index =0; index < 3; index++) {
        int result = total[index];
        printf("%.6f\n", (float)result/n);
    }
    
}

/***
 https://www.hackerrank.com/challenges/staircase
 Staircase: print a stair case based on N input
 eg. N = 3
   #
  ##
 ###
 */

//Build each row of step
void buildSteps(int remaining,char block){
    if(remaining < 0){
        return;
    }
    printf("%c", block);
    buildSteps(remaining-1, block);
};
//Clears the path to where step should begin creating each row of steps
void clearPath(int block){
    if(block ==0){
        return;
    }
    printf(" ");
    clearPath(block -1);
}
//Handles building of the stair case.
void stairCase(int n, int width,char block){
    if(n == 0){
        return;
    }
    clearPath(n-1);
    //Build each row of step
    buildSteps(width, block);
    //Move to the next row.
    printf("\n");
    stairCase(n - 1, width+1, block);
};



/**
 *https://www.hackerrank.com/challenges/time-conversion
 * Convert regular time to military time
 *eg. 12:00:00AM to 00:00:00
 */
void convertToArmyTime(){
    
    int min;
    int hr;
    float sec;
    char merd[2];
    
    //Take in a formatted input. NB: C has problem with scanning interger with leading 0 (user float instead)
    scanf("%d:%d:%f%s", &hr, &min, &sec, merd);
    bool exist = strcmp(merd, "PM") >= 0;
    
    //If PM and not midnight update army time value
    if( exist && hr != 12){
        hr += 12;
    }
    //If morning just began start hour @ 0
    else if(!exist && hr == 12){
        hr = 0;
    }
    
    printf("%02d:%02d:%02d", hr, min, (int)sec);
}

#endif /* Warmup_h */
