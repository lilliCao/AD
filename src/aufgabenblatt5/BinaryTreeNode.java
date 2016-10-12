package aufgabenblatt5;

/**
 * This class describes a node in a binary search tree, which contains data and 2
 * pointers pointing to other nodes or NULL
 * 
 * @author cao
 *
 */
public class BinaryTreeNode {
	protected int key;
	protected BinaryTreeNode right;
	protected BinaryTreeNode left;

	// Construtor
	public BinaryTreeNode(int key) {
		this.key = key;
		this.right = null;
		this.left = null;
	}

	public BinaryTreeNode() {
		this(0);
	}

	// Getter and Setter
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
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

}
