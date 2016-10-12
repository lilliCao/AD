package aufgabenblatt5;

/**
 * This class describes a binary tree. A binary tree has nodes containing data
 * and two references to other nodes or NULL, one on the left and one on the
 * right
 * 
 * @author cao
 *
 */
public class BinaryTree {
	private BinaryTreeNode root;

	// Constructor
	public BinaryTree(int key) {
		this.root = new BinaryTreeNode(key);
	}

	public BinaryTree() {
		this.root = null;
	}

	/**
	 * This method searchs for a key in a binary search tree. Return true if key is
	 * found, otherwise return false
	 * 
	 * @param key
	 * @return true/false
	 */
	public boolean find(int key) {

	}

	/**
	 * This method inserts a key in a binary search tree. If the key is already
	 * in the tree, return false (which means for this data structure is no
	 * duplicates allowed), otherwise return true(the key is successfully
	 * inserted)
	 * 
	 * @param key
	 * @return true/false
	 */
	public boolean insert(int key) {

	}

	/**
	 * This method deletes the node with the key in the tree and change the
	 * references between related nodes. Return true if the key is successfully
	 * deleted, otherwise return false if the key is not found.
	 * 
	 * @param key
	 * @return true/false
	 */
	public boolean delete(int key) {

	}

	/**
	 * Output through console: all nodes with key
	 */
	public void print() {

	}

	/**
	 * This methode counts the summary of all keys, which is greater or equal m
	 * and smaller or equal M)
	 * 
	 * @param m
	 * @param M
	 * @return sum
	 */
	public int sum(int m, int M) {
		int sum = 0;
		return sum;

	}
}