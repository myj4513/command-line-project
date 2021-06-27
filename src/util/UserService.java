package util;

import dto.User;

public class UserService {
    private static User currentUser;

    public static void login(User user) {
        currentUser = user;
    }

    public static boolean isCurrentUserLogin() {
        return currentUser != null;
    }

}
