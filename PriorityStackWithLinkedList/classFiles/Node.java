package classFiles;

public class Node {
	public Object value;
	public Integer priority;
	public Node next;
	public Node previous;

	public Node(Object e, int pr) {
		if(pr < 1 || pr > 10)
			throw new IllegalArgumentException("pr must be from 1 to 10");
		
		this.value = e;
		this.priority = pr;
	}
	@Override
	public String toString() {
		return ""+this.value;
	}
}
