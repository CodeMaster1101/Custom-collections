package classFiles;

public class LinkedList4Stack {
	private int size = 0;
	Node start = null, end = null;
	/*
	 * PURPOSE: Background of a Priority Stack
	 */
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

	public int size() {
		return this.size;
	}

	public Object getEnd() {
		return end.value;
	}

	public Object getStart() {
		return start.value;
	}

	public boolean remove(Object o) {
		if(!contains(o))
			return false;
		if(!removeCondition())
			return false;
		if(checkForSize1())
			return true;
		
		Node tmp = start;
		while (tmp.value != null) {
			if(tmp.value.equals(o)) {
				if(tmp == start) {
				    removeFirst();
				    break;
				}else if(tmp == end) {
					removeLast();
					return true;
				}else {
					removeMiddle(tmp);
					break;
				}

			}else{
				tmp = tmp.next;
			}

		}
		size--;
		return true;
	}

	public boolean contains(Object o) {
		if(size == 0)
			return false;

		for(Node ptr = start; ptr != null; ptr = ptr.next) {
			if(ptr.value.equals(o))
				return true;
		}
		return false;
	}

	public Object removeLast() {
		Object endValue = end.value;
		if(!removeCondition())
			return null;
		else {
			if(checkForSize1())
				return endValue;
			else {
				end.previous.next = null;
				end = end.previous;
			}
		}
		size--;
		return endValue;

	}

	/* adding elements with priority from 1- 10
	 * example: Start -> (object o, 9),(object o, 6),(object o, 3), <- End
	 * occasions: 1. end; 2. beginning; 3. in-between; 
	 */
	public boolean add(Object o, int priority) {
		Node newNode = new Node(o, priority); 
		if(start == null && end == null){
			generatingFirstNode(o, priority, newNode);
		}
		else {
			if(newNode.priority <= end.priority) {
				addLast(newNode);
			} else if(newNode.priority >= start.priority) {
				addFirst(newNode);
			}else {
				Node tmp = end.previous;
				while(true) {
					if(newNode.priority <= tmp.priority) {
						addMiddle(newNode, tmp);
						break;
					}tmp = tmp.previous;
				}
			}
		}
		size++;
		return true;
	}

	/*
	 * PRIVATE METHODS TO HELP WITH PUBLIC CODE!!!
	 */
	private boolean removeCondition() {
		if(size < 1) 
			return false;
		return true;
	}
	private boolean checkForSize1() {
		if(size == 1) {
			end = null;
			start = null;
			size--;
			return true;
		}return false;
	}
	private boolean removeFirst() {
		if(!removeCondition())
			return false;
		if(checkForSize1())
			return true;
		else {
			start.next.previous = null;
			start = start.next;
		}
		return true;
	}
	private void removeMiddle(Node ptr) {
		ptr.previous.next = ptr.next;
		ptr.next.previous = null;
	}
	private void addMiddle(Node newNode, Node tmp) {
		newNode.previous = tmp;
		newNode.next = tmp.next;
		tmp.next.previous = newNode;
		tmp.next = newNode;

	}
	private void addFirst(Node newNode) {
		newNode.next = start;
		start.previous = newNode;
		start = newNode;

	}
	private void addLast(Node newNode) {
		newNode.previous = end;
		end.next = newNode;
		end = newNode;

	}
	private void generatingFirstNode(Object o, int priority, Node node) {
		start = node;
		end = node;
	}


}
