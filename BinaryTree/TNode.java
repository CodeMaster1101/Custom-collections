package binaryTree;

public class TNode {
	Integer priority;
	Object value;
	TNode rightChild, leftChild;
	TNode parent;
	public TNode(Object value, Integer priority) {
		super();
		this.priority = priority;
		this.value = value;
	}
@Override
public String toString() {
	// TODO Auto-generated method stub	return super.toString();
	return this.priority + "";
}

}
