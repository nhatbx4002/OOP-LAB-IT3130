package hust.soict.dsai.aims;
import java.util.ArrayList;
import hust.soict.dsai.aims.media.*;


public class Aims {

	public static void main(String[] args) {

        ArrayList<Media> mediae = new ArrayList<>();


        CompactDisc cd = new CompactDisc("Greatest Hits");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Inception");
        Book book = new Book("To Kill a Mockingbird", "Harper Lee",1111);


        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);


        for (Media m : mediae) {
            System.out.println(m.toString());
        }
	}

}
