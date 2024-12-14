package simple;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.IntStream;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;


// https://www.hackerrank.com/challenges/big-sorting/problem?isFullScreen=true



public class bigSort {
 /*
     * Complete the 'bigSorting' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts STRING_ARRAY unsorted as parameter.
     */

    public static List<String> bigSorting(List<String> unsorted) {
        // Write your code here
        Integer startIndex = 0;
        Integer endIndex = unsorted.size() - 1;
        
        mergeSort(unsorted, startIndex, endIndex);
        return unsorted;
    }

    static void mergeSort(List<String> unsorted, Integer leftStart, Integer rightEnd) {
        if(leftStart >= rightEnd) {
            return;
        }
        Integer middle = (leftStart +  rightEnd )/2;
        mergeSort(unsorted, leftStart , middle);
        mergeSort(unsorted, middle + 1, rightEnd);
        mergeHalves(unsorted, leftStart, rightEnd);
    }

    static void mergeHalves(List<String> unsorted, Integer start, Integer end) {
        //copy data into the temp array
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        List<String> result = bigSort.bigSorting(unsorted);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
