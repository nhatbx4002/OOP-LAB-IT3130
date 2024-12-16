package hust.soict.dsai.test.cart;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
        DigitalVideoDisc dvd1= new DigitalVideoDisc("The Lion King", "Animation",
                "Roger Aller",87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
                "Gerge Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.89f);
        Cart cart = new Cart();
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(dvd3);

        //Test the print method
        cart.printCart();
        cart.sortMediaByTitle();
        cart.printCart();
	}
}
