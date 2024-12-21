package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    // create 
    public CompactDisc(String title, float price) {
        super(title, price);
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost, length, director);
    }

    public CompactDisc(int id, String title, String category, float cost, int length, String director, String artist, List<Track> tracks) {
        super(id, title, category, cost, length, director);
        this.artist = artist;
        this.tracks.addAll(tracks);
    }

    public boolean addTrack(Track track) {
        if(tracks.contains(track)) {
            System.out.println("Already exits");
            return false;
        } else {
            tracks.add(track);
            System.out.println("Track: " + track + " have been added");
            return true;
        }
    }

    public boolean removeTrack(Track track) {
        if(!tracks.contains(track)) {
            System.out.println("Not exits");
            return false;
        } else {
            tracks.add(track);
            System.out.println("Track: " + track + " have been removed");
            return true;
        }
    }

    public int getTotalLength() {
        int totalLength = 0;
        for(Track track: tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    public void play() {
        for(Track track : tracks) {
            System.out.println("Playing track: " + track.getTitle());
            track.play();
        }
    }
}
