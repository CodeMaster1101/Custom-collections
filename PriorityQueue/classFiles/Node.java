package classFiles;

public class Node {
	public Object value;
	public Integer priority;
	public Node next;
	public Node previous;

	public Node(Object e, int pr) {
		this.value = e;
		this.priority = pr;
	}
	@Override
	public String toString() {
		return ""+this.value;
	}
}
