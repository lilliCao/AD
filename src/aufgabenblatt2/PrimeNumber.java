package aufgabenblatt2;

import java.util.function.*;
import java.util.Scanner;

public class PrimeNumber {
	int count = 0;

	public void setUpCount() {
		count = 0;
	}

	// slow classic search
	public boolean[] slowSearch(int n) {
		boolean[] array = new boolean[n];
		int i, j;
		for (i = 0; i < n; i++) {
			array[i] = true;
			count++;
		}
		for (i = 2; i < n; i++) {
			count++;
			for (j = 2; j < n; j++) {
				count++;
				if (((i % j) == 0) && (j != i)) {
					array[i] = false;
				}
			}
		}
		return array;
	}

	// fast classic search
	public boolean[] fastSearch(int n) {
		boolean[] array = new boolean[n + 1];
		int i, j;
		for (i = 0; i < n; i++) {
			count++;
			array[i] = true;
		}
		for (i = 3; i < n; i += 2) {
			count++;
			for (j = 2; j <= Math.sqrt(i); j++) {
				count++;
				if (((i % j) == 0) && (j != i)) {
					array[i] = false;
					break;
				}
			}
			array[i + 1] = false;
		}
		return array;
	}

	// eratosthenes search
	public boolean[] eratSearch(int n) {
		boolean[] array = new boolean[n];
		int i, j;
		for (i = 0; i < n; i++) {
			count++;
			array[i] = true;
		}
		for (i = 2; i < Math.sqrt(n); i++) {
			count++;
			if (array[i] == true) {
				for (j = 2; i * j < n; j++) {
					count++;
					array[i * j] = false;
				}
			}
		}
		return array;
	}

	// define charakter of prime numbers
	// check out a number, bigger than or as big as 2 wether its a prime number
	// or not
	public boolean primeIndentify(int n) {
		for (int i = 2; i < Math.sqrt(n); i++) {
			count++;
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PrimeNumber test = new PrimeNumber();
		System.out.print("Please input a number ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int count1, count2, count3, count4;
		test.slowSearch(n);
		count1 = test.count;
		test.fastSearch(n);
		count2 = test.count - count1;
		test.eratSearch(n);
		count3 = test.count - count2 - count1;
		test.primeIndentify(n);
		count4 = test.count - count3 - count2 - count1;
		System.out.format("%d  %d  %d   %d\n", count1, count2, count3, count4);

		/*
		 * boolean[] array; array = test.slowSearch(n); array =
		 * test.fastSearch(n); array = test.eratSearch(n); System.out.print(
		 * "Prime Numbers are..."); for (int i = 2; i < array.length; i++) { if
		 * (array[i] == true) { System.out.println(" " + i); } }
		 */
		System.out.println("\n" + test.primeIndentify(n));

	}

}
