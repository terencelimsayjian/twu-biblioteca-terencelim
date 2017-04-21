package tableStringFormatter;

public abstract class TableStringFormatter {
    public String divider = " | ";
    public int totalStringLength;

    public String buildDivider() {
        String dividerString = "";

        for (int i = 0; i < totalStringLength; i++) {
            dividerString += "-";
        }

        return dividerString;
    }

    protected String formatStringToFixedLength(String subject, int desiredTitleStringLength) {
        String titleString;

        if (subject.length() > desiredTitleStringLength) {
            titleString = subject.substring(0, desiredTitleStringLength - 3) + "...";
        } else {
            titleString = appendSpaces(subject, desiredTitleStringLength);
        }
        return titleString;
    }

    protected String appendSpaces(String subject, int desiredTitleStringLength) {
        int remainingSpaces = desiredTitleStringLength - subject.length();

        for (int i = 0; i < remainingSpaces; i++) {
            subject = subject + " ";
        }
        return subject;
    }

    public abstract String getTable();

    public abstract String buildHeader();

}
