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

//Ensures that NSLog doesn't have errors/timestamp and program name
#define NSLog(FORMAT, ...) printf("%s\n", [[NSString stringWithFormat:FORMAT, ##__VA_ARGS__] UTF8String]);

void convertToArmyTime(){
    char cLocalTime[11];
    scanf("%s", cLocalTime);
    NSString* localTime = [NSString stringWithUTF8String:cLocalTime];
    
    NSString* hours = [localTime substringWithRange:NSMakeRange(0, 2)];
    NSString* minutes = [localTime substringWithRange:NSMakeRange(3, 2)];
    NSString* seconds = [localTime substringWithRange:NSMakeRange(6, 2)];
    NSString* meridian = [localTime substringWithRange:NSMakeRange(8, 2)];
    
    NSInteger militaryHour = [hours integerValue];
    
    if([meridian isEqualToString:@"PM"]){
        militaryHour = militaryHour % 12 == 0? 0 : militaryHour % 12 + 12;
    }
    
    NSLog(@"%@%li:%@:%@",(militaryHour < 10)?@"0":@"", (long)militaryHour , minutes, seconds );

}

#endif /* Warmup_h */
