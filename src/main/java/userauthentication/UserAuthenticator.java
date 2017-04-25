package userauthentication;

import model.User;

import java.util.ArrayList;

public class UserAuthenticator {
    public static String requiredLogin = "Please login to access that feature!";

    ArrayList<User> users = new ArrayList<>();
    public static User currentUser;

    public UserAuthenticator() {
        StaticUserData staticUserData = new StaticUserData();
        users.addAll(staticUserData.getUsers());
    }

    public boolean authenticate(String libraryIdInput, String passwordInput) {
        boolean authenticatedUser = false;

        for (User user : users) {
            if (user.validate(libraryIdInput, passwordInput)) {
                authenticatedUser = true;
                currentUser = user;
                break;
            }
        }

        return authenticatedUser;
    }

}
