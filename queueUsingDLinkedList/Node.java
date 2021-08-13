package queueUsingDLinkedList;


public class Node {

	  public Object value;
	  public Node next;
	  public Node previous;
	  
	  public Object getValue() {
	    return value;
	  }
	  public Node getNext() {
	    return next;
	  }
	  public Node getPrevious() {
		  return previous;
	  }
	  public Node(Object object) {
			 this.value = object;
		 }
	  @Override
		public String toString() {
		  return String.valueOf(this.value);
		}
	  }
