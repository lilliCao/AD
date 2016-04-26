package aufgabenblatt2;

public class Quicksort {
	enum PivotPosition {
		ANFANG, ENDE, ZUFALL, MEDIAN
	};

	int count = 0;

	/**
	 * Getter
	 * 
	 * @return count
	 */
	public int getCount() {
		return count;
	}

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
			pivot = array[(int) (Math.random() * (right - left)) + left + 1];
			break;
		case MEDIAN:
			pivot = median(array[left], array[(left + right) / 2], array[right]);
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
				count++;
				left++;
			}
			while (array[right] > pivot) {
				right--;
				count++;
			}
			if (left <= right) {
				count++;
				swap(array, left, right);
				left++;
				right--;

			}
			if (left < rightP) {
				quickS(array, left, rightP, pivotPosition);
			}
			if (right > leftP) {
				quickS(array, leftP, right, pivotPosition);
			}
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
		int[] array = new int[200];
		int[] array100 = new int[100];
		int[] array1000 = new int[1000];
		int[] array10000 = new int[10000];
		for (int i = 0; i < 200; i++) {
			//array[i] = (int) (Math.random() * 100);
			// System.out.println(array10[i]);
		array[i] =i;
		}

		//int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
		test.quickSort(array, PivotPosition.ANFANG);
		int a = test.getCount();
		System.out.println("Pivot am Anfang " + a);
		test.quickSort(array, PivotPosition.ENDE);
		int b = test.getCount() - a;
		System.out.println("Pivot am Ende " + b);
		test.quickSort(array, PivotPosition.MEDIAN);
		int c = test.getCount() - b - a;
		System.out.println("Pivot Median " + c);
		test.quickSort(array, PivotPosition.ZUFALL);
		System.out.format("Pivot Zufall %d", test.getCount() - c - b - a);

	}
}
