package Product;

public class Product {
Integer price;
String type;
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public Product(Integer price, String type) {
	super();
	this.price = price;
	this.type = type;
}
@Override
	public String toString() {
		return "(" + this.type + ")";
	}

}
