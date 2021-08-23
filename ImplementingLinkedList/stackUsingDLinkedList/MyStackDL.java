package stackUsingDLinkedList;

import linkedList.MileLinkedList;
public class MyStackDL{
	
	/* LIFO
	 * IMPLEMENTS: size(), push(Object e), pop(), peek(), isFull(), 
	 * clear(), search(Object e), contains(Object e), toString(),
	 */
	
	private MileLinkedList myLinkedList = new MileLinkedList();
	int top = -1;
	int max = 4;
	public Integer size() {
		return myLinkedList.size();
	}
	public boolean push(Object e) {
		if(this.top == this.max - 1)
			return false;

		myLinkedList.addLast(e);
		top++;
		return true;
	}
	public boolean pop() {
		if(myLinkedList.size() == 0 || this.top < 0)
			return false;

		myLinkedList.removeLast();
		top--;
		return true;
	}
	public Object peek() {
		if(top < 0)
			return null;

		return myLinkedList.getEnd();
	}
	public boolean isFull() {
		if(top == max - 1) {
			return true;
		}
		return false;
	}
	public Integer search(Object e) {
		return myLinkedList.search(e);
	}
	public boolean contains(Object e) {
		if(myLinkedList.contains(e))
			return true;

		return false;
	}
	public void clear() {
		for(int i = 0; i < myLinkedList.size(); i++) {
			myLinkedList.removeLast();
			i--;
		}
	}
	@Override
	public String toString() {
		return myLinkedList.toString();
	}
}
