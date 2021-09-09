package test2;

public class TNode<T> {
	Integer priority;
	T value;
	TNode<T> rightChild, leftChild, parent;
	public TNode(T value, Integer priority) {
		super();
		this.priority = priority;
		this.value = value;
	}
@Override
public String toString() {
	// TODO Auto-generated method stub	return super.toString();
	return "(" + "{"+this.priority+"}" + " " + this.value + ") ";
}

}
