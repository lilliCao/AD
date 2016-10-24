package aufgabenblatt6;

import java.util.PriorityQueue;
import java.util.Scanner;

import sun.applet.Main;

public class Huffman {
	private Tree tree;
	private String[] codes;

	// build frequency table
	private int[] buildFreq(String text) {
		int[] freq = new int[256];
		for (int i = 0; i < text.length(); i++) {
			freq[(int) text.charAt(i)]++;
		}
		return freq;
	}

	// build Huffman tree
	private Tree huffmanTree(int[] freq) {
		// Queue for all alphabets, which appears at least once in text
		PriorityQueue<Tree> queue = new PriorityQueue<Tree>();
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) {
				queue.add(new Tree((char) i, freq[i]));
			}
		}
		// build HuffmanTree
		while (queue.size() > 1) {
			Tree t1 = queue.poll();
			Tree t2 = queue.poll();
			queue.add(new Tree(t1, t2));
		}
		return queue.poll();
	}

	// print all nodes
	public void print(Node root) {
		if (root != null) {
			print(root.left);
			System.out.println((char) root.c + "..." + root.weight);
			print(root.right);
		}
	}

	// Fill in a table :the String Code in every leaf ( the position is integer
	// of char at leaf)
	private void code(Node root, String[] codes) {
		if (root.left != null) {
			root.left.code = root.code + "0";
			code(root.left, codes);
			root.right.code = root.code + "1";
			code(root.right, codes);
		} else {
			codes[(int) root.c] = root.code;
		}
	}

	// Get the EncodeTable
	private String[] getCode(Node root) {
		if (root == null) {
			return null;
		}
		String[] codes = new String[256];
		code(root, codes);
		return codes;
	}

	// Encoder
	public String encode(String text) {
		int[] freq = this.buildFreq(text);
		this.tree = this.huffmanTree(freq);
		this.codes = this.getCode(tree.root);
		String encodedText = "";
		for (int i = 0; i < text.length(); i++) {
			if (freq[text.charAt(i)] > 0) {
				encodedText += codes[text.charAt(i)];
			}
		}
		return encodedText;

	}

	// check wether the input bit an encoded alphabet

	private char isCoded(String code) {
		for (int i = 0; i < this.codes.length; i++) {
			if (code.equals(this.codes[i])) {
				return (char) i;
			}
		}
		return Character.MIN_VALUE;
	}

	// Decoder
	public String decode(String text, Huffman huffman) {
		String decodedText = "";
		char c;
		int i = 0;
		int j;
		for (j = 1; j < text.length() + 1; j++) {
			if (i == text.length()) {
				break;
			}
			c = isCoded(text.substring(i, j));
			if (c != Character.MIN_VALUE) {
				decodedText += c;
				i = j;
				continue;
			}

		}
		return decodedText;
	}

	// main_quick test
	public static void main(String[] args) {
		/*
		 * Scanner scanner = new Scanner(System.in); System.out.println(
		 * "Enter a text..."); String input = scanner.nextLine();
		 * scanner.close(); Huffman test = new Huffman();
		 * System.out.println(test.encode(input));
		 * System.out.println(test.decode(test.encode(input), test));
		 */

		Huffman test = new Huffman();
		String text = "If you give someone a program you will frustrate them for a day. If you teach them how to program, you will frustrate them for a lifetime. The computing scientist´s main challenge is not to get confused by the complexities of his own making. Beauty is more important in computing than anywhere else in technology because software is so complicated. Beauty is the ultimate defence against complexity.";
		System.out.println("Encoding...");
		System.out.println(test.encode(text));
		System.out.println("Decoding...");
		System.out.println(test.decode(test.encode(text), test));

		/*
		 * int[] freq = test.buildFreq(input); Tree tree =
		 * test.huffmanTree(freq); String[] encode = test.getCode(tree.root);
		 * String encodedText = ""; for (int i = 0; i < encode.length; i++) { if
		 * (freq[i] > 0) { System.out.format("Char..%c\n...Code...%s\n", (char)
		 * i, encode[i]); } } for (int i = 0; i < input.length(); i++) { if
		 * (freq[input.charAt(i)] > 0) { encodedText += encode[input.charAt(i)];
		 * } } System.out.println("Code..." + encodedText); //
		 * test.print(tree.root);
		 */

	}
}