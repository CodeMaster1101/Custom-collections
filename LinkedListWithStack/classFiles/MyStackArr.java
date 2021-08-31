package customQueueStack;

public class MyStackArr {
	/* LIFO
	 * IMPLEMENTS: size(), push(Object e), pop(), 
	 * search(Object e), contains(Object e), toString(),
	 * PURPOSE: background of a custom LinkedList;
	 */
int max = 10;
int top = -1;
private Object[] myArray = new Object[max];

public Object pop() {
	if(top < 0)
		return false;
	Object storePopped = myArray[top];
	myArray[top] = null;
	topReduction();
	return storePopped;
}
private void topReduction() {
	this.top = top - 1;
}

public Object push(Object o) {
	if(top >= max - 1)
		return false;
	
	myArray[top + 1] = o;
	top += 1;
	return myArray[top];
}
public int size() {
	return top + 1;
}
public int getMax() {
	return max;
}
public boolean contains(Object o) {
	for(int i = 0; i <= top; i++) {
		if(myArray[i].equals(o))
			return true;
	}return false;
}
@Override
public String toString() {
	String s = "[";
	for(int i = 0; i <= top; i++) {
		s += myArray[i] + " ";
	}
	return s += "]";
}
}
