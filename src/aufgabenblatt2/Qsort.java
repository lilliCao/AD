package aufgabenblatt2;

import java.util.Arrays;

public class Qsort {
	enum PivotPosition {
		ANFANG, ENDE, ZUFALL, MEDIAN
	};

	/**
	 * Diese Methode sortiert alle Elementen von Position leftP bis rightP in
	 * dem Array Pivotelement ist das Element in der Mitte.
	 * 
	 * @param array
	 * @param leftP
	 * @param rightP
	 */
	int count = 0;
	int countZ = 0;
	int countM = 0;
	int countG = 0;

	public int getCount() {
		return count;
	}

	private void swipe(int array[], int left, int right) {
		int tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;

	}

	private int pivotAuswahl(int array[], int left, int right, PivotPosition pivotPosition) {
		int pivot = array[array.length / 2];
		switch (pivotPosition) {
		case ANFANG:
			pivot = array[left];
			break;
		case ENDE:
			pivot = array[right];
			break;
		case ZUFALL:
			pivot = array[(int) (Math.random() * (right - left)) + left + 1];
			break;
		case MEDIAN:
			pivot = median(array[left], array[(left + right) / 2], array[right]);
			break;
		}
		return pivot;
	}

	public void quickS(int array[], int leftP, int rightP, PivotPosition pivotPosition) {
		int left = leftP;
		int right = rightP;
		int pivot = pivotAuswahl(array, left, right, pivotPosition);
		while (left <= right) {
			count++;
			while (array[left] < pivot) {
				count++;
				left++;
			}
			while (array[right] > pivot) {
				right--;
				count++;
			}
			if (left <= right) {
				count++;
				swipe(array, left, right);
				left++;
				right--;

			}
			if (left < rightP) {
				count++;
				quickS(array, left, rightP, pivotPosition);
			}
			if (right > leftP) {
				count++;
				quickS(array, leftP, right, pivotPosition);
			}
		}
	}

	/**
	 * Diese Methode sortiert den Array
	 * 
	 * @param array
	 */
	public void quickSort(int array[], PivotPosition pivotPosition) {
		int left = 0;
		int right = array.length - 1;
		quickS(array, left, right, pivotPosition);
	}

	/**
	 * Diese Methode sortiert alle Elementen von Position leftP bis rightP in
	 * dem Array Pivotelement ist das größte Element.
	 * 
	 * @param array
	 * @param leftP
	 * @param rightP
	 */
	public void quickSG(int array[], int leftP, int rightP) {
		int left = leftP;
		int right = rightP;
		int pivot = array[right];
		while (left <= right) {
			countG++;
			while (array[left] < pivot) {
				left++;
				countG++;
			}
			while (array[right] > pivot) {
				right--;
				countG++;
			}
			if (left <= right) {
				countG++;
				swipe(array, left, right);
				left++;
				right--;
			}
			if (left < rightP) {
				countG++;
				quickSG(array, left, rightP);
			}
			if (right > leftP) {
				countG++;
				quickSG(array, leftP, right);
			}

		}
	}

	/**
	 * Diese Methode sortiert alle Elementen von Position leftP bis rightP in
	 * dem Array Pivotelement ist ein Zufallelement zwischen leftP und rightP
	 * 
	 * @param array
	 * @param leftP
	 * @param rightP
	 */
	public void quickSZ(int array[], int leftP, int rightP) {
		int left = leftP;
		int right = rightP;
		int pivot = array[(int) (Math.random() * (right - left)) + left + 1];
		while (left <= right) {
			countZ++;
			while (array[left] < pivot) {
				left++;
				countZ++;
			}
			while (array[right] > pivot) {
				right--;
				countZ++;
			}
			if (left <= right) {
				swipe(array, left, right);
				left++;
				right--;
			}
			if (left < rightP) {
				countZ++;
				quickSZ(array, left, rightP);
			}
			if (right > leftP) {
				countZ++;
				quickSZ(array, leftP, right);
			}
		}
	}

	/**
	 * Diese Methode
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
	 * } Diese Methode sortiert alle Elementen von Position leftP bis rightP in
	 * dem Array Pivotelement wird nach Median of Medians Algorithmen gewählt
	 * 
	 * @param array
	 * @param leftP
	 * @param right
	 */
	public void quickSM(int array[], int leftP, int rightP) {
		int left = leftP;
		int right = rightP;
		int pivot = median(array[left], array[(left + right) / 2], array[right]);
		while (left <= right) {
			while (array[left] < pivot) {
				left++;
			}
			while (array[right] > pivot) {
				right--;
			}
			if (left <= right) {
				swipe(array, left, right);
				left++;
				right--;
			}
			if (left < rightP) {
				quickSM(array, left, rightP);
			}
			if (right > leftP) {
				quickSM(array, leftP, right);
			}
		}
	}

	public static void main(String[] args) {
		int[] test = { 1, 2, 5, 6, 7, 8, 4, 5, 6, 7 };
		int[] test1 = { 1 };
		Qsort qsort = new Qsort();
		qsort.quickSG(test1, 0, (test.length - 1));
		// qsort.quickSG(test, 0, test.length -1);
		System.out.println(qsort.getCount());
		System.out.println(qsort.countZ);
		System.out.println(qsort.countG);
	}
}
