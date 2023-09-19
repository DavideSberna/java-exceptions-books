package org.java.book;

public class Book {
	private String title;
	private int nPage;
	private String author;
	private String publisher;
	
	public Book(String title, int nPage, String author, String publisher) {
		this.title = title;
		this.nPage = nPage;
		this.author = author;
		this.publisher = publisher;
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getnPage() {
		return nPage;
	}

	public void setnPage(int nPage) {
		this.nPage = nPage;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return getTitle() + " | " + getnPage() + " | " + getAuthor() + " | " + getPublisher();
	}
	
	

}
