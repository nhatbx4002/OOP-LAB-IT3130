package hust.soict.dsai.aims.media;

import java.util.*;
public class CompactDisc extends Disc implements Playable {
	
	private String artist ; 
	private List<Track> tracks = new ArrayList<Track>();
	//getter method 
	public String getArtist() {
		return artist;
	}

	public List<Track> getTracks() {
		return tracks;
	}
	
	// Constructor
	public CompactDisc(String title) {
		super(title);
	}
	
	public CompactDisc(String title, String category , float cost) {
		super(title,category,cost);
	}
	public CompactDisc(String title, String category ,String director, float cost) {
		super(title,category,director,cost);
	}
	public CompactDisc(String title, String category ,String director,int length ,float cost) {
		super(title,category,director,length,cost);
	}
	
	//addTrack method
	public void addTrack (Track track) {
		boolean check = false ; 
		for(Track tr : tracks) {
			if(tr.equals(track)) {
				check = true ; 
				break ; 
			}
		}
		if(!check) {
			tracks.add(track);
			System.out.println("Track " + track.getTitle() + " has been added.");
			return ; 
		}
		else {
			System.out.println("Track" + track.getTitle() + " has already exist.");
			return ; 
		}
	}
	
	//remove method
	public void removeTrack (Track track) {
		boolean check = false ; 
		for(Track tr : tracks) {
			if(tr.equals(track)) {
				check = true ;
				break ; 
			}
		}
		if(check) {
			tracks.remove(track);
			System.out.println("Track" + track.getTitle() + "has been removed.");
			return ; 
		}else {
			System.out.println("Track" + track.getTitle() + "hasn't exist.");
		}
	}
	
	//getLength method ;
	public int getLength() {
		int sumLength = 0 ; 
		for(Track tr : tracks) {
			sumLength += tr.getLength() ;
		}
		return sumLength;
	}
	
	public void play() {
		for(Track track : tracks) {
			track.play();
		}
	}
	
	
    public String toString() {
        return " CD: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Artist" + this.getArtist() +
                " - Length: " + this.getLength() + " seconds" + 
                " - Cost: " + this.getCost() + "$";
    }
}
