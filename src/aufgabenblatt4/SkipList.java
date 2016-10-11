package aufgabenblatt4;

import java.util.Scanner;

public class SkipList {
	private SkipListNode head;
	private SkipListNode tail;
	private int height;
	private int maxHeight;
	private SkipListNode[] update;
	public int count;

	// Construtor
	public SkipList() {
		height = 0;
		maxHeight = 0;

		head = new SkipListNode(Integer.MIN_VALUE, 0);
		tail = new SkipListNode(Integer.MAX_VALUE, 0);
		head.next[0] = tail;
		update = new SkipListNode[height + 1];
	}

	/*
	 * coin toss: 50% to increment more level
	 */
	private int randheight() {
		int height = 0;
		while ((int) (Math.random() * 1000) % 2 == 1) {
			height++;
		}
		return height;
	}

	/**
	 * This method return the node with the key back if the key is in the list.
	 * otherwise return null
	 * 
	 * @param key
	 * @return
	 */
	public SkipListNode search(int key) {
		SkipListNode p = head;
		for (int i = height; i >= 0; i--) {
			count++;
			while (p.next[i].key < key) {
				count++;
				p = p.next[i];
			}
		}
		p = p.next[0];
		return ((p.key == key) && (p != tail)) ? p : null;
	}

	/**
	 * this method insert a key in the skiplist if the key havent ever been
	 * there. Otherwise give a warning out per console
	 * 
	 * @param key
	 */
	public void insert(int key) {
		SkipListNode p = head;
		for (int i = height; i >= 0; i--) {
			while (p.next[i].key < key) {
				p = p.next[i];
			}
			update[i] = p;
		}
		// Check out wether key has been in the skiplist
		p = p.next[0];
		if (p.key == key) {
			System.out.println("No duplicates allowed");
			return;
		}
		// Extend the level after the result of random height
		int newHeight = randheight();
		if (newHeight > maxHeight) {
			SkipListNode oldHead = head;
			head = new SkipListNode(Integer.MIN_VALUE, newHeight);
			for (int i = 0; i <= maxHeight; i++) {
				head.next[i] = oldHead.next[i];
			}
			for (int i = maxHeight + 1; i <= newHeight; i++) {
				head.next[i] = tail;
			}
			maxHeight = newHeight;
			// Pointer of update to head
			for (int i = height; i >= 0 && update[i] == oldHead; i--) {
				update[i] = head;
			}
			// update updated
			SkipListNode[] oldUpdate = update;
			update = new SkipListNode[newHeight + 1];
			for (int i = 0; i <= height; i++) {
				update[i] = oldUpdate[i];
			}
		}
		// if newHeight even greater than height,update of the extended level
		// point to head
		if (newHeight > height) {
			for (int i = height + 1; i <= newHeight; i++) {
				update[i] = head;

			}
			height = newHeight;
		}

		p = new SkipListNode(key, newHeight);
		for (int i = 0; i <= newHeight; i++) {
			p.next[i] = update[i].next[i];
			update[i].next[i] = p;
		}

	}

	/**
	 * this methode deletes a key in the list if its in the list. Otherwise give
	 * a message through the console
	 * 
	 * @param key
	 */
	public void delete(int key) {
		SkipListNode p = head;
		SkipListNode[] update = new SkipListNode[height + 1];
		// update updated
		for (int i = height; i >= 0; i--) {
			while (p.next[i].key < key) {
				p = p.next[i];
			}
			update[i] = p;
		}
		// check out the attendance of key
		p = p.next[0];
		if (p.key != key) {
			System.out.println("No key found");
			return;
		} // change the pointer over the need-to-delete key
		for (int i = 0; i < p.next.length; i++) {
			update[i].next[i] = update[i].next[i].next[i];
		}
		// height updated
		while (height >= 0 && head.next[height] == tail) {
			height--;
		}

	}

	public void print() {
		for (int i = height; i >= 0; i--) {
			System.out.format("level %d\n", i);
			SkipListNode p = head.next[i];
			SkipListNode q = head.next[0];
			while (p != tail) {
				if (q == p) {
					System.out.println(p.key + " ");
					p = p.next[i];
				}
				System.out.println(" ");
				q = q.next[0];
			}

		}

	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for (int j = 0; j < 10; j++) {
			SkipList test = new SkipList();
			int n = scanner.nextInt();
			for (int i = 0; i < n; i++) {
				test.insert((int)(Math.random()*n*3));
			}
			test.search(n/2);
			System.out.println(test.count);
		}
	}
}
