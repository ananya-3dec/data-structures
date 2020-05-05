package com.example;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinimumSwaps2 {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int minIndex = 0;
        int min = arr[minIndex];
        int diff=0;
        boolean sort = false;
        for (int i=1; i< arr.length; i++) {
            if (min>arr[i]){
                minIndex = i;
                min = arr[minIndex];
                sort = true;
            }
            if (arr[i] < arr[i-1]) {
                sort = true;
            }
        }
        if (!sort) {return 0;}
        int swaps = 0;
        int temp = 0;
        if (minIndex != 0) {
            temp = arr[0];
            arr[0] = arr[minIndex];
            arr[minIndex] = temp;
            swaps = 1;
            minIndex = 0;
        }
        for (int i=1; i<arr.length;){
            diff = arr[i] - arr[i-1];
            if (diff == 1) {
                minIndex = i;
                 i++;
            } else {
                temp = arr[minIndex + diff];
                arr[minIndex + diff] = arr[i];
                arr[i] = temp;
                swaps ++;
            }

        }

        return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);

        System.out.print(String.valueOf(res));
        System.out.println();

        scanner.close();
    }
}
