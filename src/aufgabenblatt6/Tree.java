package aufgabenblatt6;

public class Tree implements Comparable<Tree> {
	protected Node root;

	// constructor
	// empty tree

	// Tree with a root
	public Tree(char c, int weight) {
		this.root = new Node(c, weight);
	}

	// Tree from 2 smaller trees
	public Tree(Tree t1, Tree t2) {
		this.root = new Node();
		this.root.left = t1.root;
		this.root.right = t2.root;
		this.root.weight = t1.root.weight + t2.root.weight;
	}

	@Override
	public int compareTo(Tree o) {
		if (this.root.weight < o.root.weight) {
			return -1;
		} else if (this.root.weight > o.root.weight) {
			return 1;
		}
		return 0;
	}
}
