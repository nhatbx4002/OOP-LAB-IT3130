package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc {
	
	
	//Constructor 
	public DigitalVideoDisc (String title) {
		super(title);
	}
	public DigitalVideoDisc (String title, String category , float cost) {
		super(title,category,cost);
	}
	
	public DigitalVideoDisc (String title, String category , String director , float cost) {
		super(title,category,director,cost);
	}
	public DigitalVideoDisc (String title, String category ,String director , int length  , float cost) {
		super(title,category,director,length,cost);
	}
	
	public String toString() {
        return this.getId() + " - DVD: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Director: " + this.getDirector() +
                " - DVD length: " + this.getLength() +
                " - Cost: " + this.getCost() + "$";
    }
	
	//boolean isMatch return true if the corresponding disk is a match given the title
	public boolean isMatch (String title) {
		return this.title.equals(title);
	}
}
