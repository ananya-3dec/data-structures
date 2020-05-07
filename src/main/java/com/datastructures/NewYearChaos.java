package com.datastructures;

import java.util.*;

public class NewYearChaos {

	// Complete the minimumBribes function below.
	static void minimumBribes(int[] q) {
		int swaps = 0;
		int posSum = 0;
		boolean chaotic = false;
		int pos = 0;
		for (int i = 0; i < q.length-1; i++) {
			pos = (q[i]-1) - i;
			if (pos > 2) {
				chaotic = true;
				break;
			}
			if (pos > 0){
				swaps += pos;
				if (pos == 2){
					posSum ++;
				}
			} else {
				if (posSum > 0 && (posSum + pos > 0)){
					swaps += (posSum + pos);
				}
				posSum = 0;
			}
		}
		if (chaotic) { System.out.println("Too chaotic");
		} else { System.out.println(swaps); }
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr < t; tItr++) {
			int n = scanner.nextInt();
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			int[] q = new int[n];

			String[] qItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int i = 0; i < n; i++) {
				int qItem = Integer.parseInt(qItems[i]);
				q[i] = qItem;
			}

			minimumBribes(q);
		}

		scanner.close();
	}
}
