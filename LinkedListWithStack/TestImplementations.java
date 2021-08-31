package TestImplementation;

import Products.Game;
import customQueueStack.MyQueueArr;
import dLinkedListUsingQueue.MyLinkedListQueue;

public class TestImplementations {

	public static void main(String[] args) {
		Game[] games = new Game[7];
		games[0] = new Game("cod", 23);
		games[1] = new Game("desperado", 23);
		games[2] = new Game("gta", 23);
		games[3] = new Game("monopoly", 23);
		games[4] = new Game("totatoverdose", 23);
		games[5] = new Game("Far cry", 23);
		games[6] = new Game("halo", 23);
		MyLinkedListQueue myLinkedListQ = new MyLinkedListQueue();
		myLinkedListQ.add(games[0]);
		myLinkedListQ.add(games[1]);
		myLinkedListQ.add(games[2]);
		System.out.println(myLinkedListQ.search(games[0]));
		
		System.out.println(myLinkedListQ);
	}
	
}
