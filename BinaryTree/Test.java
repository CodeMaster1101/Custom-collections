import java.util.LinkedList;
import Product.Product;
import binaryTree.MyBinaryTree;
public class Test {

	public static void main(String[] args) {
		MyBinaryTree tree = new MyBinaryTree();
		LinkedList<Product> products = new LinkedList<Product>();
		products.add(new Product(80, "can"));
		products.add(new Product(40, "book"));
		products.add(new Product(100, "fork"));
		products.add(new Product(30, "spoon"));
		products.add(new Product(50, "spoon"));
		products.add(new Product(83, "spoon"));
		products.add(new Product(105, "spoon"));

		tree.add(products.get(0), products.get(0).getPrice());
		tree.add(products.get(1), products.get(1).getPrice());
		tree.add(products.get(2), products.get(2).getPrice());
		tree.add(products.get(3), products.get(3).getPrice());
		tree.add(products.get(4), products.get(4).getPrice());
		tree.add(products.get(5), products.get(5).getPrice());
		tree.add(products.get(6), products.get(6).getPrice());
		tree.postOrder(tree.root);
		
	}
}