package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
	        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
	        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.89f);

	        // Create a store
	        Store store = new Store();

	        // Test adding DVDs
	        store.addDVD(dvd1);
	        store.addDVD(dvd2);
	        store.addDVD(dvd3);

	        // Test removing a DVD
	        store.removeDVD("Star Wars");
	        store.removeDVD("Frozen");
	}

}
