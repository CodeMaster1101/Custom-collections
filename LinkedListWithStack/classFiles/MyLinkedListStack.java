package dLinkedListUsingStack;
import customQueueStack.MyStackArr;
import linkedList.Node;
public class MyLinkedListStack {
	/* custom LinkedList that has a stack in the background!
	 * The linked list contains only add(Object o) at the rear and
	 * remove() at the rear -> so that we can use a stack in the background,
	 * A.K.A. LIFO
	 * contains: add(Object o), removeLast(), contains(), search(),
	 * size(), maxSize(), toString(); 
	 */
	Node start, end = null;
	MyStackArr myStack = new MyStackArr();
	
	public boolean add(Object o) {
		Node newNode = new Node(myStack.push(o));
		if(newNode.value == (Boolean) false)
			return false;
		if(end == null && start == null) {
			start = newNode;
			end = newNode;
			return true;
		}
		newNode.previous = end;
		end.next = newNode;
		end = newNode;
		return true;
	}
	public boolean removeLast() {
		if(myStack.size() < 0)
			return false;
		if(myStack.size() == 1) {
			end = null;
			start = null;
			return true;
		}
		end.previous.next = null;
		end = end.previous;
		myStack.pop();
		return true;
	}
	public int size() {
		return myStack.size();
	}
	public int maxSize() {
		return myStack.getMax();
	}
	public boolean contains(Object o) {
		return myStack.contains(o);
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
