package classFiles;
import Product.Product;
public class MyPriorityQueue{
	
	int max = 6;
	MileLinkedList myLinkedList = new MileLinkedList();
	//Priority-Oriented
	/*contains: add(Product, priority), poll(), clear(), peek(), toArray(), toString(), 
	 * rules: remove's the head of the queue -> smallest priority object.
	 * maximum 6 elements.
	 *  
	 */
	
	public boolean add(Product p1, Integer pr) {
		if(myLinkedList.size() == max)
			return false;
		
		myLinkedList.add(p1, pr, null);
		return true;
	}
	
	public Object poll() {
		myLinkedList.remove();
		return peek();
	}
	public void clear() {
		for(int i = 0; i < myLinkedList.size(); i++) {
			poll();
			i--;
		}
	
	}
	public Object peek() {
		return myLinkedList.getStart();
	}
	public Object[] toArray() {
		Object arr[] = new Object[myLinkedList.size()];
		int i = 0;
		for(Node tmp = myLinkedList.getStart(); tmp != null; tmp = tmp.next ) {
			arr[i] = tmp;
			i++;
		}return arr;
	}
	public void disp(Object[] arr) {
		System.out.print("[");
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ", ");
		}System.out.print("]");
	}
 	@Override
	public String toString() {
		return myLinkedList.toString();
	}
}
