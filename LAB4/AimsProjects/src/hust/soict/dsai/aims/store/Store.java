package hust.soict.dsai.aims.store;
import java.util.*;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> items = new ArrayList<Media>();
	
	 public void addMedia(Media media) {
		 if(items.contains(media)) {
			 System.out.println(media.getTitle() + "has already exist!");
			 return;
		 }
		 items.add(media);
		 System.out.println("Add media successfully.");
		 return; 
	  }
	 
	 public void addMedia(Media[] mediaList) {
		 for(Media it : mediaList) {
			 if(items.contains(it)) {
				 System.out.println(it.getTitle() + "has already exist!");
				 return;
			 }
			 items.add(it);
		 }
		 System.out.println("Add media successfully!");
		 return ;
	 }
	 
	 public void removeMedia(Media media) {
		 if(items.size() == 0 ) {
			 System.out.println("Nothing to remove!");
			 return ;
		 }
	      if(!items.contains(media)) {
	    	  System.out.println(media.getTitle() + " not found in store!");
	      }else {
	    	  items.remove(media);
	    	  System.out.println("Remove " + media.getTitle() + " successfully.");
	      }
	      return ;
	    }
	 
	 public void removeMedia(String title) {
		 if(items.size() == 0 ) {
			 System.out.println("Nothing to remove!");
			 return ;
		 }
	      for(Media it : items) {
	    	  if(it.getTitle().equals(title)) { 
	    		  items.remove(it);
	    		  System.out.println(title + " has been removed.");
	    		  return ; 
	    	  }
	      }
	      System.out.println(title + "not found in store");
	      return ;
	    }
	 
	 public Media searchByTitle(String title) {
		 for(Media media : items) {
			 if(media.getTitle().equals(title)) return media;
		 }
		 return null;
	 }
}
