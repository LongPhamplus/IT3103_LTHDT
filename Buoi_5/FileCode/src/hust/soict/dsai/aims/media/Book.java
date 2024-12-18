package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class Book extends Media {

	private ArrayList<String> authors = new ArrayList<String>();
	
	public Book(int id, String title, String category, double cost, ArrayList<String> authors) {
		super(id, title, category, cost);
		this.authors = authors;
	}


	public ArrayList<String> getAuthors() {
		return authors;
	}

    public void addAuthor(String author) {
        if (author != null && !author.isEmpty()) {
            authors.add(author);
        }
    }
    
    public void removeAuthor(String author) {
        if (author != null && !author.isEmpty() && authors.contains(author)) {
            authors.remove(author);
            System.out.println("Remove Author successful !"); 
        }
        System.out.println("Remove Author failed !"); 
    }
}
