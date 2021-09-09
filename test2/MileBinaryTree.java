package test2;

public class MileBinaryTree<T> {
	public TNode<T> root = null;
	private Integer size = 0;
	public int size() {
		return this.size;
	}

	@SuppressWarnings("rawtypes")
	public MileBinaryTree<T> add(T o, int priority) {
		@SuppressWarnings("unchecked")
		TNode<T> newNode = new TNode(o, priority);
		if(isRootNull()) {
			placeRoot(newNode);		
		}else {
			TNode<T> tmp = root;
			while(true) {
				if(newNode.priority > tmp.priority) {
					placeRightChild(newNode, tmp);
					break;
				}
				else if(newNode.priority < tmp.priority){
					placeLeftChild(newNode, tmp);
					break;
				}else {
					return this;
				}
			}
		}
		size++;
		return this;
	}

	/*
	 * PRIVATE METHODS FOR EASIER CODE
	 */

	private void placeLeftChild(TNode<T> newNode, TNode<T> tmp) {
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

	private void placeRoot(TNode<T> newNode) {
		root = newNode;

	}
	private void placeRightChild(TNode<T> newNode, TNode<T> tmp) {
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


	/*
		(a) inOrder (Left, Root, Right); 
		(b) preOrder (Root, Left, Right); 
		(c) postOrder (Left, Right, Root);
	 */
	public void inOrder(TNode<T> node) {
		if(node == null) {
			return;
		}

		inOrder(node.leftChild); 
		System.out.print(node);
		inOrder(node.rightChild);

	}
	public void preOrder(TNode<T> node) {
		if(node == null) {
			return;
		}
		System.out.print(node);
		preOrder(node.leftChild); 
		preOrder(node.rightChild);
	}
	public void postOrder(TNode<T> node) {
		if(node == null) {
			return;
		}
		postOrder(node.leftChild); 
		postOrder(node.rightChild);
		System.out.print(node);
	}
	
}
