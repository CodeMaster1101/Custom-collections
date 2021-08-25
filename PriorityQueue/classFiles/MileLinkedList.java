package classFiles;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MileLinkedList {
	private Node start;
	private Node end;
	private Integer size = 0;
	public Node getStart() {
		return start;
	}
	public Node getEnd() {
		return end;
	}
	/*
	 * contains: contains(), search(), add(), size(),
	 * 			 remove(), removeRear(), toString(). 
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

	public boolean remove() {
		if(start == null && end == null)
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
	public boolean removeRear() {
		if(start == null && end == null)
			return false;
		
		if(size == 1) {
		   end = null;
		   start = null;
		}else{
		end.previous.next = null;
		end = end.previous;
		}size--;
		return true;
	}

	/*
	 * definitivno se izmaciv za algoritmov, podole ima i rekurzija i sve.
	 * minimum 5h go pravev(so pauzi).
	 * steps:
	 * create new node -> check for no elements -> set the currentNode(the one we want to call recursively) to start if its null
	 * -> loop through the linked list to check for priority placement -> stop when our newNode has become the biggest priority
	 * -> then check for the biggest priority in the looped elements and compare the biggest one (x) with the current temporary priority ->
	 * if(the biggest prior is equal to the temporary one than just add the element), else(call the method recursively until the we have found the lowest priority after ours(the new noode's).
	 * 
	 */
	boolean add(Object o, int pr, Node currentNode){
		Node newNode = new Node(o, pr); 
		if(start == null && end == null) {
			start = newNode;
			end = newNode;
			size++;
			return true;
		}
		if(currentNode == null)
			currentNode = start;

		for(Node tmp = currentNode; tmp != null; tmp = tmp.next) {
			if(newNode.priority >= tmp.priority) {
				Integer x = maxPriority(pr);
				if(tmp.priority == x) {
					if(tmp == end) {
						newNode.previous = end;
						end.next = newNode;
						end = newNode;
						size++;
						return true;
					}
					else if(tmp == start) {
						newNode.previous = start;
						newNode.next = start.next;
						start.next = newNode;

						size++;
						return true;
					}else {
						newNode.previous = tmp;
						newNode.next = tmp.next;
						tmp.next = newNode;
						size++;
						return true;
					}
				}else {		
					return add(o, pr, currentNode = currentNode.next);
				}

			}
			else if(tmp.next == null && pr < tmp.priority) {
				if(size < 2) {
					newNode.next = end;
					end.previous = newNode;
					start = newNode;
					size++;
					return true;
				}
				else {
					newNode.next = start;
					start.previous = newNode;
					start = newNode;
					size++;
					return true;
				}

			}

		}
		return false;
	}

	private Integer maxPriority(Integer pr) {
		Collection<Integer> c = new ArrayList<>();
		for(Node tmp = start; tmp != null; tmp = tmp.next) {
			if(pr >= tmp.priority) {
				Integer x = tmp.priority;
				c.add(x);	
			}
		}return Collections.max(c);
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
