package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestArrayListeA {
	/**
	 * Diese methode initialisiert eine ArrayListe von 2 Integer den Werten 1
	 * und 2
	 * 
	 * @return ein ArrayList<Integer> mit einem Array (Länge 2), die 2 Elemente
	 *         1 und 2 enthält
	 */
	private ArrayListeA<Integer> initialisiere() {
		ArrayListeA<Integer> list1 = new ArrayListeA<Integer>(2);
		list1.insert(0, 0);
		list1.insert(1, 1);
		return list1;
	}

	@Test
	public void testGetter() {
		initialisiere();
		// test getSize
		assertEquals(2, initialisiere().getSize());
		// test belegterPlatz
		assertEquals(2, initialisiere().getBelegterPlatz());
		// test getElemente

	}

	@Test
	public void testNaechsteFreieStelle() {
		ArrayListeA<Integer> test = new ArrayListeA<>(3);
		test.insert(0, 0);
		test.insert(2, 2);
		assertEquals(1, test.naechsteFreiStelle());
		test.insert(1, 1);
		assertEquals(-1, test.naechsteFreiStelle());
	}

	@Test
	public void testInsert() {
		ArrayListeA<Integer> list1 = new ArrayListeA<Integer>(2);
		ArrayListeA<String> list2 = new ArrayListeA<String>(2);
		// Test: Insert in dem freien Platz
		list1.insert(0, 0);
		assertEquals(0, list1.getArray()[0]);

		list2.insert(0, "zero");
		assertEquals("zero", list2.getArray()[0]);

		// Test: Insert in dem belegten Platz
		list1.insert(0, 10);
		assertEquals(10, list1.getArray()[0]);
		assertEquals(0, list1.getArray()[1]);

		list2.insert(0, "zehn");
		assertEquals("zehn", list2.getArray()[0]);
		assertEquals("zero", list2.getArray()[1]);

		// Test wenn Das orginale Array keine freie Plätze mehr hat
		list1.insert(0, 100);
		assertEquals(100, list1.getArray()[0]);
		assertEquals(10, list1.getArray()[1]);
		assertEquals(0, list1.getArray()[2]);
		assertEquals(null, list1.getArray()[3]);

		list2.insert(0, "hundert");
		assertEquals("hundert", list2.getArray()[0]);
		assertEquals("zehn", list2.getArray()[1]);
		assertEquals("zero", list2.getArray()[2]);
		assertEquals(null, list2.getArray()[3]);

		// Test wenn ungültige Positiion eingegeben wird
		try {
			list1.insert(8, 8);
			;
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (IndexOutOfBoundsException e) {

		}

	}

	@Test
	public void testDelete() {
		ArrayListeA<Integer> test = new ArrayListeA<>(2);
		test = initialisiere();
		test.delete(0);
		assertEquals(null, test.getArray()[0]);

		// Test wenn ungültige Positiion eingegeben wird
		try {
			test.delete(8);
			;
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (IndexOutOfBoundsException e) {

		}
	}

	@Test
	public void testFind() {
		// Gesuchtes Element ist vorhanden
		assertEquals(1, initialisiere().find(1));
		// Gesuchtes Element ist nicht vorhanden
		assertEquals(-1, initialisiere().find(2));
	}

	@Test
	public void testRetrieve() {
		assertEquals(0, (Object) initialisiere().retrieve(0));
		assertEquals(1, (Object) initialisiere().retrieve(1));

		// Test wenn ungültige Positiion eingegeben wird
		try {
			initialisiere().retrieve(8);
			;
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (IndexOutOfBoundsException e) {

		}
	}

	@Test
	public void testConcat() {
		ArrayListeA<Integer> test = new ArrayListeA<>(2);
		test = initialisiere();
		test.concat(test);
		assertEquals(0, test.getArray()[0]);
		assertEquals(1, test.getArray()[1]);
		assertEquals(0, (Object) test.getArray()[2]);
		assertEquals(1, (Object) test.getArray()[3]);
	}

	@Test
	public void testSize() {
		assertEquals(2, initialisiere().size());
		ArrayListeA<Integer> test = new ArrayListeA<>(2);
		assertEquals(0, test.size());
	}

}
