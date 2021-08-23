package linkedList;

public class MileLinkedList {
	private Node start = null;
	private Node end = null;
	private Integer size = 0;

	public Node getStart() {
		return start;
	}
	public Node getEnd() {
		return end;
	}
	/*
	 * contains: contains(), search(), addFirst(), addLast(), size(),
	 * 			 remove(), removeLast(), removeFirst(), toString(); 
	 */

	public Integer size() {
		return this.size;
	}
	public boolean contains(Object e) {
		if(size == 0)
			return false;

		for(Node ptr = start; ptr != null; ptr = ptr.next) {
			if(ptr.value.equals(e))
				return true;
		}
		return false;
	}
	public Integer search(Object e) {
		Integer count = 1;
		for(Node ptr = start; ptr != null; ptr = ptr.next) {
			if(ptr.value.equals(e))
				return count;

			count++;
		}
		return null;
	}
	public boolean addFirst(Object e){
		if(e.equals(null))
			return false;

		Node newNode = new Node(e);
		if(start == null && end == null) {
			start = newNode;
			end = newNode;
		}else {
			newNode.next = start;
			start.previous = newNode;
			start = newNode;

		}
		size++;
		return true;
	}
	public boolean addLast(Object e) {
		if(e.equals(null))
			return false;

		Node newNode = new Node(e);
		if(start == null && end == null) {
			start = newNode;
			end = newNode;
		}
		else {
			newNode.previous = end;
			end.next = newNode;
			end = newNode;
		}
		size++;
		return true;

	}
	public boolean removeFirst() {
		if(size < 1)
			return false;

		if(size == 1) {
			end = null;
			start = null;
		}else {
			start.next.previous = null;
			start = start.next;
		}
		size--;
		return true;
	}

	public boolean removeLast() {
		if(size < 1)
			return false;

		if(size == 1) {
			end = null;
			start = null;
		}else {

			end.previous.next = null;
			end = end.previous;
		}
		size--;
		return true;
	}
	public boolean remove(Object e) {
		if(!contains(e))
			return false;

		if(size < 1 || e.equals(null))
			return false;

		if(size == 1) {
			end = null;
			start = null;
		}else {
			for(Node ptr = start; ptr != null; ptr = ptr.next) {
				if(ptr.value.equals(e)) {
					if(ptr.equals(start)) {
						removeFirst();
					}else if(ptr.equals(end)) {
						removeLast();
					}else {
						ptr.previous.next = ptr.next;
						ptr.next.previous = null;
					}
				}
			}
		}
		size--;
		return true;
	}

	@Override
	public
	String toString() {
		String s = "[";
		for(Node ptr = this.start; ptr != null; ptr =  ptr.next) {
			if(ptr.next == null) {
				s += ptr.value;
			}else{
				s += (ptr.value + ", ");

			}
		}return s += "]";
	}
}
