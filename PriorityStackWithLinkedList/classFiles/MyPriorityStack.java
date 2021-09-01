package classFiles;
public class MyPriorityStack {
	int max = 5;
	LinkedList4Stack myLinkedList = new LinkedList4Stack();
	/* LIFO
	 * This Priority Stack class contains:
	 * 		push(object o, integer priority), size(), pop(), peek(),
	 *      contains()object o, clear(), remove(object o), toString()
	 */
	public boolean push(Object o, int priority) {
		if(size() == 5)
			return false;
		return myLinkedList.add(o, priority);
	}
	public int size() {
		return myLinkedList.size();
	}
	public Object peek() {
		return myLinkedList.getEnd();
	}
	public Object pop() {
		return myLinkedList.removeLast();
	}
	public boolean contains(Object o) {
		return myLinkedList.contains(o);
	}
	public void clear() {
		Node tmp = myLinkedList.start;
		while(tmp != null) {
			myLinkedList.remove(tmp);
		}
	}
	public boolean remove(Object o) {
		return myLinkedList.remove(o);
	}
	@Override
	public String toString() {
		return myLinkedList.toString();
	}
}
