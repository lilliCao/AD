package aufgabenblatt4;

import java.util.Scanner;

import aufgabenblatt1.UnvalidActionException;

public class Aufwandsanalyse {
public static void main(String[] args) throws UnvalidActionException {

	Scanner scanner = new Scanner(System.in);
	Scanner scanner2 = new Scanner(System.in);
	int n, countI, countS;
	System.out.println("input the size of list.... ");
	n= scanner.nextInt();

	
	//list ini
	for(int j =0; j < 100; j++){
	ArrayExtend test = new ArrayExtend(1000, n);
	for (int i = 0; i<n;i++){
		test.insert(i, (int) (Math.random()*n));
	}
	//count
	countI = test.getCounter().getCounter();
	test.bubbleSort();
	//test.insertSort();
	countS = test.getCounter().getCounter() -countI;
	System.out.println(countS);
	}
}
}
