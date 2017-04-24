package database;

import model.Loanable;
import model.Loanable;

import java.util.ArrayList;
import java.util.List;

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
