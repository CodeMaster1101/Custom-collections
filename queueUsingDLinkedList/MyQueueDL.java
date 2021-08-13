package queueUsingDLinkedList;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class MyQueueDL implements Queue<Object> {

	private DLinkedList myList = new DLinkedList();
	private static Exception e = new Exception();

	@Override
	public int size() {
		if(myList.size >= Integer.MAX_VALUE)
			return Integer.MAX_VALUE;

		return myList.size;
	}

	@Override
	public boolean isEmpty() {
		if(myList.size == 0)
			return true;

		return false;
	}

	@Override
	public boolean contains(Object o) {
		Node tmp = myList.start;
		while(tmp.value != null) {
			if(tmp.value == o)
				return true;

			tmp = tmp.next;

		}return false;
	}

	@Override
	public Iterator<Object> iterator() {
		LinkedList<Object> coll = new LinkedList<Object>();
		Node ptr = myList.start;
		while(ptr != null) {
			coll.add(ptr);
			ptr = ptr.next;
		}
		Iterator<Object> it = coll.iterator();
		return it;
	}

	@Override
	public Object[] toArray() {
		Object[] arr = new Object[myList.size];
		Node[] nodeArr = new Node[myList.size];
		Node ptr = myList.start;
		for(int i = 0; i < myList.size; i++) {
			nodeArr[i] = ptr;
			arr[i] = (Object) nodeArr[i];
			ptr = ptr.next;
		}
		return arr;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		return myList.remove((Object) o);

	}

	@Override
	public boolean containsAll(Collection<?> c) {
		int i = 0;
		Node ptr = myList.start;
		for (Object object : c) {
			if(ptr == null) {
				break;
			}else {
				if(ptr.value.equals(object)) {
					i++;
				}ptr = ptr.next;

			}
		}
		if(i == c.size())
			return true;

		return false;
	}

	@Override
	public boolean addAll(Collection<?> c) {
		try {
			for (Object object : c) {
				myList.addLast(object);
			}
		}
		catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		try {
			for (Object object : c) {
				myList.remove(object);
			}
		} 
		catch (Exception e) {
			return false;
		}

		return true;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		Node ptr = myList.start;
		for (Object object : c) {
			if(contains(object)) {
				if((ptr.value.equals(object))) {
					myList.remove(object);
				}
			}

			ptr = ptr.next;

		}
		return true;
	}

	@Override
	public void clear() {
		for(int i = 0; i < myList.size; i++) {
			myList.removeFirst();

		}myList.size = 0;
		myList.start = null;
		myList.end = null;

	}

	@Override
	public boolean add(Object e) {
		myList.addLast(e);
		//no need to catch an exception, the length is unlimited!
		return true;
	}


	@Override
	public boolean offer(Object e) {
		return false;
	}

	@Override
	public Object remove() {
		if(myList.size <= 0) {
			e.getCause();
			e.toString();
		}
		return myList.removeFirst();
	}

	@Override
	public Object poll() {
		if(isEmpty())
			return null;

		return myList.removeFirst();
	}

	@Override
	public Object element() {
		if(isEmpty())
			e.toString();

		return myList.start;

	}

	@Override
	public Object peek() {
		if(isEmpty())
			return null;

		return myList.start;
	}
	//private helping methods
	@Override
	public String toString() {
		String result = "[";
		Node tmp = myList.start;
		while(tmp != null) {
			result += tmp + " ";
			tmp = tmp.next;
		}return result += "]";
	}

}
