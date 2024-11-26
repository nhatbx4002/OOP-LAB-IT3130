package hust.soict.dsai.aims.store;
import java.util.LinkedList;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private int MAX_NUMBERS_DVDs = 20 ; 
	private DigitalVideoDisc[] itemsInStore = new DigitalVideoDisc[20]; 
	
	private int numberOfDVDs = 0 ; 
	
	 public void addDVD(DigitalVideoDisc dvd) {
	        if (numberOfDVDs < MAX_NUMBERS_DVDs) {
	            itemsInStore[numberOfDVDs] = dvd;
	            numberOfDVDs++;
	            System.out.println(dvd.getTitle() + " has been added to the store.");
	        } else {
	            System.out.println("Store is full. Cannot add more DVDs.");
	        }
	    }
	 
	 public void removeDVD(String title) {
	        boolean found = false;
	        for (int i = 0; i < numberOfDVDs; i++) {
	            if (itemsInStore[i].getTitle().equalsIgnoreCase(title)) {
	                
	                for (int j = i; j < numberOfDVDs - 1; j++) {
	                    itemsInStore[j] = itemsInStore[j + 1];
	                }
	                itemsInStore[numberOfDVDs - 1] = null;  // Set the last element to null
	                numberOfDVDs--;
	                found = true;
	                System.out.println(title + " has been removed from the store.");
	                break;
	            }
	        }
	        
	        if (!found) {
	            System.out.println("DVD with title " + title + " not found in the store.");
	        }
	    }
	
}
