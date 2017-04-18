import java.util.ArrayList;

public class BookDatabase {
    ArrayList<Book> books = new ArrayList<>();

    public BookDatabase() {
        Book book1 = new Book("Harry Potter", "J.K. Rowling", 2003);
        Book book2 = new Book("Lord Of The Rings", "J.R.R Tolkein", 1978);
        Book book3 = new Book("The Magicians", "Lev Grossman", 2006);
        Book book4 = new Book("American Gods", "Neil Gaiman", 2007);
        Book book5 = new Book("Assassin's Quest", "Robin Hobb", 2004);
        Book book6 = new Book("The Ocean At The End Of The Lane", "Neil Gaiman", 2015);
        Book book7 = new Book("The Runaway Jury", "John Grisham", 2001);
        Book book8 = new Book("Pride and Prejudice", "Jane Austen", 1813);
        Book book9 = new Book("The Merchant of Venice", "William Shakespeare", 1605);
        Book book10 = new Book("The Da Vinci Code", "Dan Brown", 2003);

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

    public ArrayList<Book> getBooks() {
        return books;
    }

    public String toString() {
        BookStringBuilder bookStringBuilder = new BookStringBuilder();
        String bookTable = "";

        bookTable = bookTable + bookStringBuilder.buildHeader() + "\n";
        bookTable = bookTable + bookStringBuilder.buildDivider() + "\n";

        for (Book book : books) {
            bookTable = bookTable + bookStringBuilder.build(book) + "\n";
        }

        bookTable = bookTable + bookStringBuilder.buildDivider();

        return bookTable;
    }
}