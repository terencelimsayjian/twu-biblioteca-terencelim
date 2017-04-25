package userauthentication;

import model.User;

import java.util.ArrayList;

public class UserAuthenticator {
    ArrayList<User> users = new ArrayList<>();

    public UserAuthenticator() {
        StaticUserData staticUserData = new StaticUserData();
        users.addAll(staticUserData.getUsers());
    }

    public User authenticate(String libraryIdInput, String passwordInput) {
        User authenticatedUser = null;

        for (User user : users) {
            if (user.validate(libraryIdInput, passwordInput)) {
                authenticatedUser = user;
                break;
            }
        }

        return authenticatedUser;
    }

}
