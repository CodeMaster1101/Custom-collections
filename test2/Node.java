package test2;

public class Node<T> {
	public T value;
	public Node<T> next;
	public Node<T> previous;
	public Integer valueForSort;
	public Node(T e, Integer pr) {
		this.value = e;
		this.valueForSort = pr;
	}
	public Node() {
		
	}
	
	@Override
	public String toString() {
		return ""+this.value;
	}
}
