package hust.soict.dsai.aims.media;
import java.util.Comparator;

import hust.soict.dsai.aims.media.MediaComparatorByTitleCost;
import hust.soict.dsai.aims.media.MediaComparatorByCostTitle;
public abstract class Media  {
	public int id ; 
	public String title ; 
	public String category ; 
	public float cost ;
	private int mediaCount  = 0;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	//getter and setter method
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	
	//Constructor 
	public Media (String title) {
		this.id = ++mediaCount;
		this.title = title ;
	}
	public Media (String title , String category , float cost) {
		this.id = ++mediaCount;
		this.title = title ; 
		this.category = category; 
		this.cost = cost ; 
	}
	
	//toString 
	 public String toString() {
	        return "Media: " + this.getTitle() +
	                " - Category: " + this.getCategory() +
	                " - Cost: " + this.getCost() + "$";
	    }
	
	
	public boolean isMatch (String title) {
		return this.title.equals(title);
	}
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Media)) return false; 
		return (((Media)obj).getTitle() == this.getTitle());
	}
	
	
}
