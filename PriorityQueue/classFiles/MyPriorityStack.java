package classFiles;

import Product.Product;

public class MyPriorityStack {
int max = 5;
MileLinkedList myLinkedList = new MileLinkedList();
/*
 * ne uspeav da najdam nisto na google za priority stack konkretno toa ke treba u zivo
 * ili da mi pratish nekoe linkce da procitam shto kako.
 * ke go copy pastenam kodot od priority queue so toa shto 
 * ke ima minimalni promeni
 */

public boolean add(Product p1, int key) {
	if(myLinkedList.size() == max)
		return false;
	
	myLinkedList.add(p1, key, null);
	return true;
}

	public Object poll() {
	myLinkedList.removeRear();
	return peek();
}
public void clear() {
	for(int i = 0; i < myLinkedList.size(); i++) {
		poll();
		i--;
	}

}
public Object peek() {
	return myLinkedList.getEnd();
}
@Override
public String toString() {
	return myLinkedList.toString();
}
}
