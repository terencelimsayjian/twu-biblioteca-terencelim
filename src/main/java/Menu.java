public interface Menu {
    public String getOptions();

    public String getResponse(int userInput);

    public int getNextMenuId();
}
