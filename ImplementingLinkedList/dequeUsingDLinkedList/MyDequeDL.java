package dequeUsingDLinkedList;
import linkedList.MileLinkedList;
public class MyDequeDL{

	/* FIFO + LIFO -> Stack and Queue
	 * insetFront(): Adds an item at the front of Dequeue. 
		insertRear(): Adds an item at the rear of Dequeue. 
		deleteFront(): Deletes an item from front of Dequeue. 
		deleteRear(): Deletes an item from rear of Dequeue.
		In addition to above operations, following operations are also supported 
		getFront(): Gets the front item from queue. 
		getRear(): Gets the last item from queue. 
		isEmpty(): Checks whether Dequeue is empty or not. 
		isFull(): Checks whether Dequeue is full or not. 
	 */
	private MileLinkedList myLinkedList = new MileLinkedList();
	private int max = 5;

	public boolean insertFront(Object e) {
		if(myLinkedList.size() > max - 1)
			return false;

		myLinkedList.addFirst(e);
		return true;
	}
	public boolean insertRear(Object e) {
		if(myLinkedList.size() > max - 1)
			return false;

		myLinkedList.addLast(e);
		return true;
	}
	public boolean deleteFront() {
		if(myLinkedList.size() < 1)
			return false;

		myLinkedList.removeFirst();
		return true;
	}
	public boolean deleteRear() {
		if(myLinkedList.size() < 1)
			return false;

		myLinkedList.removeLast();
		return true;
	}
	public Object getFront() {
		return myLinkedList.getStart();
	}
	public Object getRear() {
		return myLinkedList.getEnd();
	}
	public boolean isEmpty() {
		if(myLinkedList.size() == 0)
			return true;

		return false;
	}
	public boolean isFull() {
		if(myLinkedList.size() == max)
			return true;

		return false;
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
