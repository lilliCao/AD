package aufgabenblatt9;

import java.util.Scanner;

import aufgabenblatt9.Quicksort.PivotPosition;

public class Quicksort {
	enum PivotPosition {
		ANFANG, ENDE, ZUFALL, MEDIAN
	};

	/**
	 * Diese Methode berechnet Median Wert nach Median of Median Algorithmus
	 * 
	 * @param left
	 * @param mitte
	 * @param right
	 * @return
	 */
	private int median(int left, int mitte, int right) {
		if (left > mitte ^ left > right) {
			return left;
		}
		if (right > mitte ^ right > left) {
			return right;
		}
		return mitte;

	}

	/**
	 * Diese Methode wählt pivotElement aus
	 * 
	 * @param array
	 * @param left
	 * @param right
	 * @param pivotPosition
	 * @return pivotElement
	 */
	private int pivotAuswahl(int array[], int left, int right, PivotPosition pivotPosition) {
		int pivot;
		switch (pivotPosition) {
		case ANFANG:
			pivot = array[left];
			break;
		case ENDE:
			pivot = array[right];
			break;
		case ZUFALL:
			pivot = array[(int) (Math.random() * (right - left)) + left];
			break;
		case MEDIAN:
			pivot = median(array[left], array[(left + right) / 2], array[right]);
			if(pivot == array[left]){
				swap(array, left , (left + right) / 2 );
			}
			if(pivot == array[right]){
				swap(array, right , (left + right) / 2 );
			}
			
			
			break;
		default:
			pivot = array[(left + right) / 2];
		}
		return pivot;
	}

	/**
	 * Diese Methode tauscht das Element an der Position left und right
	 * 
	 * @param array
	 * @param left
	 * @param right
	 */
	private void swap(int array[], int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;

	}

	/**
	 * Diese Methode sortiert alle Elementen von Position leftP bis rightP in
	 * dem Array Pivotelement wird gewählt zwischen erstes Element, letztes
	 * Element, median oder ein zufalliges Element
	 * 
	 * @param array
	 * @param leftP
	 * @param rightP
	 * @param pivotPosition
	 */
	public void quickS(int array[], int leftP, int rightP, PivotPosition pivotPosition) {
		int left = leftP;
		int right = rightP;
		int pivot = pivotAuswahl(array, left, right, pivotPosition);
		while (left < right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swap(array, left, right);
				left++;
				right--;

			}
		}
		if (left < rightP) {
			quickS(array, left, rightP, pivotPosition);
		}
		if (right > leftP) {
			quickS(array, leftP, right, pivotPosition);
		}

	}

	/**
	 * Diese Methode sortiert den Array
	 * 
	 * @param array
	 * @throws IndexOutOfBoundsException
	 *             wenn das Array 0 der 1 Element enthält
	 */
	public void quickSort(int array[], PivotPosition pivotPosition) throws IndexOutOfBoundsException {
		if (array.length <= 1) {
			throw new IndexOutOfBoundsException("Array ist nicht zu sortiern. Array hat null oder 1 Element");
		}
		int left = 0;
		int right = array.length - 1;
		quickS(array, left, right, pivotPosition);
	}

	public static void main(String[] args) {
		Quicksort test = new Quicksort();
		int[] a, e, z, m;
		long start = 0, enda = 0, ende = 0, endz = 0, endm = 0;
		int n,loop, sum = 0;
		//int sizeA[] = { 10, 100, 1000, 10000, 100000, 1000000, 10000000,100000000 };
		int sizeA[] ={10,50,100,500,1000,5000,10000,15000,20000,25000,30000, 35000,40000,50000, 100000, 1000000};
		//int sizeA[] ={10,50,100,500,1000,2000,3000,4000,5000,6000};
// Aufwandsanalyse

//Test einzelne, loop=20		
        for(int j =0; j < sizeA.length; j++){
        	n= sizeA[j];
        	loop=0;
        	while (loop != 100 ) {
        	int[] array = new int[n];
        		for (int i = 0; i < n; i++) {
        	    array[i] = (int) (Math.random() * n * 5);
        		//array[i] =n-i;
        		//array[i] = i;
        		}
			start= System.currentTimeMillis();
			test.quickSort(array, PivotPosition.MEDIAN);
			//test.quickSort(array, PivotPosition.ANFANG);
			//test.quickSort(array, PivotPosition.ENDE);
			//test.quickSort(array, PivotPosition.ZUFALL);
			
			enda=System.currentTimeMillis();
			sum+= enda-start;
			loop++;
        	}
        	System.out.println(sum/100);
        	
		}

		
//TEst all
/*
		 
		 loop = 0;

		while (loop != sizeA.length) {
			n = sizeA[loop];
			int[] array = new int[n];
			// System.out.println("*********LIST INI*************");
			for (int i = 0; i < n; i++) {
				 array[i] = (int) (Math.random() * n *5);
				// array[i] =i;
				 //array[i] = n - i;
			}
			a = array.clone();
			e = array.clone();
			z = array.clone();
			m = array.clone();

			start = System.currentTimeMillis();
			test.quickSort(a, PivotPosition.ANFANG);
			enda = System.currentTimeMillis();
			test.quickSort(e, PivotPosition.ENDE);
			ende = System.currentTimeMillis();
			test.quickSort(z, PivotPosition.ZUFALL);
			endz = System.currentTimeMillis();
			test.quickSort(m, PivotPosition.MEDIAN);
			endm = System.currentTimeMillis();
			System.out.format("N=%9d::::%10d:%10d:%6d:%6d \n", n, (enda - start), (ende - enda), (endz - ende),
					(endm - endz));

			loop++;
		}
*/
		
		
		
/*
		 *  Correction
		 * int[] arrayT = { 1,190, 180, 112, 13, 4, 5, 0 , 1 , 2 , 1 , 6, 7, 28,
		 * 9, 10, 11, 12, 13, 114, 15, 16, 17, 8, 19, 2 };
		 * test.quickSort(arrayT, PivotPosition.ZUFALL);
		 * //test.insertSort(arrayT); System.out.println(
		 * "*********SORTED LIST*************"); for(int i=0; i< arrayT.length;
		 * i++){ System.out.print(" "+ arrayT[i]); }
*/

	}
}
