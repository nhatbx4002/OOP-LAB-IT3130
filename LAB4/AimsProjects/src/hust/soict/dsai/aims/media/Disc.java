package hust.soict.dsai.aims.media;

public class Disc extends Media {

	private int length ; 
	private String director ; 
	
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	
	//constructor 
	public Disc (String title) {
		this.title = title ; 
	}
	
	public Disc (String title, String category , float cost ) {
		this.title = title ; 
		this.category = category;
		this.cost = cost ; 
	}
	
	public Disc (String title , String category , String director  ,float cost ) {
		this.title = title ; 
		this.category = category;
		this.cost = cost ; 
		this.director = director ; 
	}
	
	public Disc (String title , String category , String director , int length ,float cost ) {
		this.title = title ; 
		this.category = category;
		this.cost = cost ; 
		this.director = director ; 
		this.length = length ; 
	}
}
