package aufgabenblatt1;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TestDoubleLinkedlist {

	@Test
	public void testInsert() throws UnvalidActionException {
		DoubleLinkedlist<Integer> test = new DoubleLinkedlist<>();
		// Insert in gültiger Position bzw. gültiges Element
		test.insert(0, 10);
		test.insert(1, 11);
		test.insert(2, 12);
		test.insert(1, 101);
		assertEquals(10, (int) test.getHead().getNextItem().getContent());
		assertEquals(101, (int) test.getHead().getNextItem().getNextItem().getContent());
		assertEquals(11, (int) test.getHead().getNextItem().getNextItem().getNextItem().getContent());
		assertEquals(12, (int) test.getHead().getNextItem().getNextItem().getNextItem().getNextItem().getContent());
		// Insert in ungültiger Position bzw. ungültiges Element
		try {
			test.insert(-1, 1);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
		} catch (UnvalidActionException e) {
			e.getMessage();
		}
		try {
			test.insert(5, 1);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
		} catch (UnvalidActionException e) {
			e.getMessage();
		}
		try {
			test.insert(1, null);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
		} catch (UnvalidActionException e) {
			e.getMessage();
		}
	}

	@Test
	public void testDelete() throws UnvalidActionException {
		DoubleLinkedlist<Integer> test = new DoubleLinkedlist<>();
		test.insert(0, 10);
		test.insert(1, 11);
		test.insert(2, 12);
		test.insert(1, 101);
		// Liste: 10 101 11 12
		// Test mit gültiger Position
		test.delete(0);
		// Liste 101 11 12
		assertEquals(101, (int) test.getHead().getNextItem().getContent());
		assertEquals(12, (int) test.getTail().getPrevItem().getContent());
		test.delete(1);
		// Liste 101 12
		assertEquals(12, (int) test.getHead().getNextItem().getNextItem().getContent());
		//
		// Test mit ungültiger Position
		try {
			test.delete(2);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			test.delete(-1);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}

	}

	@Test
	public void testFind() throws UnvalidActionException {
		DoubleLinkedlist<Integer> test = new DoubleLinkedlist<>();
		test.insert(0, 10);
		test.insert(1, 11);
		test.insert(2, 12);
		test.insert(1, 101);
		// Liste: 10 101 11 12
		// Das gesuchte Element ist in der Liste
		assertEquals(0, test.find(10));
		assertEquals(1, test.find(101));
		assertEquals(2, test.find(11));
		assertEquals(3, test.find(12));
		// Das gesuchtes Element ist nicht in der Liste oder null
		assertEquals(-1, test.find(15));
		assertEquals(-1, test.find(null));

	}

	@Test
	public void testRetrieve() throws UnvalidActionException {
		DoubleLinkedlist<Integer> test = new DoubleLinkedlist<>();
		test.insert(0, 10);
		test.insert(1, 11);
		test.insert(2, 12);
		test.insert(1, 101);
		// Liste: 10 101 11 12
		// Test mit gültiger Position
		assertEquals(10, (int) test.retrieve(0));
		assertEquals(101, (int) test.retrieve(1));
		assertEquals(11, (int) test.retrieve(2));
		assertEquals(12, (int) test.retrieve(3));
		// Test mit ungültiger Position
		try {
			test.retrieve(-1);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
		try {
			test.retrieve(4);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
		} catch (IndexOutOfBoundsException e) {
			e.getMessage();
		}
	}

	@Test
	public void testConcat() throws UnvalidActionException {
		DoubleLinkedlist<Integer> test = new DoubleLinkedlist<>();
		test.insert(0, 10);
		test.insert(1, 11);
		test.insert(2, 12);
		test.insert(1, 101);
		// Liste 10 101 11 12
		DoubleLinkedlist<Integer> test2 = new DoubleLinkedlist<>();
		DoubleLinkedlist<Integer> test3 = new DoubleLinkedlist<>();
		// Concat eine Liste mit keinen Elementen mit einer Liste mit beliebigen
		// Elementen
		test3.concat(test);
		assertEquals(4, test3.size());
		assertEquals(10, (int) test3.retrieve(0));
		assertEquals(101, (int) test3.retrieve(1));
		assertEquals(11, (int) test3.retrieve(2));
		assertEquals(12, (int) test3.retrieve(3));

		// Concat die Liste mit eine Liste mit beliebigen Elementen
		test.concat(test);
		assertEquals(10, (int) test.retrieve(0));
		assertEquals(101, (int) test.retrieve(1));
		assertEquals(11, (int) test.retrieve(2));
		assertEquals(12, (int) test.retrieve(3));
		assertEquals(10, (int) test.retrieve(4));
		assertEquals(101, (int) test.retrieve(5));
		assertEquals(11, (int) test.retrieve(6));
		assertEquals(12, (int) test.retrieve(7));

		// Concat die Liste mit einer null Liste oder eine Liste mit keinen
		// Elementen
		try {
			test.concat(null);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
		} catch (NullPointerException e) {
			e.getMessage();
		}
		try {
			test.concat(test2);
			Assert.assertTrue("Fehler: Es wurde keine Exception geworfen!", false);
		} catch (NullPointerException e) {
			e.getMessage();
		}

	}

	@Test
	public void testSize() throws UnvalidActionException {
		DoubleLinkedlist<Integer> test = new DoubleLinkedlist<>();
		test.insert(0, 10);
		test.insert(1, 11);
		test.insert(2, 12);
		test.insert(1, 101);
		// Liste 10 101 11 12
		assertEquals(4, test.size());
		test.delete(0);
		assertEquals(3, test.size());
	}
}
