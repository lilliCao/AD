package aufgabenblatt4;

import aufgabenblatt1.Array;
import aufgabenblatt1.UnvalidActionException;
import sun.applet.Main;

public class ArrayExtend<T> extends aufgabenblatt1.Array<T> {

	public ArrayExtend(int K, int length) {
		super(K, length);
	}

	/*
	 * Bubble sort: Durchlaufen des Arrays. Vergleich das Element mit seinem
	 * Nachbarn an der rechten Seite. Ist der Nachbarn größer als das Element,
	 * wird die Positionen von denen ausgetauscht
	 */
	public void bubbleSort() {
		int temp;
		for (int i = 1; i < this.size(); i++) {
			counter.counterUp(1);
			for (int j = 0; j < this.size() - 1; j++) {
				counter.counterUp(1);
				if ((int) this.retrieve(j) > (int) this.retrieve(j + 1)) {
					temp = (int) this.retrieve(j);
					this.getArray()[j] = this.retrieve(j + 1);
					this.getArray()[j + 1] = temp;
				}
			}
		}
	}

	public void insertSort() {
		int temp;
		for (int i = 1; i < this.size(); i++) {
			counter.counterUp(1);
			temp = (int) this.retrieve(i);
			int j = i;
			while (j > 0 && (int) this.getArray()[j - 1] > temp) {
				counter.counterUp(1);
				this.getArray()[j] = this.getArray()[j - 1];
				j--;
			}
			this.getArray()[j] = temp;
		}
	}

	public static void main(String[] args) throws UnvalidActionException {
		

		
		for(int n =0; n<100; n++){
			ArrayExtend<Integer> test = new ArrayExtend<Integer>(500, 1000);
			//List random ini
			for (int i = 0; i < 10000; i++) {
				test.insert(i, (int) (Math.random() * 10000));
				//System.out.println(test.retrieve(i));
			}
			//cost test
		long start = System.currentTimeMillis();
		//test.bubbleSort();
		test.insertSort();
		long end = System.currentTimeMillis();
		System.out.println((end-start));
		}
		/*System.out.println("Sorting array....");
		for (int j = 0; j < test.size(); j++) {
			System.out.println(test.retrieve(j));
		}
        */
	}
}
