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
	public static int sum;

	// Constructor
	public BinaryTree(int key) {
		this.root = new BinaryTreeNode(key);
	}

	public BinaryTree() {
		this.root = null;
	}

	/**
	 * This method searchs for a key in a binary search tree. Return true if key
	 * is found, otherwise return false
	 * 
	 * @param key
	 * @return true/false
	 */
	public boolean find(int key) {
		BinaryTreeNode tmp = root;
		while (tmp != null) {
			if (tmp.key == key) {
				return true;
			} else if (key > tmp.key) {
				tmp = tmp.right;
			} else {
				tmp = tmp.left;
			}
		}
		return false;
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
		BinaryTreeNode insertNode = new BinaryTreeNode(key);
		// root ==null
		if (root == null) {
			root = insertNode;
			return true;
		}
		// root # null
		BinaryTreeNode tmp = root;
		BinaryTreeNode parent = null;
		while (true) {
			parent = tmp;
			// go to the left
			if (key < parent.key) {
				tmp = tmp.left;
				if (tmp == null) {
					parent.left = insertNode;
					return true;
				}
				// go to the right
			} else if (key > parent.key) {
				tmp = tmp.right;
				if (tmp == null) {
					parent.right = insertNode;
					return true;
				}
				// duplicate
			} else {
				return false;
			}
		}

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
		return false;
	}

	/**
	 * Output through console: all nodes with key
	 */
	public void print(BinaryTreeNode root) {
		if (root != null) {
			print(root.left);
			System.out.println(root.key);
			print(root.right);

		}
	}

	/**
	 * This methode counts the summary of all keys, which is greater or equal m
	 * and smaller or equal M)
	 * 
	 * @param m
	 * @param M
	 * @return sum
	 */
	public void sum(int m, int M, BinaryTreeNode root) {
		if (root != null) {
			sum(m, M, root.left);
			if (root.key < M && root.key > m) {
				this.sum += root.key;
			}
			sum(m, M, root.right);
		}
	}

	public static void main(String[] args) {
		BinaryTree test = new BinaryTree(1);
		test.insert(3);
		test.insert(2);
		test.insert(9);
		test.insert(14);
		test.insert(3);
		test.insert(3);
		test.insert(8);
		test.print(test.root);
		System.out.println("sum...");
		test.sum(1, 10, test.root);
		System.out.println(test.sum);
	}
}