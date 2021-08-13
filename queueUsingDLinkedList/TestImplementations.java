package TestImplementation;

import java.util.Collection;
import java.util.LinkedList;

import Products.Book;
import queueUsingDLinkedList.MyQueueDL;
public class TestImplementations {

	public static void main(String[] args) {
		Book[] books = new Book[12];
		books[0] = new Book("Uuf");
		books[1] = new Book("LoL");
		books[2] = new Book("Whatever");
		books[3] = new Book("Romeo");
		Collection<Object> bookColl = objCollection(books);
		books[4] = new Book("dasd");
		books[5] = new Book("wewe");
		MyQueueDL queue = new MyQueueDL();
		queue.add(books[0]);
	    queue.add(books[1]);
		queue.add(books[2]);
     	queue.add(books[3]);
     	queue.add(books[4]);
    	queue.add(books[5]);
		
	
		System.out.println(queue.retainAll(bookColl));
		System.out.println(queue);
	}
	static Collection<Object> objCollection(Object[] arr){
		LinkedList<Object> list = new LinkedList<>();
		for (Object object : arr) {
			if(object != null) {
				list.addLast(object);
			}
			else
				continue;
				
		}return list;
	}static void arrDisplay(Object[] arr){
		for (Object object : arr) {
			System.out.print(object + " ");
		}
	}

}
