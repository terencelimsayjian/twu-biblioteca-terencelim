package userauthentication;

import model.User;

import java.util.ArrayList;

public class StaticUserData {
    ArrayList<User> users = new ArrayList<>();

    public StaticUserData() {
        User user1 = new User("terence", "111-1111", "test123");
        User user2 = new User("amanda", "222-2222", "test123");
        User user3 = new User("denise", "333-3333", "test123");
        User user4 = new User("gemeng", "444-4444", "test123");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}
