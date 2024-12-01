package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;


public class Book extends Media{
	
	private List<String> authors = new ArrayList<>();
	
	public void addAuthors(String authorName) {
		boolean check = false;
		for(String author : authors) {
			if(author.equals(authorName)) {
				check = true ; 
				break;
			}
		}
		if(!check) {
			authors.add(authorName);
			System.out.println("Add author successfully");
		}else {
			System.out.println("Author name already exists");
		}
		return ; 
	}
	
	public void removeAuthors(String authorName) {
		for(int i = 0 ; i < authors.size() ; i++) {
			if(authors.get(i).equals(authorName)) {
				authors.remove(i);
				System.out.println("Remove author successfully");
				return ;
			}
		}
		System.out.println("Author not found");
	}
}