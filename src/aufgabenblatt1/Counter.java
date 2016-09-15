package aufgabenblatt1;

public class Counter {
private int counter;
//construtor
public Counter(int counter){
	this.counter= counter;
}
public Counter(){
	this(0);
}
public int getCounter(){
	return counter;
}
public void setCounter(int counter){
	this.counter =counter;
}
public void counterUp(int up){
	this.counter= counter +up;
}

}
