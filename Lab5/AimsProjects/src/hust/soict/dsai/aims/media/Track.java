package hust.soict.dsai.aims.media;

public class Track implements Playable {

	private String title ; 
	private int length ;
	
	//getter method
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	
	
	//play method
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj == null) return false;
		if(!(obj instanceof Track)) return false; 
		return ((Track)obj).getTitle() == this.getTitle() && ((Track)obj).getLength() == this.getLength();
	}

}
