package aufgabenblatt10;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.PriorityQueue;

import sun.security.provider.certpath.OCSP;

public class Hashtable {
	public enum Status {
		FREE, OCCUPIED, REMOVED
	};

	private int length;
	private int size;
	private Item[] hash;

	// constructor
	public Hashtable() {
		this.length = 15;
		this.size = 0;
		this.hash = new Item[length];
		for (int i = 0; i < hash.length; i++) {
			hash[i] = new Item();
		}
	}

	/**
	 * Intern class for content of hashtable, which contains 3 informations:
	 * status of this position, data and key
	 */
	class Item implements Comparable<Item> {
		private Status status;
		private String key;
		private String data;

		// Constructor
		public Item() {
			this.status = Status.FREE;
			this.key = "";
			this.data = "";
		}

		public Item(String data) {
			this.status = Status.OCCUPIED;
			this.data = data;
			this.key = data.split("--")[0];
		}

		// Getter and Setter
		public Status getStatus() {
			return this.status;
		}

		public String getKey() {
			return this.key;
		}

		public String getData() {
			return this.data;
		}

		public void setStatus(Status newStatus) {
			this.status = newStatus;
		}

		public void copyData(Item it) {
			this.status = it.status;
			this.data = it.data;
			this.key = it.key;
		}

		// add data from 2 lines with the same ip together
		public void dataCopy(Item i) {
			this.data += "\n" + i.data;
		}

		// Dubplicate return -1
		@Override
		public int compareTo(Item o) {
			return o.key.equals(this.key) ? -1 : 0;
		}

	}

	// Getter
	public Item[] getHash() {
		return this.hash;
	}

	/**
	 * This method writes the content from a file in a queue, line by line
	 * wrapped in an item Duplicate IP adress will be avoided by copying the
	 * data in the item, which contains the ip adress
	 */
	public PriorityQueue<Item> writeItem(String filename) {
		PriorityQueue<Item> queue = new PriorityQueue<>();
		BufferedReader br = null;
		String line = "";
		Item tmp;
		Item tmp2;
		try {
			br = new BufferedReader(new FileReader(filename));
			try {
				while ((line = br.readLine()) != null) {
					tmp = new Item(line);
					Iterator<Item> it = queue.iterator();
					while (it.hasNext()) {
						tmp2 = it.next();
						if (tmp2.compareTo(tmp) == -1) {
							tmp.dataCopy(tmp2);
							queue.remove(tmp2);
							break;
						}
					}
					queue.add(tmp);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return queue;
	}

	/**
	 * This method writes the content in a file in Hashtable
	 */
	public void load(String filename) {
		// Avoid dubplicate
		PriorityQueue<Item> queue = writeItem(filename);
		// Data loading...
		Item tmp;
		int index;
		while (!queue.isEmpty()) {
			if (((double) this.size / (double) this.length) > 0.8) {
				rehashing(2);
			}
			tmp = queue.poll();
			index = code(tmp.key);
			while (hash[index].status == Status.OCCUPIED) {
				index++;
				if (index >= length) {
					rehashing(2);
					index = code(tmp.key);
				}
			}

			hash[index].copyData(tmp);
			size++;
		}

	}

	/**
	 * This method codes an ip adress in an index in hashtable
	 */
	public int code(String ip) {
		int code = 0;
		String[] ip_split = ip.split("\\.");
		if (ip_split.length != 4) {
			System.out.println("Unvalid IP adress");
		} else {
			code = Integer.parseInt(ip_split[0])*1000 + Integer.parseInt(ip_split[1])*100 + Integer.parseInt(ip_split[2])*10
					+ Integer.parseInt(ip_split[3]);
		}
		int prim = nearestPrim();
		return code % prim;
	}

	private boolean isPrim(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	private int nearestPrim() {
		for (int i = this.length; i > 2; i--) {
			if (isPrim(i)) {
				return i;
			}
		}
		return 2;
	}

	/**
	 * This method resizes hashtable when the loadfactor is getting over the
	 * limit [0.5,0.8] by an input factor. The content of the hashtable will be
	 * moved to the new hashtable
	 */
	private void rehashing(int factor) {
		int oldLength = this.length;
		int newLength = oldLength * factor;
		Item[] newHash = new Item[newLength];
		for (int i = 0; i < newHash.length; i++) {
			newHash[i] = new Item();
		}
		Item tmp;
		int index;
		for (int i = 0; i < oldLength; i++) {
			tmp = hash[i];
			if (tmp.status == Status.OCCUPIED) {
				index = code(tmp.key);
				while (newHash[index].status == Status.OCCUPIED) {
					index++;
				}
				newHash[index].copyData(tmp);

			}
		}
		hash = newHash;
		length = newLength;
	}

	/**
	 * This method return the index of the input ip adress in the hashtable
	 */
	public String find(String ip) {
		int count = 0;
		String data = "DATA NOT FOUND";
		int index = this.code(ip);
		count++;
		while (this.hash[index].status != Status.FREE && index < this.length) {
			count++;
			if (this.hash[index].key.equals(ip)) {
				data = this.hash[index].data;
				count++;
				break;
			}
			index++;

		}
		System.out.println(count);
		return data;
	}

	/**
	 * main: quicktest
	 */

	public static void main(String[] args) {
	/*	Hashtable test = new Hashtable();
		String filename = "/home/tali/Desktop/webblog.txt";
		// FileGenerator file= new FileGenerator(20,filename);
		test.load(filename);
		System.out.format("Size is::::%d, Length is::::%d\n", test.size, test.length);
		for (int i = 0; i < test.length; i++) {
			System.out.println(i + ":::::" + test.hash[i].status + " " + test.hash[i].data);
		}
		String ip = "28.129.108.14";
		System.out.println(test.find(ip));
*/
		//Cost analyse
		int array[] ={10,100,200,300,500,700,900,1000,2000,4000,5000,10000,20000};
		for(int i=0; i<array.length; i++){
			Hashtable test = new Hashtable();
			String filename = "/home/tali/Java_Prog/AD/src/aufgabenblatt10/webblog.txt";
			FileGenerator file= new FileGenerator(array[i],filename);
			test.load(filename);
			String ip= test.hash[(int)(test.length*0.1)].key;
			test.find(ip);
		}
	}
}
