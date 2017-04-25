package model;

public class User {
    private String name;
    private String libraryId;
    private String password;

    public User(String name, String libraryId, String password) {
        this.name = name;
        this.libraryId = libraryId;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getLibraryId() {
        return libraryId;
    }

    public boolean validate(String libraryIdInput, String passwordInput) {
        boolean userValidated = false;

        if (libraryIdInput.equals(libraryId) && passwordInput.equals(password)) {
            userValidated = true;
        }

        return userValidated;
    }

    public String toString() {
        return "Name: " + name + "\n" + "Library ID: " + libraryId;
    }
}
