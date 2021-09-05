package binaryTree;

public class MyBinaryTree {
	public TNode root = null;
	private int size = 0;
	public int size() {
		return this.size;
	}
	
	public MyBinaryTree add(Object o, int priority) {
		TNode newNode = new TNode(o, priority);
		if(isRootNull()) {
			placeRoot(newNode);		
		}else {
			TNode tmp = root;
			while(true) {
				isEqual(tmp, newNode);
				if(newNode.priority > tmp.priority) {
					placeRightChild(newNode, tmp);
					break;
				}
				else if(newNode.priority < tmp.priority){
					placeLeftChild(newNode, tmp);
					break;
				}	
			}
		}
		size++;
		return this;
	}

	/*
	 * PRIVATE METHODS FOR EASIER CODE
	 */

	private void placeLeftChild(TNode newNode, TNode tmp) {
		while(true) {
			if(tmp.priority < newNode.priority) {
				placeRightChild(newNode, tmp);
				return;
			}
			else if(tmp.leftChild == null) {
				tmp.leftChild = newNode;
				newNode.parent = tmp;
				break;
			}else {
				tmp = tmp.leftChild;
			}
		}
	}

	private void placeRoot(TNode newNode) {
		root = newNode;

	}
	private void placeRightChild(TNode newNode, TNode tmp) {
		while(true) {
			if(tmp.priority > newNode.priority) {
				placeLeftChild(newNode, tmp);
				return;
			}
			else if(tmp.rightChild == null) {
				tmp.rightChild = newNode;
				newNode.parent = tmp;
				break;
			}else {
				tmp = tmp.rightChild;
			}
		}


	}
	private boolean isRootNull() {
		if(root == null){
			return true;
		}
		return false;
	}

	private MyBinaryTree isEqual(TNode tmp, TNode newNode) {
		if(tmp == null || newNode == null) {
			throw new IllegalArgumentException("element is null");
		}
		if(tmp.priority == newNode.priority)
			throw new IllegalArgumentException("already exsists");

		return this;

	}

	/*
		(a) inOrder (Left, Root, Right); 
		(b) preOrder (Root, Left, Right); 
		(c) postOrder (Left, Right, Root);
	 */
	public void inOrder(TNode node) {
		if(node == null) {
			return;
		}
		inOrder(node.leftChild); // prints all the left elements recursively starting from the lowest priority
		System.out.print(node.priority + " ");
		inOrder(node.rightChild);// prints all the elements from the right A.K.A bigger than the root

	}
	public void preOrder(TNode node) {
		if(node == null) {
			return;
		}
		System.out.println(node.priority);
		preOrder(node.leftChild); 
		preOrder(node.rightChild);
	}
	public void postOrder(TNode node) {
		if(node == null) {
			return;
		}
		postOrder(node.leftChild); 
		postOrder(node.rightChild);
		System.out.print(node.priority + " ");
	}
}
