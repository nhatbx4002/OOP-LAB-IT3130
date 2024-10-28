
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20 ; 
	
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	
	private int qtyOrdered = 0; 
	
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered] = disc; 
			qtyOrdered++; 
			System.out.println("The disc has been added ");
		}else {
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
			
}
