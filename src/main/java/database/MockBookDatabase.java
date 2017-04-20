package database;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class MockBookDatabase {
    ArrayList<Book> books = new ArrayList<>();

    public MockBookDatabase() {
        Book book1 = new Book(1,  "Harry Potter", "J.K. Rowling", 2003);
        Book book2 = new Book(2,  "Lord Of The Rings", "J.R.R Tolkein", 1978);
        Book book3 = new Book(3, "The Magicians", "Lev Grossman", 2006);
        Book book4 = new Book(4, "American Gods", "Neil Gaiman", 2007);
        Book book5 = new Book(5, "Assassin's Quest", "Robin Hobb", 2004);
        Book book6 = new Book(6, "The Ocean At The End Of The Lane", "Neil Gaiman", 2015);
        Book book7 = new Book(7, "The Runaway Jury", "John Grisham", 2001);
        Book book8 = new Book(8, "Pride and Prejudice", "Jane Austen", 1813);
        Book book9 = new Book(9, "The Merchant of Venice", "William Shakespeare", 1605);
        Book book10 = new Book(10, "The Da Vinci Code", "Dan Brown", 2003);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);
        books.add(book6);
        books.add(book7);
        books.add(book8);
        books.add(book9);
        books.add(book10);
    }

    public List<Book> getBooks() {
        return books;
    }
}
