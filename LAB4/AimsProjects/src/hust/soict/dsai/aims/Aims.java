package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {

	public static void main(String[] args) {
		//Create new Cart ;
		Cart anOrder = new Cart();
		
		//Create new DVDs object 
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers", 87 , 19.95f);
		
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas", 87 , 24.95f);
		
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
		
		anOrder.addDigitalVideoDisc(dvd1,dvd2);
		//print total cost of the items in the cart 
		System.out.print("Total Cost is : ");
		System.out.println(anOrder.totalCost());
		
		//test remove DVD from cart
		System.out.print("Total Cost is : ");
		System.out.println(anOrder.totalCost());
		
	
	}

}
