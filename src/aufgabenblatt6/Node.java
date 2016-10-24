package aufgabenblatt6;

public class Node {
	protected Node left;
	protected Node right;
	protected char c;
	protected int weight;
	protected String code;

	// constructor
	// empty node
	public Node() {
		this.code = "";
	}

	// node with char and weight
	public Node(char c, int weight) {
		this.left = null;
		this.right = null;
		this.c = c;
		this.weight = weight;
		this.code = "";
	}
}
