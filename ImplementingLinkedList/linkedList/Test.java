package linkedList;
import Products.Game;
import dequeUsingDLinkedList.MyDequeDL;
import queueUsingDLinkedList.MyQueueDL;
import stackUsingDLinkedList.MyStackDL;
public class Test {

	/*
	  * 1.	Create doubly linked list with methods addFirst, addLast, removeFirst, removeLast, size, print
		2.	Create stack with push, pop, peek, size methods using the DLL from exercise 1 in as a storage
		3.	Create queue with enqueue, exercise, size using DLL from excersize1 
		4.	Create dequeue using DLL – same as queue but elements can be added or removed from both ends

	  */
	public static void main(String[] args) {
		MileLinkedList test = new MileLinkedList();
		MyQueueDL queue = new MyQueueDL();
		MyStackDL stack = new MyStackDL();
		MyDequeDL deque = new MyDequeDL();
		Game[] games = new Game[7];
		games[0] = new Game("MW3", 23.6);
		games[1] = new Game("Far Cry 3", 25.6);
		games[2] = new Game("Far Cry 2", 21.6);
		games[3] = new Game("Gta Vice City", 23.6);
		games[4] = new Game("Total overdose", 25.6);
		games[5] = new Game("Modern Warfare", 21.6);
		games[6] = new Game("COD4", 21.6);
		/*
		 * FIFO(Queue)
		 * max capacity of the queue: 6.
		 */
		queue.enqueue(games[0]);
		queue.enqueue(games[5]);
		queue.enqueue(games[2]);
		queue.enqueue(games[3]);
		queue.enqueue(games[4]);
		queue.enqueue(games[1]);
		queue.enqueue(games[6]);
		queue.clear();
		System.out.println("Queue: " + queue);
		/*
		 * LIFO(Stack)
		 * max capacity of the Stack: 4.
		 */
		stack.push(games[3]);
		stack.push(games[2]);
		stack.push(games[1]);
		stack.push(games[4]);	
		System.out.println(stack.search(games[5]));
		System.out.println("Stack:" + stack);
		
		/*
		 * LIFO + FIFO
		 * (Dequeue) -> size 5
		 */
		System.out.println("Dequeue: " + deque);
	}
	

}
