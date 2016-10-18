package aufgabenblatt5;

/**
 * This class describes a node in a binary search tree, which contains data, an
 * extra information (which is the summary of all values, key of which are
 * smaller than key of node in the tree) and 2 pointers pointing to other nodes
 * or NULL
 * 
 * @author cao
 *
 */
public class BinaryTreeNode {
	protected int key;
	protected int value;
	protected BinaryTreeNode right;
	protected BinaryTreeNode left;
	// sum of all value of nodes from 0 to key
	protected int sum;

	// Construtor
	public BinaryTreeNode(int key, int value) {
		this.key = key;
		this.value = value;
		this.right = null;
		this.left = null;
		this.sum = 0;
	}

	public BinaryTreeNode() {
		this(0, 0);
	}

	// Getter and Setter
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getValue() {
		return this.value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BinaryTreeNode getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}

	public BinaryTreeNode getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}

	public int getSum() {
		return this.sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}
}
