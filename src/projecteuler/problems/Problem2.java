package projecteuler.problems;

import java.util.Vector;

/**
 * @author Luke Knight
 */

/*
 * Problem 2:
 * 
 * Each new term in the Fibonacci sequence is generated by adding the previous
 * two terms. By starting with 1 and 2, the first 10 terms will be: 1, 2, 3, 5,
 * 8, 13, 21, 34, 55, 89, ... By considering the terms in the Fibonacci sequence
 * whose values do not exceed four million, find the sum of the even-valued
 * terms.
 */

public class Problem2 {

	public static int fibonacciRecursive(int a, int b) {
		// add first two numbers
		int c = b + a;
		// if a value exceeds four million, stop.
		if (b > 4000000) {
			return 0;
		}
		if (b % 2 == 0) {
			// add even number
			return b + fibonacciRecursive(b, c);
		} else {
			// discard odd number
			return fibonacciRecursive(b, c);
		}
	}

    /**
     * Memoisation of previous calculations for efficient future calculations.
     * @param limit fibonacci value does not exceed this.
     * @return sum of fibonacci values up to 'limit'.
     */
    public static int fibonacciDynamic(int limit) {
        Vector<Integer> values = new Vector<Integer>();
        values.add(1);
        values.add(2);
        int sum = 2;
        for (int i = 2; sum < limit; i++) {
            int tempSum = values.get(i-1) + values.get(i-2);
            values.insertElementAt(tempSum, i);
            if (tempSum % 2 == 0) {
                sum = sum + tempSum;
            }
        }
        return sum;
    }



	public static void main(String[] args) {

		System.out.println(fibonacciRecursive(1, 2));
        System.out.println(fibonacciDynamic(4000000));

	}

}
