import java.util.ArrayList;
import java.util.List;

import Product.Product;
import classFiles.LinkedList4Stack;
import classFiles.MyPriorityQueue;
import classFiles.MyPriorityStack;

public class Test {

	public static void main(String[] args) {
		MyPriorityStack prStack = new MyPriorityStack();
		List<Product> productList = new ArrayList<>();
		productList.add(new Product(40, "mw2")); // 0
		productList.add(new Product(5, " gta"));// 1
		productList.add(new Product(10, "cod"));// 2
		productList.add(new Product(30, "wof"));// 3
		productList.add(new Product(35, "smite"));// 4
		productList.add(new Product(20, "lol"));// 5
		productList.add(new Product(15, "skate"));// 6
		//LinkedList4Stack list = new LinkedList4Stack();
		prStack.push(productList.get(0), 6);
		prStack.push(productList.get(5), 2);
		prStack.push(productList.get(2), 3);
		prStack.push(productList.get(6), 1);
		prStack.push(productList.get(1), 4);
		prStack.push(productList.get(3), 5);
		
		
		// start - 6 5 4 3 2 1 end
		System.out.println(prStack);
	}

}
