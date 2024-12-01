package hust.soict.dsai.aims.media;

public abstract class Media {
	public int id ; 
	public String title ; 
	public String category ; 
	public float cost ;
	private int mediaCount  = 0;
	
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
        return   this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }
	
	
	public boolean isMatch (String title) {
		return this.title.equals(title);
	}
	
}
