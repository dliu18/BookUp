package com.example.hackprinceton;

public class Books {
	private String title;          
	private String author; 
	private int edition;  
	private String ISBN;     
	private String course;
	private static int bookCount; 

	public Books (String ti, String au, int ed, String IS, String co) {
		title = ti;
		author = au; 
		edition = ed;
		ISBN = IS;
		course = co;
		bookCount++;
	}

	public String returnTitle() {
		return title;
	}

	public String returnAuthor() {
		return author;
	}

	public int returnEdition() {
		return edition;
	}

	public String returnISBN() {
		return ISBN;
	}

	public String returnCourse() {
		return course;
	}

	public static int returnBookCount() {
		return bookCount;
	}
}