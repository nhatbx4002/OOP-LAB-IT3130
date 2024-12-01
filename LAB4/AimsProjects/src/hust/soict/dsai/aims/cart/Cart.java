package hust.soict.dsai.aims.cart;
import hust.soict.dsai.aims.media.*;
import java.util.*;
public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20 ; 
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	
	//add media method 
	public void addMedia (Media media) {
		if( itemsOrdered.size() + 1  >= MAX_NUMBERS_ORDERED ) {
			System.out.println("The cart is almost full !");
			return;
		}
		if(!itemsOrdered.contains(media)){
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " has been added.");
		}else{
			System.out.println(media.getTitle() + " has already exist!");
		}
		
		return ;
	}
	
	//remove media method
	public void removeMedia (Media media) {
		if(itemsOrdered.size() == 0 ) {
			System.out.print("Nothing to remove !");
			return ; 
		}
		if(itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println(media.getTitle() + " has been removed.");
			return ; 
		}
	}
	
	//overloading method add media 
	public void addMedia (Media[] MediaList) {
		if(itemsOrdered.size() + MediaList.length + 1 >= MAX_NUMBERS_ORDERED ) {
			System.out.println("The cart is almost full!");
			return ; 
		}
		for(Media it : MediaList) {
			if(itemsOrdered.contains(it)) {
				System.out.println(it.getTitle() + "has already exist!");
			}
			else {
				itemsOrdered.add(it);
			}
		}
		System.out.println("The media have been added !");
	}
	
	public float TotalCost () {
		float total = 0 ;
		for(Media media : itemsOrdered) {
			total += media.getCost();
		}
		return total ; 
	}
	
	public void searchByTitle(String keyword) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(keyword)) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Sorry, no media were found with \"" + keyword + "\" in the title!");
        }
	}
	
	public void printCart () {
		
		System.out.println("***********************CART***********************");
		for(Media media : itemsOrdered) {
			System.out.println(media.toString());	
		}
		System.out.println("Total cost : " +  TotalCost() + "$");
	}
	
	
	
	
}
