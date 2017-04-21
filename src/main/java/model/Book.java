package model;

public class Book implements Loanable {
    private int id;
    private String title;
    private String author;
    private int yearPublished;

    public Book(int id, String title, String author, int yearPublished) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public String toString() {
        return id + " | " + title + " | " + author + " | " + yearPublished;
    }

}
