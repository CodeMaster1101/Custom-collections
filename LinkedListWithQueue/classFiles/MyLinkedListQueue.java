package dLinkedListUsingQueue;
import linkedList.Node;
import customQueueStack.MyQueueArr;

public class MyLinkedListQueue{
	
	/* custom LinkedList that has a queue in the background!
	 * The linked list contains only add(Object o) at the rear and
	 * remove() at the front -> so that we can use a queue in the background,
	 * A.K.A. FIFO
	 * contains: add(Object o), removeFirst(), contains(), search(),
	 * size(), maxSize(), toString(); 
	 */
	MyQueueArr myQueue = new MyQueueArr();
	Node start = null, end = null;
	Boolean x = false;

	public boolean add(Object o) {
		Node newNode = new Node(myQueue.add(o));
		if(newNode.value == x) {
			return false;
		}
		if(start == null && end == null) {
			start = newNode;
			end = newNode;
		}
		else {
			newNode.previous = end;
			end.next = newNode;
			end = newNode;
		}
		return true;
	}

	public boolean removeFirst() {
		if(myQueue.getSize() < 1)
			return false;

		if(myQueue.getSize() == 1) {
			end = null;
			start = null;
		}else {
			start.next.previous = null;
			start = start.next;
		}
		myQueue.removeFirst();
		return true;
	}

	public int size() {
		return myQueue.getSize();
	}
	public int maxSize() {
		return myQueue.getMax();
	}
	public boolean contains(Object o) {
		return myQueue.contains(o);
	}
	public int search(Object o) {
		if(!contains(o))
			return -1;
		int count = 1;
		for(Node t = this.start; t.value != null; t = t.next, count++) {
			if(t.value.equals(o))
				return count;

		}return -1;
	}
	@Override
	public String toString() {
		String s = "[";
		for(Node tmp = start; tmp != null; tmp = tmp.next) {
			s += tmp.value + " ";
		}
		return s += "]";
	}

}
