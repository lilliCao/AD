package aufgabenblatt2;

import aufgabenblatt2.Quicksort.PivotPosition;

public class AufwandLaufzeit {
	public static void laufzeit(int[] array) {
		Quicksort test = new Quicksort();
		long start = System.currentTimeMillis();

		test.quickSort(array, PivotPosition.ANFANG);
		long endA = System.currentTimeMillis();

		test.quickSort(array, PivotPosition.ENDE);
		long endE = System.currentTimeMillis();

		test.quickSort(array, PivotPosition.ZUFALL);
		long endZ = System.currentTimeMillis();

		test.quickSort(array, PivotPosition.MEDIAN);
		long endM = System.currentTimeMillis();

		System.out.println("Pivot am Anfang:  " + (endA - start));
		System.out.println("Pivot am Ende:  " + (endE - endA));
		System.out.println("Pivot Zufall:  " + (endZ - endE));
		System.out.println("Pivot Median:  " + (endM - endZ));
	}

	public static void main(String[] args) {

		int array[] = new int[1000];
		// Sorted list: UP list
		System.out.println("*************Sorted UP list**************");
		for (int i = 0; i < 1000; i++) {
			array[i] = i;
		}
		laufzeit(array);
		// Sorted list: DOWN list
		System.out.println("*************Sorted DOWN list**************");
		for (int i = 0; i < 1000; i++) {
			array[i] = 1000 - i;
		}
		laufzeit(array);
		// Sorted list: RANDOM list
		System.out.println("*************Sorted RANDOM list**************");
		for (int i = 0; i < 1000; i++) {
			array[i] = (int) (Math.random()*2000);
		}
		laufzeit(array);
	}
}
