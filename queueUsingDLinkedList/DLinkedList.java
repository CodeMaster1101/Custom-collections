package queueUsingDLinkedList;

public class DLinkedList{
	Integer size = 0;
	Node end;
	Node start;

	public Object addLast(Object object) {
		Node newNode = new Node(object);
		if(size < 1) {
			start = newNode;
			end = newNode;
			size++;
		}else {
			newNode.previous = end;
			end.next = newNode;
			end = newNode;
			size++;
		}
		
		return newNode.value;
	}
	
	public boolean addFirst(int value) {
		Node newNode = new Node(value);
		if (start == null && end == null) {
			start = newNode;
			end = newNode;
		} 
			
			
			newNode.next = start;
			start.previous = newNode;
			start = newNode;
		
		size++;
		return true;
	} public boolean containsValue(Object o) {
		Node node = start;
		while(node!= null) {
			if(node.equals(o))
				return true;

			node = node.next;
		}
		return false;
	}
	public int getSize() {
		return this.size;
	}

	public boolean remove(Object o) {
		if(start == null && end == null) {
			return false;
		}
		if(size == 1 && containsValue(o)) {
			start = null;
			end = null;
			size--;
			return true; 
		}
		if(containsValue(o)) {
			Node pointer = start;
			while(true) {
				if(pointer.value.equals(o)) {
					if(pointer == start) {
						start = pointer.next;
						start.next.previous = null;
						size--;
						return true;
					}
					if(pointer == end) {
						end = pointer.previous;
						pointer.previous.next = null;
						size--;
						return true;

					}else {
						pointer.previous.next = pointer.next;
						pointer.next.previous = null;
						size--;
						return true;


					}
				}else {
					pointer = pointer.next;
				}
			}

		}


		return false;
	}

	public boolean removeLast() {
		if(size < 1)
			return false;
		Node tmp = end;
		end = tmp.previous;
		tmp.previous.next = null;
		size--;
		return true;

	}
	public boolean removeFirst() {
		if(size < 1) {
			return false;
		}
		Node tmp = start;
		start = tmp.next;
		tmp.next.previous = null;
		size--;
		return true;
	}
	public String toStringReversed() {

		String result = "[";
		Node pointer = end;
		while (pointer != null) {
			result += pointer.value + ", ";
			pointer = pointer.previous;
		}
		result += "]";
		return result;
	}
	public String toString() {

		String result = "[";
		Node pointer = start;
		while (pointer != null) {
			result += pointer.value + ", ";
			pointer = pointer.next;
		}
		result += "]";
		return result;
	}


}