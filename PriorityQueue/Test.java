import java.util.ArrayList;
import java.util.List;

import Product.Product;
import classFiles.MyPriorityQueue;

public class Test {

	public static void main(String[] args) {
		MyPriorityQueue queue = new MyPriorityQueue();
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(40, "mw2")); // 0
		productList.add(new Product(5, " gta"));// 1
		productList.add(new Product(10, "cod"));// 2
		productList.add(new Product(30, "wof"));// 3
		productList.add(new Product(35, "smite"));// 4
		productList.add(new Product(20, "lol"));// 5
		productList.add(new Product(15, "skate"));// 6
		queue.add(productList.get(0), 7);
		queue.add(productList.get(1), 9);
		queue.add(productList.get(2), 6);
		queue.add(productList.get(3), 8);
		queue.add(productList.get(5), 10);
		queue.add(productList.get(6), 17);
		
		System.out.print( "Array form: " );
		queue.disp(queue.toArray());
		System.out.println();
		System.out.println();;
		System.out.println("Priority queue " + queue);
	}

}
