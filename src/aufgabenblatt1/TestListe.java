package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.internal.runners.InitializationError;

public class TestListe {
	/**
	 * Diese methode initialisiert eine ArrayListe
	 * 
	 * @return eine ArrayListe<Integer> mit einem Array (Länge 6), die 2
	 *         Elemente 0 und 1 enthält
	 * @throws UnvalidActionException
	 */
	private Array<Integer> initialisiere() throws UnvalidActionException {
		Liste test = new Array<Integer>(4, 6);
		test.insert(0, 0);
		test.insert(1, 1);
		return (Array) test;
	}

	@Test
	public void testInsert() throws UnvalidActionException {
		 Liste test = new Array<Integer>(6, 3);
		//Liste test = new Linkedlist();
		// Liste test = new DoubleLinkedlist();
		//Liste test = new ArrayLink(3, 6);
		// Test: Insert in dem freien Platz
		test.insert(0, 0);
		test.insert(1, 1);
		assertEquals(0, test.retrieve(0));
		assertEquals(1, test.retrieve(1));
		// Test: Insert in dem belegten Platz
		test.insert(0, 10);
		assertEquals(10, test.retrieve(0));
		assertEquals(0, test.retrieve(1));
		assertEquals(1, test.retrieve(2));
		// Test wenn Das orginale Array keine freie Plätze mehr hat
		test.insert(0, 100);
		assertEquals(100, test.retrieve(0));
		assertEquals(10, test.retrieve(1));
		assertEquals(0, test.retrieve(2));
		assertEquals(1, test.retrieve(3));
		// Test wenn ungültige Positiion oder ungültiges Element eingegeben wird
		try {
			test.insert(8, 8);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (UnvalidActionException e) {
			e.getMessage();
		}
		try {
			test.insert(0, null);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (UnvalidActionException e) {
			e.getMessage();
		}

		// Insert auf Position -1
		try {
			test.insert(-1, 8);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (UnvalidActionException e) {
			e.getMessage();
		}

	}

	@Test
	public void testDelete() throws IndexOutOfBoundsException, UnvalidActionException {
		 Liste test = new Array<>(4, 6);
		// Liste test = new Linkedlist();
		// Liste test = new DoubleLinkedlist();
		//Liste test = new ArrayLink<>(4, 6);
		test = initialisiere();
		test.insert(2, 2);
		// Test mit gültiger Position
		test.delete(0);
		assertEquals(1, (int) test.retrieve(0));
		assertEquals(2, (int) test.retrieve(1));
		// Test wenn ungültige Positiion eingegeben wird
		try {
			test.delete(8);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
	}

	@Test
	public void testFind() throws UnvalidActionException {
		// Gesuchtes Element ist vorhanden
		assertEquals(0, initialisiere().find(0));
		assertEquals(1, initialisiere().find(1));

		// Gesuchtes Element ist nicht vorhanden
		assertEquals(-1, initialisiere().find(2));

		// Test gesuchtes Element = null
		assertEquals(-1, initialisiere().find(null));

	}

	@Test
	public void testRetrieve() throws IndexOutOfBoundsException, UnvalidActionException {
		// Test mit gültiger Position

		assertEquals(0, (int) initialisiere().retrieve(0));
		assertEquals(1, (int) initialisiere().retrieve(1));

		// Test wenn ungültige Positiion eingegeben wird
		try {
			initialisiere().retrieve(8);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
	}

	@Test
	public void testConcat() throws UnvalidActionException {
		 Liste test = new Array<Integer>(3, 6);
		//Liste test = new ArrayLink<Integer>(3, 6);
		test = initialisiere();
		test.concat(test);
		assertEquals(0, test.retrieve(0));
		assertEquals(1, test.retrieve(1));
		assertEquals(0, (int) test.retrieve(2));
		assertEquals(1, (int) test.retrieve(3));
		// Concat eine NULL Liste in der Liste
		try {
			test.concat(null);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (NullPointerException e) {
			e.getMessage();
		}
		// Concat eine Liste von keinen Elementen mit einer Liste von beliebigen
		// Elementen
		 Liste test2 = new Array<Integer>(3, 6);
		//Liste test2 = new ArrayLink<Integer>(3, 6);
		test2.concat(test);
		assertEquals(4, test2.size());
		assertEquals(0, (int) test2.retrieve(0));
		// Concat eine Liste mit beliebigen Elementen mit einer Liste von keinen
		// Elementen
		Liste test3 = new Linkedlist();

		try {
			test.concat(test3);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (NullPointerException e) {
			e.getMessage();
		}

	}

	@Test
	public void testSize() throws UnvalidActionException {
		assertEquals(2, initialisiere().size());
	}

}
