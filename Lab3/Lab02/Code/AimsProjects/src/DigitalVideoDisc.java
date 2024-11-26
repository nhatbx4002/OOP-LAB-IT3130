
public class DigitalVideoDisc {

	private String title ; 
	private String category; 
	private String director;
	private int length ; 
	private float cost ;
	private static int nbDigitalVideoDisc = 0 ; 
	private int id ; 
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id ; 
	}
	
	// Constructor method for DigitalVideoDisc for different purpose 
	// Add by title 
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	} 
	//Add by Category , title , cost 
	public DigitalVideoDisc(String category,String title, float cost) {
		super();
		this.title = title ;
		this.category = category; 
		this.cost = cost ; 
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;

	}
	//Add by director , category , title , cost 
	public DigitalVideoDisc(String director, String category,String title , float cost) {
		super();
		this.title = title;
		this.director = director ; 
		this.category = category ; 
		this.cost = cost ; 
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;

	} 
	// Add by director , category , title , float , cost 
	public DigitalVideoDisc(String title, String category,String director ,int length , float cost) {
		super();
		this.title = title;
		this.director = director ; 
		this.category = category ; 
		this.length = length;
		this.cost = cost ; 
		nbDigitalVideoDisc++;
		this.id = nbDigitalVideoDisc;
	} 
	//function take information and return String
	public String toString(){
	        return "DVD - " + title + " - " + category + " - " + director + " - " + length + " min: " + cost + " $";
    }
	
	//boolean isMatch return true if the corresponding disk is a match given the title
	public boolean isMatch (String title) {
		return this.title.equals(title);
	}
	public void  setTitle (String title) {
		this.title = title;
	}
}
