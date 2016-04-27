package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestLinkedlist {

	@Test
	public void testInsert() throws UnvalidActionException {
		Linkedlist<Integer> test = new Linkedlist<Integer>();
		// Insert gültiges Element in gültiger Position
		test.insert(0, 0);
		test.insert(1, 1);
		assertEquals(0, (int) test.getHead().getNext().getContent());
		assertEquals(1, (int) test.getHead().getNext().getNext().getContent());
		// Insert in ungültige Position
		try {
			test.insert(8, 8);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (UnvalidActionException e) {
			e.getMessage();
		}
		// Insert null Element
		try {
			test.insert(0, null);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (UnvalidActionException e) {
			e.getMessage();
		}
	}

	@Test
	public void testDelete() throws UnvalidActionException {
		Linkedlist<Integer> test = new Linkedlist<Integer>();
		test.insert(0, 0);
		test.insert(1, 1);
		test.insert(2, 2);
		// Delete mit gültiger Position
		test.delete(0);
		assertEquals(1, (int) test.getHead().getNext().getContent());
		test.delete(1);
		assertEquals(1, (int) test.getHead().getNext().getContent());
		// Delete mit ungültiger Position
		try {
			test.delete(1);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}

	}

	@Test
	public void testFind() throws UnvalidActionException {
		Linkedlist<Integer> test = new Linkedlist<Integer>();
		test.insert(0, 0);
		test.insert(1, 1);
		test.insert(2, 2);
		// Das gesuchte Element ist in der Liste
		assertEquals(1, test.find(1));
		assertEquals(2, test.find(2));
		// Das gesuchte Element ist nicht in der Liste
		assertEquals(-1, test.find(4));
		// Gesuchtes Element ist null
		assertEquals(-1, test.find(null));

	}

	@Test
	public void testRetrieve() throws UnvalidActionException {
		Linkedlist<Integer> test = new Linkedlist<Integer>();
		test.insert(0, 0);
		test.insert(1, 1);
		test.insert(2, 2);
		// Test mit gültiger Position
		assertEquals(0, (int) test.retrieve(0));
		assertEquals(1, (int) test.retrieve(1));
		assertEquals(2, (int) test.retrieve(2));
		// Test mit ungültiger Position
		try {
			test.retrieve(3);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}

	}

	@Test
	public void testConcat() throws UnvalidActionException {
		Linkedlist<Integer> test = new Linkedlist<Integer>();
		Linkedlist<Integer> test2 = new Linkedlist<Integer>();
		test.insert(0, 0);
		test.insert(1, 1);
		test.insert(2, 2);

		test.concat(test);
		assertEquals(0, (int) test.retrieve(3));
		assertEquals(1, (int) test.retrieve(4));
		assertEquals(2, (int) test.retrieve(5));

		// Concat Originale liste mit einer null-Liste
		try {
			test.concat(null);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);

		} catch (NullPointerException e) {
			e.getMessage();
		}
		// Concat Originale Liste mit einer Liste, die nur head enthält
		try {
			test.concat(test2);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
		} catch (NullPointerException e) {
			e.getMessage();
		}

		// Concat Eine liste, die nur head enthält mit einer Liste mit
		// beliebigen Elementen
		test2.concat(test);
		assertEquals(6, test2.size());
		assertEquals(0, (int) test2.retrieve(0));

	}

	@Test
	public void testSize() throws UnvalidActionException {
		Linkedlist<Integer> test = new Linkedlist<Integer>();
		test.insert(0, 0);
		test.insert(1, 1);
		test.insert(2, 2);
		assertEquals(3, test.size());
		// Liste enthält nur Head
		Linkedlist<Integer> test2 = new Linkedlist<Integer>();
		assertEquals(0, test2.size());
	}
}
