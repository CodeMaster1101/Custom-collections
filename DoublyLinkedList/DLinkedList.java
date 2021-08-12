
public class DLinkedList{
	Integer size = 0;
	DNode end;
	DNode start;

	public void push(int val) {
		DNode newNode = new DNode(val);
		if(size < 1) {
			start = newNode;
			end = newNode;
		}
		newNode.previous = end;
		end.next = newNode;
		end = newNode;
		
		
	}
	public Integer peek() {
		if(size >= 1) {
			return end.value;
		}
		return null;
		
	}
	public Integer pop(int val) {
		int data1 = 0;
		if(start == null && end == null) {
			return null;
		}
		if(size == 1 && containsValue(val)) {
			start = null;
			end = null;
			size--;
			return data1; 
		}
		if(containsValue(val)) {
			
			DNode pointer = start;
			while(true) {
				if(pointer.value.equals(val)) {
					int data = pointer.value;
					if(pointer == start) {
						start = pointer.next;
						start.next.previous = null;
						size--;
						return data;
					}
					if(pointer == end) {
						end = pointer.previous;
						pointer.previous.next = null;
						size--;
						return data;

					}else {
						pointer.previous.next = pointer.next;
						pointer.next.previous = null;
						size--;
						return data;


					}
				}else {
					pointer = pointer.next;
				}
			}

		}


		return null;
	}
	public boolean addFirst(int value) {
		DNode newNode = new DNode(value);
		if (start == null && end == null) {
			start = newNode;
			end = newNode;
		} 
			
			
			newNode.next = start;
			start.previous = newNode;
			start = newNode;
		
		size++;
		return true;
	} public boolean containsValue(int val) {
		DNode node = start;
		while(node!= null) {
			if(node.value == val)
				return true;

			node = node.next;
		}
		return false;
	}
	public int getSize() {
		return this.size;
	}

	public boolean remove(int val) {
		if(start == null && end == null) {
			return false;
		}
		if(size == 1 && containsValue(val)) {
			start = null;
			end = null;
			size--;
			return true; 
		}
		if(containsValue(val)) {
			DNode pointer = start;
			while(true) {
				if(pointer.value.equals(val)) {
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
		DNode tmp = end;
		end = tmp.previous;
		tmp.previous.next = null;
		size--;
		return true;

	}
	public String toStringReversed() {

		String result = "[";
		DNode pointer = end;
		while (pointer != null) {
			result += pointer.value + ", ";
			pointer = pointer.previous;
		}
		result += "]";
		return result;
	}
	public String toString() {

		String result = "[";
		DNode pointer = start;
		while (pointer != null) {
			result += pointer.value + ", ";
			pointer = pointer.next;
		}
		result += "]";
		return result;
	}


}
