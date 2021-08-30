package customQueueStack;

public class MyQueueArr {
	//FIFO
	/*
	 * the custom queue uses an array in the background
	 * contains: public : add(Object o), removeFirst(), getSize(),
	 * getMax(), toString(), contains();
	 * 			 private: shiftRight(), sizeReduction();
	 * PURPOSE: background of a custom-made linked list
	 */
	private int max = 10;
	private int size = 0;
	private int sizeCounter;
	private Object[] myArray = new Object[max];
	public Object add(Object o) {
		if(size == max)
			return false;

		myArray[size] = o;
		size++;
		return myArray[size - 1];

	}

	public boolean removeFirst() {
		if(size == 0)
			return false;

		shiftRight();
		sizeReduction();
		return true;
	}

	private void shiftRight() {
		for(int i = 1; i <= size; i++) {
			myArray[i - 1] = myArray[i]; 
		}
	}
	public boolean contains(Object o) {
		for(int i = 0; i < size; i++) {
			if(myArray[i].equals(o))
				return true;
		}return false;
	}
	@Override
	public String toString() {
		String s = "[";
		for(int i = 0; i < size; i++) {
			s += myArray[i] + " ";
		}
		return s += "]";
	}
	private int sizeReduction() {
		sizeCounter = size - 1;
		size--;
		return sizeCounter;

	}
	public int getSize() {
		return size;
	}
	public int getMax() {
		return max;
	}
}
