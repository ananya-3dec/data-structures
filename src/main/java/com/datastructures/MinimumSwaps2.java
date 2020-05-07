package com.datastructures;

import java.io.*;
import java.util.*;

public class MinimumSwaps2 {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int[] indices = new int[arr.length];
        int swaps = 0;
        for (int i=0; i< arr.length; i++) {
           indices[arr[i] - 1] = i;
        }
        for (int i=0; i<arr.length;i++){
            int swapIndex = indices[i];
            if (swapIndex != i) {
                int temp = arr[swapIndex];
                indices[temp-1] = i;
                indices[arr[i] - 1] = swapIndex;
                arr[swapIndex] = arr[i];
                arr[i] = temp;

                swaps++;
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
