package libraryservice;

import model.Loanable;
import userauthentication.UserAuthenticator;

import java.util.ArrayList;

public class LibraryLoanableDatabase {
    ArrayList<Loanable> availableLoanables = new ArrayList<>();
    ArrayList<Loanable> loanablesOnLoan = new ArrayList<>();

    public LibraryLoanableDatabase(ArrayList<? extends Loanable> loanables) {
        availableLoanables.addAll(loanables);
    }

    public ArrayList<Loanable> getAvailableLoanables() {
        return availableLoanables;
    }

    public ArrayList<Loanable> getLoanablesOnLoan() {
        return loanablesOnLoan;
    }

    public boolean checkoutLoanable(int loanableId) {
        boolean succeededCheckout = false;

        for (Loanable loanable : availableLoanables) {
            if (loanable.getId() == loanableId) {
                availableLoanables.remove(loanable);
                loanablesOnLoan.add(loanable);

                loanable.setLoanerId(UserAuthenticator.currentUser.getLibraryId());

                succeededCheckout = true;
                break;
            }
        }

        return succeededCheckout;
    }

    public boolean returnLoanable(int loanableId) {
        boolean succeedReturn = false;

        for (Loanable loanable : loanablesOnLoan) {
            if (loanable.getId() == loanableId) {
                loanablesOnLoan.remove(loanable);
                availableLoanables.add(loanable);
                succeedReturn = true;
                break;
            }
        }

        return succeedReturn;
    }

}
