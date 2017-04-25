package menuprocessor;

import libraryservice.LibraryLoanableDatabase;
import model.Book;
import model.Loanable;
import tablestringformatter.BookTableStringFormatter;

import java.util.ArrayList;

public class ReturnBookMenu extends ReturnLoanableMenu {

    public ReturnBookMenu(LibraryLoanableDatabase libraryBookDatabase, MenuRouter menuRouter) {
        super(libraryBookDatabase, menuRouter);
    }

    protected String getLoanableTable() {
        ArrayList<Loanable> loanablesOnLoan = libraryLoanableDatabase.getLoanablesOnLoan();

        ArrayList<Book> bookList = new ArrayList<>();
        for (Loanable loanable : loanablesOnLoan) {
            bookList.add((Book) loanable);
        }

        BookTableStringFormatter bookTableStringFormatter = new BookTableStringFormatter();
        return bookTableStringFormatter.getTableWithLoaner(bookList);
    }

}
