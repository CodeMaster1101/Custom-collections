
public class DNode {

	  public Integer value;
	  public DNode next;
	  public DNode previous;
	  
	  public Integer getValue() {
	    return value;
	  }
	  public DNode getNext() {
	    return next;
	  }
	  public DNode getPrevious() {
		  return previous;
	  }
	  public DNode(int value) {
			 this.value = value;
		 }
	  @Override
		public String toString() {
		  return String.valueOf(this.value);
		}
	  }
