package hust.soict.dsai.aims.media;

public class Disc extends Media implements Playable {
    private int length;
    private String director;

    public Disc() {
        //TODO Auto-generated constructor stub
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Disc(String title, float cost) {
        super(title, cost);
    }
    
    public Disc(int id, String title, String category, float cost, int length, String director) {
        super(id, title, category, cost);
        this.length = length;
        this.director = director;
    }

    public Disc(String title, String category, float cost, int length, String director) {
        super(title, category, cost);
        this.length = length;
        this.director = director;
    }

    public void play() {
        System.out.println("Plying Disc: " + this.getTitle());
        System.out.println("Disc length: " + this.getLength());
    }
}