package queueUsingDLinkedList;
import linkedList.MileLinkedList;

public class MyQueueDL {
	
	/* FIFO
	 * IMPLEMENTS: enqueue(Object e), isEmpty(), offer(Object e), pop(),
	 * poll(), size(), contains(Object e), clear(), toString();
	 */
	
	private MileLinkedList myLinkedList = new MileLinkedList();
	int max = 6;
	public boolean enqueue(Object e) {
		if(myLinkedList.size() >= max)
			return false;

		myLinkedList.addLast(e);
		return true;
	}
	public boolean isEmpty() {
		if(myLinkedList.size() == 0)
			return true;
		return false;
	}
	public boolean offer(Object e) {
		if(myLinkedList.size() < max)
			enqueue(e);

		return false;
	}
	public boolean pop() {
		if(myLinkedList.size() < 1 || myLinkedList.size() > 6)
			return false;

		myLinkedList.removeFirst();
		return true;
	}
	public Object poll() {
		if(myLinkedList.size() < 1)
			return null;

		return myLinkedList.getStart();
	}
	public int size() {
		return myLinkedList.size();
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
