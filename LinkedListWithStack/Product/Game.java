package Products;
import linkedList.MileLinkedList;

public class Game {
  private String name;
  private double price;
  public static MileLinkedList myGameList = new MileLinkedList();
     public Game(String name, double price) {
	 this.name = name;
	 this.price = price;
   }
   public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
   
   public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public static MileLinkedList gameRepository(){
		return myGameList;
	}
@Override
	public String toString() {	    
		return "(" + this.name + ": " + this.price + ")";
	}

}
