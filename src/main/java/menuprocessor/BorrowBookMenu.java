package menuprocessor;

import database.LibraryLoanableDatabase;
import model.Book;
import model.Loanable;
import tableStringFormatter.BookTableStringFormatter;

import java.util.ArrayList;

public class BorrowBookMenu extends BorrowLoanableMenu implements Menu {
    public BorrowBookMenu(LibraryLoanableDatabase libraryBookDatabase, MenuRouter menuRouter) {
        super(libraryBookDatabase, menuRouter);
    }

    protected String getLoanableTable() {
        ArrayList<Loanable> availableLoanables = libraryLoanableDatabase.getAvailableLoanables();

        ArrayList<Book> bookList = new ArrayList<>();
        for (Loanable loanable : availableLoanables) {
            bookList.add((Book) loanable);
        }

        BookTableStringFormatter bookTableStringFormatter = new BookTableStringFormatter();
        return bookTableStringFormatter.getTable(bookList);
    }

}
