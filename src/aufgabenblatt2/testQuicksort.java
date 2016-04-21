package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import aufgabenblatt1.UnvalidActionException;
import aufgabenblatt2.Quicksort.PivotPosition;

public class testQuicksort {

	@Test
	public void testQuickSort() {
		int[] array = { 1, 14, 18, 2, 4 };
		Quicksort test = new Quicksort();
		test.quickSort(array, PivotPosition.ANFANG);
		assertEquals(1, array[0]);
		assertEquals(2, array[1]);
		assertEquals(4, array[2]);
		assertEquals(14, array[3]);
		assertEquals(18, array[4]);
		// Test Array von 0 oder 1 Element
		int[] noSortArray = {1};
		try {
			test.quickSort(noSortArray, PivotPosition.ANFANG);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
	}
}
