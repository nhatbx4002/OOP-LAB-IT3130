package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20 ; 
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0; 
	
	public int getQty () {
		return qtyOrdered; 
	}
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc; 
			qtyOrdered++; 
			System.out.println("The disc has been added ");
		}else {
			System.out.println("The cart is almost full");
		}
	}
	
	//overloading method with input array
	public void addDigitalVideoDisc(DigitalVideoDisc[] listDisc) {
		if(qtyOrdered + listDisc.length <  MAX_NUMBERS_ORDERED ) {
			for(DigitalVideoDisc disc : listDisc ) {
				itemsOrdered[qtyOrdered] = disc;
				qtyOrdered++;
			}
			System.out.println("List disc have been added.");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	//overloading method with arbitrary number of arguments 
//	public void addDigitalVideoDisc(DigitalVideoDisc... disc ) {
//		if(qtyOrdered + disc.length < MAX_NUMBERS_ORDERED) {
//			for(DigitalVideoDisc d : disc) {
//				itemsOrdered[qtyOrdered] = d;
//				qtyOrdered++;
//			}
//			System.out.println("List disc have been added.");
//		}
//		else {
//			System.out.println("The cart is almost full");
//		}
//	}
	
	//overloading method with 2 parameters 
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if(qtyOrdered + 2 < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = dvd1;
			qtyOrdered++;
			itemsOrdered[qtyOrdered] = dvd2;
			qtyOrdered++;
			System.out.println("List disc have been added.");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	public float totalCost() {
		float sum  = 0 ; 
		for(int i = 0 ; i < qtyOrdered  ; i++) {
			sum += 	itemsOrdered[i].getCost() ;
		}
		return sum ; 
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		boolean found = false ; 
		
		for(int i = 0 ; i < qtyOrdered ; i++) {
			if(itemsOrdered[i].equals(disc)) {
				
				found = true ; 
				for(int j = i ; j < qtyOrdered - 1 ; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				itemsOrdered[qtyOrdered] = null ; 
				qtyOrdered--; 
				System.out.println("DVD has been removed");
				break ;
			}
		}
		
		if(!found) {
			System.out.println("Not found disc");
		}
	}

	
	public void searchDVDInCart (String title ) {
		for(int i = 0 ; i < qtyOrdered ; i++) {
			if(itemsOrdered[i].isMatch(title)) {
				System.out.println(itemsOrdered[i].toString());
				return; 
			}
			System.out.println("Not found !");
		}
	}
	
	public void searchDVDInCart (int id) {
		if(id < qtyOrdered && id > 0 ) {
			System.out.println(itemsOrdered[id]);
		}else {
			System.out.print("Not found");
		}
	}
	//print cart 
	public void printCart () {
		float total = 0 ; 
		System.out.println("***********************CART***********************");
		for(int i = 0 ; i < qtyOrdered ; i++) {
			System.out.println((i+1) + ". " + itemsOrdered[i].toString() );
			total += itemsOrdered[i].getCost();
		}
		System.out.println("Total cost : " +  total);
	}
}
