package test2;
/*
 * 				addFirst
			b.	addLast
			c.	removeFirst
			d.	removeLast
			e.	size
			f.	sort
 */
@SuppressWarnings("hiding")
public class MileLinkedList<T>{
	private Node<T> start = null;
	private Node<T> end = null;
	private Integer size = 0;


	/*
	 * contains:  addFirst(), addLast(), size(),
	 * 			 remove(), removeLast(), removeFirst(), toString(), sort; 
	 */

	public Integer size() {
		return this.size;
	}

	public MileLinkedList<T> addFirst(T e, int vl){
		if(e.equals(null))
			return this;

		Node<T> newNode = new Node(e,  vl);
		if(start == null && end == null) {
			start = newNode;
			end = newNode;
		}else {
			newNode.next = start;
			start.previous = newNode;
			start = newNode;

		}
		size++;
		return this;
	}
	public MileLinkedList<T> addLast(T e, Integer vl) {
		if(e.equals(null))
			return this;

		Node<T> newNode = new Node(e, vl);
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
		return this;

	}
	public MileLinkedList<T> removeFirst() {
		if(size < 1)
			return this;

		if(size == 1) {
			end = null;
			start = null;
		}else {
			start.next.previous = null;
			start = start.next;
		}
		size--;
		return this;
	}

	public MileLinkedList<T> removeLast() {
		if(size < 1)
			return this;

		if(size == 1) {
			end = null;
			start = null;
		}else {

			end.previous.next = null;
			end = end.previous;
		}
		size--;
		return this;
	}
	public MileLinkedList<T> remove(T e) {
		if(size < 1 || e.equals(null))
			return this;

		if(size == 1) {
			end = null;
			start = null;
		}else {
			for(Node<T> ptr = start; ptr != null; ptr = ptr.next) {
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
		return this;
	}
	public void sortList()
    {
        Node<T> current = start, index = null, tmp = null ;
        if (start == null) {
            return;
        }
        else {
            while (current != null) {
                // Node index will point to node next to
                // current
                index = current.next;
  
                while (index != null) {
                    // If current node's data is greater
                    // than index's node data, swap the data
                    // between them
                    if (current.valueForSort > index.valueForSort) {
                    	tmp = current;
                        current = index;
                        index = tmp; 
                    }
  
                    index = index.next;
                }
                current = current.next;
            }
        }
    }

	@Override
	public
	String toString() {
		String s = "[";
		for(Node<T> ptr = this.start; ptr != null; ptr =  ptr.next) {
			if(ptr.next == null) {
				s += ptr.value;
			}else{
				s += (ptr.value + ", ");

			}
		}return s += "]";
	}
}
