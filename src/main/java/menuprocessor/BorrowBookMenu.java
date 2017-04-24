package menuprocessor;

import database.LibraryLoanableDatabase;
import model.Book;
import model.Loanable;
import tableStringFormatter.BookTableStringFormatter;

import java.util.ArrayList;

public class BorrowBookMenu implements Menu {
    public static String bookUnavailableMessage = "That book is not available";
    public static String bookCheckedOutMessage = "model.Book checked out. Enjoy your book!";

    LibraryLoanableDatabase libraryBookDatabase;
    MenuRouter menuRouter;

    public BorrowBookMenu(LibraryLoanableDatabase libraryBookDatabase, MenuRouter menuRouter) {
        this.libraryBookDatabase = libraryBookDatabase;
        this.menuRouter = menuRouter;
    }

    @Override
    public String getOptions() {
        String bookTable = getBookTable();

        return bookTable + "\n" +
                "Pick book to borrow" + "\n" +
                "0: Exit this menu";
    }

    private String getBookTable() {
        ArrayList<Loanable> availableLoanables = libraryBookDatabase.getAvailableLoanables();

        ArrayList<Book> bookList = new ArrayList<>();
        for (Loanable loanable : availableLoanables) {
            bookList.add((Book) loanable);
        }

        BookTableStringFormatter bookTableStringFormatter = new BookTableStringFormatter();
        return bookTableStringFormatter.getTable(bookList);
    }

    @Override
    public String getResponse(int bookMenuInput) {
        String menuMessage = "";
        boolean succeededCheckout = libraryBookDatabase.checkoutLoanable(bookMenuInput);

        if (succeededCheckout) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
            menuMessage = bookCheckedOutMessage;
        } else if (bookMenuInput == MenuRouter.EXIT) {
            menuRouter.setCurrentMenu(MenuRouter.MAIN_MENU);
        } else if (!succeededCheckout) {
            menuRouter.setCurrentMenu(MenuRouter.BORROW_BOOK_MENU);
            menuMessage = bookUnavailableMessage;
        }

        return menuMessage;
    }

}
