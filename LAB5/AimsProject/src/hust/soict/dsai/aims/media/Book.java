package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {
   
    private List<String> authors = new ArrayList<String>();

    // Default constructor
    public Book() {
        //super();
    }

    public Book(int id, String title, String category, float cost) {
        super(id, title, category, cost);
    }

    public Book(String title, float cost) {
        super(title, cost);
    }

    public boolean addAuthor(String name) {
        if(authors.contains(name)) {
            System.out.println("Already exits");
            return false;
        } else {
            authors.add(name);
            System.out.println("Author " + name + " has been added");
            return true;
        }
    }

    public boolean removeAuthor(String name) {
        if(!authors.contains(name)) {
            System.out.println("Author " + name + " does not exist");
            return false;
        } else {
            authors.remove(name);
            System.out.println("Author " + name + " has been removed");
            return true;
        }
    }
}
