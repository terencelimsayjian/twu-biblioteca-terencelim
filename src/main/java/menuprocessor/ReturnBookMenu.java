package menuprocessor;

import database.LibraryLoanableDatabase;
import model.Book;
import model.Loanable;
import tableStringFormatter.BookTableStringFormatter;

import java.util.ArrayList;

public class ReturnBookMenu implements Menu {
    public static String invalidReturnBookMessage = "Not a valid book to return!";
    public static String bookReturnedMessage = "model.Book successfully returned. Thank you!";

    LibraryLoanableDatabase libraryBookDatabase;
    MenuRouter menuRouter;

    public ReturnBookMenu(LibraryLoanableDatabase libraryBookDatabase, MenuRouter menuRouter) {
        this.libraryBookDatabase = libraryBookDatabase;
        this.menuRouter = menuRouter;
    }

    @Override
    public String getOptions() {
        String bookTable = getBookTable();

        return bookTable + "\n" +
                "Pick book to return" + "\n" +
                "0: Exit this menu";
    }

    private String getBookTable() {
        ArrayList<Loanable> loanablesOnLoan = libraryBookDatabase.getLoanablesOnLoan();

        ArrayList<Book> bookList = new ArrayList<>();
        for (Loanable loanable : loanablesOnLoan) {
            bookList.add((Book) loanable);
        }

        BookTableStringFormatter bookTableStringFormatter = new BookTableStringFormatter();
        return bookTableStringFormatter.getTable(bookList);
    }

    @Override
    public String getResponse(int bookMenuInput){
        String menuMessage = "";
        boolean succeededReturn = libraryBookDatabase.returnLoanable(bookMenuInput);

        if (succeededReturn) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = bookReturnedMessage;
        } else if (bookMenuInput == MenuRouter.EXIT) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = "";
        } else if (!succeededReturn) {
            menuRouter.setCurrentMenu(MenuRouter.RETURN_BOOK_MENU);
            menuMessage = invalidReturnBookMessage;
        }

        return menuMessage;
    }

}
