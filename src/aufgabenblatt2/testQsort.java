package aufgabenblatt2;

import static org.junit.Assert.*;

import org.junit.Test;

import aufgabenblatt2.Qsort.PivotPosition;

//public class testQsort {
//
//	@Test
//	public void testQuickS() {
//		int[] array = { 1, 14, 18, 2, 4 };
//		Qsort test = new Qsort();
//		PivotPosition pos = PivotPosition.ANFANG;
//		test.quickS(array, 2, array.length - 1, pos);
//		assertEquals(1, array[0]);
//		assertEquals(14, array[1]);
//		assertEquals(2, array[2]);
//		assertEquals(4, array[3]);
//		assertEquals(18, array[4]);
//	}
//
//	@Test
//	public void testQuickSG() {
//		int[] array = { 1, 14, 18, 19, 2, 4 };
//		Qsort test = new Qsort();
//		test.quickSG(array, 0, array.length - 1);
//		assertEquals(1, array[0]);
//		assertEquals(2, array[1]);
//		assertEquals(4, array[2]);
//		assertEquals(14, array[3]);
//		assertEquals(18, array[4]);
//		assertEquals(19, array[5]);
//	}
//
//	@Test
//	public void testQuickSZ() {
//		int[] array = { 1, 14, 18, 2, 4 };
//		Qsort test = new Qsort();
//		test.quickSZ(array, 0, array.length - 1);
//		assertEquals(1, array[0]);
//		assertEquals(2, array[1]);
//		assertEquals(4, array[2]);
//		assertEquals(14, array[3]);
//		assertEquals(18, array[4]);
//	}
//
//	@Test
//	public void testQuickSM() {
//		int[] array = { 1, 14, 18, 2, 4 };
//		Qsort test = new Qsort();
//		test.quickSM(array, 0, array.length - 1);
//		assertEquals(1, array[0]);
//		assertEquals(2, array[1]);
//		assertEquals(4, array[2]);
//		assertEquals(14, array[3]);
//		assertEquals(18, array[4]);
//	}
//
//	@Test
//	public void testQuicksort() {
//		int[] array = { 1, 14, 18, 2, 4 };
//		Qsort test = new Qsort();
//		PivotPosition pos = PivotPosition.ANFANG;
//		test.quickSort(array, pos);
//		assertEquals(1, array[0]);
//		assertEquals(2, array[1]);
//		assertEquals(4, array[2]);
//		assertEquals(14, array[3]);
//		assertEquals(18, array[4]);
//	}
//
//}
