package linkedList;

public class Node {
	public Object value;
	public Node next;
	public Node previous;

	public Node(Object e) {
		this.value = e;
	}
	@Override
	public String toString() {
		return ""+this.value;
	}
}
