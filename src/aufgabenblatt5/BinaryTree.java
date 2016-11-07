package aufgabenblatt5;

/**
 * This class describes a special binary tree. A binary tree has nodes
 * containing key, value, summary of all values, keys of which are smaller than
 * the current node, and two references to other nodes or NULL, one on the left
 * and one on the right
 * 
 * @author cao
 *
 */
public class BinaryTree {
	private BinaryTreeNode root;

	// Constructor
	public BinaryTree(int key, int value) {
		this.root = new BinaryTreeNode(key, value);
	}

	public BinaryTree() {
		this.root = null;
	}

	/**
	 * This method searches for a node with an input key in a binary search
	 * tree. Return the node if the node with the key is found, otherwise throw
	 * NullPointerException("key isnt in tree")
	 * 
	 * @param key
	 * @return found node/ Exception
	 */
	public BinaryTreeNode find(int key) throws NullPointerException {
		BinaryTreeNode tmp = root;
		while (tmp != null) {
			if (tmp.key == key) {
				return tmp;
			} else if (key > tmp.key) {
				tmp = tmp.right;
			} else {
				tmp = tmp.left;
			}
		}
		throw new NullPointerException("Key isnt in tree");
	}

	/**
	 * This method inserts a node with key in a binary search tree. If the key
	 * is already in the tree, return false (which means for this data structure
	 * is no duplicates of key allowed), otherwise return true(the node with key
	 * is successfully inserted)
	 * 
	 * @param key
	 * @return true/false
	 */
	public boolean insert(int key, int value) {
		BinaryTreeNode insertNode = new BinaryTreeNode(key, value);
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
	 * Output through console: all nodes with key and value in the undertree,
	 * the root of which is the input node
	 *
	 */
	public void print(BinaryTreeNode root) {
		if (root != null) {
			print(root.left);
			System.out.println(root.key + "..." + root.value);
			print(root.right);

		}
	}

	/**
	 * This method writes in every node the summary of all values of nodes (
	 * which are in the undertree with input root), the keys of which are
	 * smaller than its key in the tree
	 * 
	 * @param underRoot
	 */
	public void saveSum(BinaryTreeNode underRoot) {
		if (underRoot != null) {
			saveSum(underRoot.left);
			sumAtNode(underRoot, this.root);
			saveSum(underRoot.right);

		}
	}

	/**
	 * This method writes the summary of all values, the keys of which are
	 * smaller than the key of input node in the undertree with the input root,
	 * in sum of the input_node
	 * 
	 * @param node
	 * @param root
	 */
	private void sumAtNode(BinaryTreeNode node, BinaryTreeNode root) {
		if (root != null) {
			sumAtNode(node, root.left);
			if (root.key < node.key) {
				node.sum += root.value;
			}
			sumAtNode(node, root.right);
		}
	}

	/**
	 * main function: quick test
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Insert some nodes
		BinaryTree test = new BinaryTree(1, 11);
		test.insert(1, 1);
		test.insert(2, 12);
		test.insert(9, 19);
		test.insert(14, 114);
		test.insert(3, 13);
		test.insert(3, 3);
		test.insert(8, 8);
		test.insert(19, 119);
		test.insert(6, 16);
		test.insert(7, 17);
		// Print under tree with root.key =9
		System.out.println("Undertree with root=9 output...");
		test.print(test.find(9));
		// Print tree
		System.out.println("tree output...");
		test.print(test.root);
		// Nodes of tree with summary
		System.out.println("Nodes of tree with summary...");
		test.saveSum(test.root);
		System.out.println("Node key =14 " + test.find(14).sum); // 11+12+13+8+16+17
		System.out.println("Node key =6 " + test.find(6).sum); // 11+12+13
		System.out.println("Node key =9 " + test.find(9).sum); // 11+12+13+16+17+8
		// Print some differences between sumaries (sum of bigger-sum of smaller -value of smaller)
		System.out.format("Diff from note 14 to node 9: %d \n", test.find(14).sum - test.find(9).sum-test.find(9).value);
		System.out.format("Diff from note 9 to node 6: %d", test.find(9).sum - test.find(6).sum - test.find(6).value);
	}
}